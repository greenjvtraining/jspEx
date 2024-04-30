package com.example.jspEx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jspEx.dao.IReplyDao;
import com.example.jspEx.dto.ReplyDto;

@Service
public class ReplyService {
	
	@Autowired
	private IReplyDao replyDao;
	
	public void saveReply(@Param("reply") ReplyDto reply) {
		replyDao.saveReply(reply);
	}
	
	public List<ReplyDto> getReplyList(int nno){
		
		return replyDao.getReplyList(nno);
	}
	
	public void deleteReply(int rno) {
		replyDao.deleteReply(rno);
	}
}
