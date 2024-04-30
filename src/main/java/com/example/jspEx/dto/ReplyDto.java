package com.example.jspEx.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyDto {
	private int rno;
	private int nno;
	private String comment;
	private String writer;
	private Timestamp regdate;
	
	public ReplyDto(int nno, String comment, String writer, Timestamp regdate) {
		this.nno = nno;
		this.comment = comment;
		this.writer = writer;
		this.regdate = regdate;
	}
}
