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
	public int idCheck(String id) {
		
		return memberMapper.idCheck(id);
	}

	@Override
	public int memberJoin(MemberDTO mdto) {
		// TODO Auto-generated method stub
		return memberMapper.memberJoin(mdto);
	}

	@Override
	public MemberDTO getMember(MemberDTO mdto) {
		
		String id = mdto.getId();
		String pwd = mdto.getPwd();

		System.out.println("b");

		System.out.println("id"+id);
		System.out.println("pwd"+pwd);

		System.out.println("result"+memberMapper.getMember(id,pwd));

		return memberMapper.getMember(id,pwd);
	}

	@Override
	public String searchId(MemberDTO mdto) {
		
		return memberMapper.searchId(mdto);
	}

	@Override
	public int updatePasswd(MemberDTO mdto) {
		
		return memberMapper.updatePasswd(mdto);
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