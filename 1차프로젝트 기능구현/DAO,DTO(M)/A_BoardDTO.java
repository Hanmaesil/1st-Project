package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class A_BoardDTO {
	private int num;
	private String nick;
	private String title;
	private String content;
	private int like;
	
	
	
}
