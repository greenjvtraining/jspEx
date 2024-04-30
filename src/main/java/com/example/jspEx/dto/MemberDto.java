package com.example.jspEx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String phone;
	private String addr;
	private String role;
}
