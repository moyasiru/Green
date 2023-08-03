package com.boot.member.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnDto {
	private int rent_seq;
	private int book_seq;
	private int user_seq;
	private Timestamp rent_date;//대출일
	private Timestamp rent_return_date;//반납일
	private String rent_date_yn;//반납여부
}
