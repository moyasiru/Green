package com.boot.member.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
	private int book_seq;
	private String book_title;
	private int book_cat;
	private int count;
	private String book_author;
	private String book_image;
//	private String book_imagepath;
	private String book_description;
	private Timestamp book_date;
	private String book_rent;
	private String book_state;
	private String keyword;
	private String type;
	
}