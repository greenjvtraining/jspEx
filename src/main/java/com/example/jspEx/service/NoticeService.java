package com.example.jspEx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jspEx.dao.INoticeDao;
import com.example.jspEx.dao.IReplyDao;
import com.example.jspEx.dto.NoticeDto;

@Service
public class NoticeService {
	
	@Autowired
	private INoticeDao noticeDao;
	@Autowired
	private IReplyDao replyDao;
	
	public List<NoticeDto> getNoticeList(){
		List<NoticeDto> noticeList = noticeDao.getNoticeList();
		return noticeList;
	}
	
	public void registNotice(NoticeDto notice) {
		noticeDao.saveNotice(notice);
	}

	public NoticeDto getNotice(int nno) {
		NoticeDto noticeDto = noticeDao.getNotice(nno);
		
		return noticeDto;
	}
}
