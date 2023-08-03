package com.boot.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class NewsDto {
	private String image;
    private String subject;
    private String url;
    private String content;
    private String shortContent;
}
