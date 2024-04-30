package com.example.jspEx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.jspEx.dto.NoticeDto;

@Mapper
public interface INoticeDao {
	
	public List<NoticeDto> getNoticeList();
	public void saveNotice(@Param("notice") NoticeDto notice);
	public NoticeDto getNotice(int nno);
}
