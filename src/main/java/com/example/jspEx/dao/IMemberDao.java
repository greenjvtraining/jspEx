package com.example.jspEx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.jspEx.dto.LoginDto;
import com.example.jspEx.dto.MemberDto;

@Mapper
public interface IMemberDao {
	public List<MemberDto> getMemberList();
	public MemberDto getMember(String id);
	public int loginCheck(@Param("dto")LoginDto dto);
}
