package com.example.jspEx.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDto {
	
	private int nno;
	private String title;
	private String content;
	private String writer;
	private Timestamp regdate;
	private int replyCnt;
	
	public NoticeDto(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
}
