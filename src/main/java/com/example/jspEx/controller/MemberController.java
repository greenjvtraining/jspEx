package com.example.jspEx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jspEx.dto.MemberDto;
import com.example.jspEx.service.MemberService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/list")
	public void memberList(Model model) {
		log.info("member list......");
		
		List<MemberDto> memberList = memberService.getMemberList();
		log.info("memberList : " + memberList);
		model.addAttribute("memberList", memberList);
	}
}
