package com.boot.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemDto {
	private int user_seq;
	private String user_name;
	private String user_id;
	private String user_pwd;
	private String user_phone;
	private String user_email;
	private String user_image;
	private int user_rent_count;
	
}