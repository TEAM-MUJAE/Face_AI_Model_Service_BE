package com.mujae.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mujae.member.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	int memberJoin(MemberDTO mdto); //회원가입

	MemberDTO getMember(MemberDTO mdto); //회원정보 가져오기

	int memUpProc(MemberDTO mdto); //회원정보 수정

	int memDelete(MemberDTO mdto); //탈퇴하기

    MemberDTO selectUser();

	MemberDTO findByEmail(String email); //이메일 중복
	MemberDTO findByUserId(String id); //아이디 중복

	MemberDTO findByPhone(String phone); //전화번호 중복

}