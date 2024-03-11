package com.mujae.member.controller;

import com.mujae.member.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mujae.member.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	//private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService memberService;

	@RequestMapping("loginProc")
	public String loginProc(HttpServletRequest request, HttpServletResponse response, MemberDTO mdto, Model model) {
		// 세션 정보(ssKey) - 회원정보
		HttpSession session = request.getSession();
		MemberDTO sdto = memberService.getMember(mdto);
		String url = "/";
		String msg;

		if (sdto != null) {

			MemberDTO ssKey = new MemberDTO();
			ssKey.setId(sdto.getId());
			ssKey.setPwd(sdto.getPwd());
			ssKey.setName(sdto.getName());
			ssKey.setUser_code(sdto.getUser_code());
			msg = sdto.getName() + "님 반갑습니다";

			session.setAttribute("ssKey", ssKey);
		} else
			msg = "아이디 또는 패스워드 맞지 않습니다";

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		return "MsgPage";
	}

	@RequestMapping("/logoutProc")
	public String logoutProc(HttpServletRequest request, HttpServletResponse response, MemberDTO mdto, Model model) {
		// 세션정보 (ssKey) - 회원정보
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";

	}

	@RequestMapping("login")
	public String login(HttpServletRequest request, HttpServletResponse response, MemberDTO mdto, Model model) {

		return "Login";

	}
	@RequestMapping("/register")
	public String registerProc(HttpServletRequest request, HttpServletResponse response,
							   Model model, MemberDTO mdto) {
		try {
			int r= memberService.memberJoin(mdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/";
	}

	@RequestMapping("memSearchProc")
	public String memSearchProc(HttpServletRequest request, HttpServletResponse response, MemberDTO mdto, Model model) {
		// 회원이 맞으면 비밀번호 새로 설정 페이지
		// 회원정보가 맞지 않으면 회원가입

		return "Login";

	}

	@RequestMapping("/info")
	public String info(HttpServletRequest request, HttpServletResponse response, Model model) {
		// info
		// 세션 키에 데이터를 갖고 있고 그 데이터를 불러와서 해당되는 고객의
		// 정보를 가져오고s
		HttpSession session = request.getSession();
		MemberDTO custom = (MemberDTO) session.getAttribute("ssKey");
		// 데이터베이스에서 해당되는 mdto에 있는 정보를 가지고 해당 고객 정보 가져오기
		String url = null;
		String msg = null;
		String page = null;
		if (custom != null) {
			// 저장해서 화면에서 가져올 수 있도록 한다
			// 회원정보를 갖고 있는 페이지(jsp를 따로 만들기(MemberInfo))
			MemberDTO mdto = memberService.getMember(custom);
			model.addAttribute("mdto", mdto);
			model.addAttribute("contentsJsp", "Info");
			page = "Main";
		} else {
			msg = "로그인 먼저 필요합니다";
			url = "/login";
			model.addAttribute("msg", msg);
			model.addAttribute("url", url);
			page = "MsgPage";
			session.setAttribute("ssKey", custom);
		}
		return page;

	}

	@RequestMapping("searchProc")
	public String searchProc(HttpServletRequest request, HttpServletResponse response, MemberDTO mdto, Model model) {
		int r = 0;
		String id = null;
		String msg = null;
		String url = "/";

		if (mdto != null) {
			if (mdto.getId() != null) { // 비밀번호 설정
				r = memberService.updatePasswd(mdto);
				msg = "비밀번호가 변경되었습니다";
			} else { // 아이디 찾아서 리턴
				id = memberService.searchId(mdto);
				if (id != null)
					msg = "회원아이디 : " + id;
				else
					msg = "회원정보가 없습니다";
				url = "memSearch";

			}
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "MsgPage";

	}

	@RequestMapping("/pwCheck")
	public String pwCheck(HttpServletRequest request, Model model) {
		return "PwCheck";

	}
	@RequestMapping("/memUpForm")
	public String memUpForm(HttpServletRequest request, HttpServletResponse response, Model model) {
		// session정보 갖고오기
		HttpSession session = request.getSession();
		MemberDTO custom = (MemberDTO) session.getAttribute("ssKey");
		// 세션정보를 기준으로 회원 정보 가져오기
		String page = null;
		String msg = null;
		String url = null;
		if(custom!=null) {
			MemberDTO mdto = memberService.getMember(custom);
			model.addAttribute("mdto", mdto);
			model.addAttribute("contentsJsp", "Update");
			page = "Main";
		}else {
			msg = "로그인 먼저 필요합니다.";
			url = "/login";
			model.addAttribute("msg", msg);
			model.addAttribute("url", url);
			page = "MsgPage";
		}
		session.setAttribute("ssKey", custom);
		return page;
	}

	@RequestMapping("/memUpProc")
	public String memUpProc(HttpServletRequest request, HttpServletResponse response,
							Model model,
							MemberDTO mdto) {
		// session정보 갖고오기
		HttpSession session = request.getSession();
		MemberDTO custom = (MemberDTO) session.getAttribute("ssKey");
		// 세션정보를 기준으로 회원 정보 가져오기
		String page = null;
		String msg = null;
		String url = null;
		if(custom!=null) {
			int r = memberService.memUpProc(mdto);
			if(r>0) {
				msg="회원정보가 수정되었습니다.";
				session.invalidate();
			}
			else {
				msg ="수정되지 않았습니다. \\n 관리자에게 문의바랍니다.";
			}
			url = "/";
		}else {
			msg = "로그인 먼저 필요합니다.";
			url = "/login";
		}
		page = "MsgPage";
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return page;
	}

	@RequestMapping("/memdelete")
	public String memdelete(HttpServletRequest request, HttpServletResponse response,
							Model model,
							MemberDTO mdto) {
		// session정보 갖고오기
		HttpSession session = request.getSession();
		MemberDTO custom = (MemberDTO) session.getAttribute("ssKey");
		// 세션정보를 기준으로 회원 정보 가져오기
		String page = null;
		String msg = null;
		String url = null;
		if(custom!=null) {
			int r = memberService.memDelete(custom);
			if(r>0) {
				msg="회원이 탈퇴 처리 되었습니다";
				session.invalidate();
			}
			else {
				msg ="탈퇴할 수 없습니다. \\n 관리자에게 문의바랍니다.";
			}
			url = "/";
		}else {
			msg = "로그인 먼저 필요합니다.";
			url = "/login";
		}
		page = "MsgPage";
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return page;
	}

	@RequestMapping("/idCheck")
	@ResponseBody
	public int idCheck(HttpServletRequest request, HttpServletResponse response,
					   Model model, MemberDTO mdto) {
		int cnt = 0;
		if(mdto.getId()!=null) {
			cnt =memberService.idCheck(mdto.getId());
		}
		return cnt;
	}


}
