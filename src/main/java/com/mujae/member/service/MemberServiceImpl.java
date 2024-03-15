package com.mujae.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mujae.member.dao.MemberDAO;
import com.mujae.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDao;
	
	@Override
	public int idCheck(String id) {
		
		return memberDao.idCheck(id);
	}

	@Override
	public int memberJoin(MemberDTO mdto) {
		// TODO Auto-generated method stub
		return memberDao.memberJoin(mdto);
	}

	@Override
	public MemberDTO getMember(MemberDTO mdto) {
		
		return memberDao.getMember(mdto);
	}

	@Override
	public String searchId(MemberDTO mdto) {
		
		return memberDao.searchId(mdto);
	}

	@Override
	public int updatePasswd(MemberDTO mdto) {
		
		return memberDao.updatePasswd(mdto);
	}

	@Override
	public int memUpProc(MemberDTO mdto) {
		return memberDao.memUpProc(mdto);
	}

	@Override
	public int memDelete(MemberDTO mdto) {
		return memberDao.memDelete(mdto);
	}

}