package com.example.jspEx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jspEx.dto.NoticeDto;
import com.example.jspEx.dto.ReplyDto;
import com.example.jspEx.service.NoticeService;
import com.example.jspEx.service.ReplyService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping("/list")
	public void noticeList(Model model) {
		log.info("noticeList.......");
		List<NoticeDto> noticeList = noticeService.getNoticeList();
		
		model.addAttribute("noticeList", noticeList);
	}
	
	@RequestMapping("/detail")
	public void noticeDetail(@RequestParam("nno") int nno, Model model) {
		log.info("noticeDetail.........");
		NoticeDto notice = noticeService.getNotice(nno);
		List<ReplyDto> replyList = replyService.getReplyList(nno);
		model.addAttribute("notice", notice);
		model.addAttribute("replyList", replyList);
	}
	
	@GetMapping("/regist")
	public String noticeRegistForm() {
		log.info("noticeRegForm......");
		return "/notice/regist_form";
	}
	
	@PostMapping("/regist")
	public String noticeRegistDo(NoticeDto notice) {
		log.info("noticeReg....");
		
		noticeService.registNotice(notice);
		return "redirect:/notice/list";
	}
	
	@RequestMapping("/reg_reply")
	public @ResponseBody List<ReplyDto> registReply(HttpServletRequest request) {
		log.info("regist Reply.....");
		
		String snno = request.getParameter("nno");
		int nno = Integer.parseInt(snno);
		String comment = request.getParameter("comment");
		String writer = request.getParameter("writer");
		
		ReplyDto reply = new ReplyDto(nno, comment, writer, null);
		System.out.println("reply: " + reply);
		replyService.saveReply(reply);
		
		List<ReplyDto> replyList = replyService.getReplyList(nno);
		
		return replyList;
	}
	
	@RequestMapping("/del_reply")
	public @ResponseBody List<ReplyDto> deleteReply(HttpServletRequest request){
		log.info("delete Reply........");
		
		String rno_ = request.getParameter("rno");
		int rno = Integer.parseInt(rno_);
		String nno_ = request.getParameter("nno");
		int nno = Integer.parseInt(nno_);
		
		replyService.deleteReply(rno);
		List<ReplyDto> replyList = replyService.getReplyList(nno);
		
		return replyList;
	}
}
