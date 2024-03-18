package com.mujae.member.controller;

import com.mujae.member.dto.MemberDTO;
import com.mujae.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {
	//private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService memberService;

	@PostMapping("/login") //로그인
	public ResponseEntity<?> login(HttpServletRequest request, @RequestBody MemberDTO mdto) {
		HttpSession session = request.getSession();

		System.out.println("request"+request);

		System.out.println("mdto"+mdto);

//		MemberDTO sdto = memberService.getMemberList(); // Assuming this returns the logged-in user's details
		MemberDTO sdto = memberService.getMember(mdto); // Assuming this returns the logged-in user's details



		if (sdto != null) {
			// Successful login
			MemberDTO ssKey = new MemberDTO();
			ssKey.setId(sdto.getId());
			ssKey.setPwd(sdto.getPwd());
			ssKey.setName(sdto.getName());
			ssKey.setUser_code(sdto.getUser_code());

			session.setAttribute("ssKey", ssKey);

			// Creating a response object to return
			Map<String, Object> response = new HashMap<>();
			response.put("message", sdto.getName() + "님 반갑습니다");
			response.put("user", ssKey); // Optionally include user details

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			// Login failed
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body(Collections.singletonMap("message", "아이디 또는 패스워드 맞지 않습니다"));
		}
	}

	@PostMapping("/register") //회원가입
	public ResponseEntity<?> register(HttpServletRequest request, HttpServletResponse response,
							   Model model, @RequestBody MemberDTO mdto) {

		System.out.println("불러오니"+mdto);


		try {
			int affectedRows = memberService.memberJoin(mdto);

			System.out.println("------"+affectedRows);

			if (affectedRows > 0) {
				// 회원가입 성공
				return ResponseEntity
						.status(HttpStatus.CREATED)
						.body(Collections.singletonMap("message", mdto.getName() + "님의 회원가입을 축하합니다"));
			} else {
				// 회원가입 실패 (중복된 사용자명 또는 이메일)
				return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body(Collections.singletonMap("message", "회원가입에 실패했습니다"));
			}
		} catch (Exception e) {
			// 예외 처리
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Collections.singletonMap("message", "서버 오류로 인한 회원가입 실패"));
		}
	}

	@GetMapping("/info") // 회원정보 불러오기
	public ResponseEntity<?> info(HttpServletRequest request, HttpServletResponse response, Model model) {
		// 세션 키에 데이터를 갖고 있고 그 데이터를 불러와서 해당되는 고객의 정보를 가져오고
		HttpSession session = request.getSession();
		MemberDTO custom = (MemberDTO) session.getAttribute("ssKey");

		if (custom != null) {
			// 세션에 로그인한 사용자 정보가 저장되어 있음
			// 해당 사용자의 정보를 데이터베이스에서 가져와서 화면에 표시
			MemberDTO mdto = memberService.getMember(custom);
			model.addAttribute("mdto", mdto);
			return ResponseEntity.ok(mdto); // 회원 정보를 JSON 형태로 응답
		} else {
			// 로그인하지 않은 경우
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body(Collections.singletonMap("message", "로그인이 필요합니다"));
		}
	}

	@PostMapping("/memUpProc") //회원정보 수정
	public ResponseEntity<?> memUpProc(HttpServletRequest request, HttpServletResponse response, @RequestBody MemberDTO mdto) {
		HttpSession session = request.getSession();
		MemberDTO custom = (MemberDTO) session.getAttribute("ssKey");
		if (custom != null) {
			// 로그인한 사용자가 있는지 확인
			mdto.setId(custom.getId()); // ID 설정
			int affectedRows = memberService.memUpProc(mdto);

			if (affectedRows > 0) {
				// 회원 정보 수정 성공
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(Collections.singletonMap("message", "회원 정보가 성공적으로 수정되었습니다"));
			} else {
				// 회원 정보 수정 실패
				return ResponseEntity
						.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body(Collections.singletonMap("message", "회원 정보 수정에 실패했습니다"));
			}
		} else {
			// 로그인하지 않은 사용자인 경우
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body(Collections.singletonMap("message", "로그인이 필요합니다"));
		}
	}

	@PostMapping("/memDelete") //탈퇴하기
	public ResponseEntity<?> memDelete(HttpServletRequest request, HttpServletResponse response, Model model) {
		// 세션 정보 가져오기
		HttpSession session = request.getSession();
		MemberDTO custom = (MemberDTO) session.getAttribute("ssKey");

		if (custom != null) {
			int affectedRows = memberService.memDelete(custom);
			if (affectedRows > 0) {
				// 회원 탈퇴 성공
				session.invalidate(); // 세션 무효화
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(Collections.singletonMap("message", "회원이 탈퇴 처리되었습니다"));
			} else {
				// 회원 탈퇴 실패
				return ResponseEntity
						.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body(Collections.singletonMap("message", "탈퇴할 수 없습니다. 관리자에게 문의하세요"));
			}
		} else {
			// 로그인되지 않은 상태
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body(Collections.singletonMap("message", "로그인이 필요합니다"));
		}

	}
}
