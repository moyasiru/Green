package com.boot.member.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.boot.member.dto.NewsDto;

@Service
public class NewsService {
    private static String News_URL = "https://www.hkbs.co.kr/news/articleList.html?sc_section_code=S1N8&view_type=sm";

    @PostConstruct
    public List<NewsDto> getNewsDatas() throws IOException {
        List<NewsDto> newsList = new ArrayList<>();
        Document document = Jsoup.connect(News_URL).get();

        Elements contents = document.select("section ul.type2 li");

        for (Element content : contents) {
            String fullContent = content.select("p").text();
            String shortContent = shortenText(fullContent, 20); // 10자 이상은 자르기
        	NewsDto news = NewsDto.builder()
                    .image(content.select("a img").attr("abs:src")) // 이미지
                    .subject(content.select("h4 a").text())		// 제목
                    .url(content.select("a").attr("abs:href"))		// 링크
                    .content(fullContent)                          // 원본 내용
                    .shortContent(shortContent)               // 10자로 자른 내용
                    .build();
            newsList.add(news);
        }

        return newsList;
    }

    // 문자열을 일정 길이 이상으로 자르고 "..."으로 표시하는 메서드
    private String shortenText(String text, int maxLength) {
        if (text.length() <= maxLength) {
            return text;
        } else {
            return text.substring(0, maxLength) + "...";
        }
    }
}