package com.mujae.member.service;

import com.mujae.member.controller.JoinResponse;
import com.mujae.member.dto.MemberDTO;


public interface MemberService {

	JoinResponse memberJoin(MemberDTO mdto) throws Exception; //회원가입

	MemberDTO getMember(MemberDTO mdto); //회원정보 가져오기

	int memUpProc(MemberDTO mdto); //회원정보 수정

	int memDelete(MemberDTO mdto); //탈퇴

    MemberDTO getMemberList();
}