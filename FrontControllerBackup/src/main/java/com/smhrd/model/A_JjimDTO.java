package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor



public class A_JjimDTO {
	
	
	
	private int list_order; //순서
	private String nick; //닉네임
	private int sort; //분류
	private String dr_id; //술이름
	private String dr_flavor; //향
	private String dr_taste; //맛
	private int dr_abv; //도수
	private String dr_img; //이미지
	private int count; // 카운트
	private int dr_num; //술번호
	
	
	
}
