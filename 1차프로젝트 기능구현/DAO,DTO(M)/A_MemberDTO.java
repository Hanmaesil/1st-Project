package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class A_MemberDTO {
	private String id;
	private String pw;
	private String nick;
	private String phone;
	private String birth;
	private int sex;
	
}
