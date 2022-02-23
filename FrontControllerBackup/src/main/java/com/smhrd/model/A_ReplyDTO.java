package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class A_ReplyDTO {
	
	private int reorder; //순서
	private int bo_num; //게시글번호
	private String nick; //닉네임
	private String re_coment; //댓글내용
	private String regdate; //작성날짜
	private int re_index; //댓글번호
	
	
	
	
}
