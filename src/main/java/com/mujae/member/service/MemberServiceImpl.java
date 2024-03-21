package com.mujae.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mujae.member.dao.MemberMapper;
import com.mujae.member.dto.MemberDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;

	@Override
	public int memberJoin(MemberDTO mdto) throws Exception {
		// 이메일 중복 검사
		if (!isEmailAvailable(mdto.getEmail())) {
			return -1; // 이메일 중복
		}
		// 아이디 중복 검사
		if (!isUserIdAvailable(mdto.getId())) {
			return -2; // 아이디 중복
		}
		// 전화번호 중복 검사
		if (!isPhoneAvailable(mdto.getPhone())) {
			return -3; // 전화번호 중복
		}

		// 중복이 없으면 회원가입 처리
		int result = memberMapper.memberJoin(mdto);
		return result > 0 ? result : 0; // 성공적으로 추가된 경우, 영향 받은 행의 수 반환
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
		// 현재 사용자의 정보를 데이터베이스에서 조회
		MemberDTO currentInfo = memberMapper.getMember(mdto);

		// 이메일 중복 검사
		if (!mdto.getEmail().equals(currentInfo.getEmail()) &&
				memberMapper.findByEmail(mdto.getEmail()) != null) {
			return -1; // 이메일 중복
		}

//		 아이디 중복 검사 (아이디 변경이 허용되는 경우에만)
		 if (!mdto.getId().equals(currentInfo.getId()) &&
		     memberMapper.findByUserId(mdto.getId()) != null) {
		     return -2; // 아이디 중복
		 }

		// 전화번호 중복 검사
		if (!mdto.getPhone().equals(currentInfo.getPhone()) &&
				memberMapper.findByPhone(mdto.getPhone()) != null) {
			return -3; // 전화번호 중복
		}

		// 중복이 없을 경우 회원 정보 업데이트
		int result = memberMapper.memUpProc(mdto);
		return result > 0 ? result : 0; // 업데이트 성공 여부 반환
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