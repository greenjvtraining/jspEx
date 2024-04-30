package com.example.jspEx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.jspEx.dto.ReplyDto;

@Mapper
public interface IReplyDao {
	public void saveReply(@Param("reply") ReplyDto reply);
	public List<ReplyDto> getReplyList(int nno);
	public void deleteReply(int rno);
}
