package com.boot.member.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Criteria {
	private int pageNum;//페이지 번호
	private int amount;//페이지당 글 갯수
	private String keyword; // 페이지 검색 키워드
	
	public Criteria() {
		this(1, 10);
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

}











