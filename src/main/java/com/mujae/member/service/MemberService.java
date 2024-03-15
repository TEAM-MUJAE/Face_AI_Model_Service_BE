package com.mujae.member.service;

import java.util.List;

import com.mujae.member.dto.MemberDTO;

public interface MemberService {
	int idCheck(String id); //아이디 체크

	int memberJoin(MemberDTO mdto) throws Exception; //회원가입

	MemberDTO getMember(MemberDTO mdto); //회원정보 가져오기

	String searchId(MemberDTO mdto); //아이디 찾기

	int updatePasswd(MemberDTO mdto); //비밀번호 수정

	int memUpProc(MemberDTO mdto); //회원정보 수정

	int memDelete(MemberDTO mdto); //탈퇴

}
