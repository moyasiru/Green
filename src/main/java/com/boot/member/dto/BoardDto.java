package com.boot.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
	private int user_seq;
	private String user_id;
	private String board_title;
	private String board_content;
}
