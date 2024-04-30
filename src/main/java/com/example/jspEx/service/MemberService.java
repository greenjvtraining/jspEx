package com.example.jspEx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jspEx.dao.IMemberDao;
import com.example.jspEx.dto.LoginDto;
import com.example.jspEx.dto.MemberDto;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MemberService {
	
	@Autowired
	private IMemberDao memberDao;
	
	public List<MemberDto> getMemberList(){
		return memberDao.getMemberList();
	}
	
	public MemberDto getMember(String id) {
		return memberDao.getMember(id);
	}
	
	public int loginCheck(LoginDto dto) {
		log.info("dto : " + dto);
		return memberDao.loginCheck(dto);
	}
}
