package com.mujae.member.service;

import java.util.List;

import com.mujae.member.dto.MemberDTO;

public interface MemberService {
	int idCheck(String id);

	int memberJoin(MemberDTO mdto) throws Exception;

	MemberDTO getMember(MemberDTO mdto);

	String searchId(MemberDTO mdto);

	int updatePasswd(MemberDTO mdto);

	List<MemberDTO> getMembers(MemberDTO mdto);

	int memUpProc(MemberDTO mdto);

	int memDelete(MemberDTO mdto);

}
