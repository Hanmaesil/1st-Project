package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class A_BoardDTO {
	private int bo_num; //게시판 번호
	private String nick; //닉네임
	private String bo_title; //게시물 제목
	private String bo_content; //게시물 내용
	private String bo_date; //작성날짜
	
	
	
}
