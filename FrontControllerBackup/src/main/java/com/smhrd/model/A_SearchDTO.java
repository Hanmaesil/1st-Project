package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class A_SearchDTO {
	
	
	private int sort;
	private String dr_id; //술이름
	private String dr_flavor;//향
	private String dr_taste; //맛
	private int dr_abv;//도수
	private String dr_des;//설명
	private String dr_img; //이미지 경로
	private int dr_num;// 순서
	
	
	
	
}
