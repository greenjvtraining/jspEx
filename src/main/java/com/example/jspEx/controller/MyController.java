package com.example.jspEx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jspEx.dto.LoginDto;
import com.example.jspEx.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MyController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/")
	public String root() {
		log.info("root....");
		return "index";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		log.info("login Get.....");
		return "login_form";
	}
	
	@PostMapping("/login")
	public String loginDo(LoginDto dto, HttpServletRequest request) {
		log.info("login Post.....");
		log.info("dto : " + dto);
		String view = "login_form";
		
		int result = memberService.loginCheck(dto);
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", dto.getId());
			
			view = "redirect:/member/list";
		}
		
		return view;
	}
}
