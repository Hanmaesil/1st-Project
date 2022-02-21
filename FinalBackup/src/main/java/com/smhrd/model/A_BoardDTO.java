package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class A_BoardDTO {
	private int bo_num;
	private String nick;
	private String bo_title;
	private String bo_content;
	private String bo_date;
	
	
	
}
