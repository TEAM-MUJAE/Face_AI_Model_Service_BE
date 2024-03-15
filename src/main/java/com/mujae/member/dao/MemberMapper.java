package com.mujae.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mujae.member.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	int idCheck(String id); //아이디 체크

	int memberJoin(MemberDTO mdto); //회원가입

//	MemberDTO getMember(MemberDTO mdto); //회원정보 가져오기



	String searchId(MemberDTO mdto); //아이디 찾기

	int updatePasswd(MemberDTO mdto); //비밀번호 수정

	int memUpProc(MemberDTO mdto); //회원정보 수정

	int memDelete(MemberDTO mdto); //탈퇴하기


//	MemberDTO getMember(MemberDTO mdto);

    MemberDTO selectUser();

	MemberDTO getMember(String id, String pwd);
}