package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class A_MemberDTO {
	private String id; //id
	private String pw; //pw
	private String nick; // 닉네임
	private String phone; // 전화번호
	private String birth; // 생년월일
	private int sex; //성별
	
}
