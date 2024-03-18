package com.mujae.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mujae.member.dao.MemberMapper;
import com.mujae.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;

	@Override
	public int memberJoin(MemberDTO mdto)throws Exception {
		// 중복 검사
		if (!isEmailAvailable(mdto.getEmail()) || !isUserIdAvailable(mdto.getId()) || !isPhoneAvailable(mdto.getPhone())) {
			System.out.println("중복된 이메일, 아이디 또는 전화번호입니다.");
			return 0; // 중복된 경우, 영향 받은 행 없음으로 처리
		}

		int result = memberMapper.memberJoin(mdto);
		System.out.println("회원가입 결과: " + result);

		// 회원 정보 데이터베이스에 저장
		return result; // 영향 받은 행의 수 반환
	}
	private boolean isEmailAvailable(String email) {
		// 이메일 중복 검사 로직 구현
		// 예: memberMapper.findByEmail(email)을 이용하여 검사
		return memberMapper.findByEmail(email) == null;
	}

	private boolean isUserIdAvailable(String  id) {
		// 아이디 중복 검사 로직 구현
		// 예: memberMapper.findByUsername(username)을 이용하여 검사
		return memberMapper.findByUserId(id) == null;
	}
	private boolean isPhoneAvailable(String phone) {
		// 전화번호 중복 검사 로직 구현
		// 예: memberMapper.findByPhone(phone)을 이용하여 검사
		return memberMapper.findByPhone(phone) == null;
	}


	@Override
	public MemberDTO getMember(MemberDTO mdto) {
		
			return memberMapper.getMember(mdto);
		
	}

	@Override
	public int memUpProc(MemberDTO mdto) {
		return memberMapper.memUpProc(mdto);
	}

	@Override
	public int memDelete(MemberDTO mdto) {
		return memberMapper.memDelete(mdto);
	}

	@Override
	public MemberDTO getMemberList(){
		return memberMapper.selectUser();
	}

}