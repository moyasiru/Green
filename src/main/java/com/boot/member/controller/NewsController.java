package com.boot.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.member.dto.NewsDto;
import com.boot.member.service.NewsService;



@Controller
public class NewsController {
	 private final NewsService newsService;

	    public NewsController(NewsService newsService) {
	        this.newsService = newsService;
	    }

	    @GetMapping("/news")
	    public String news(Model model) throws Exception{
	        List<NewsDto> newsList = newsService.getNewsDatas();
	        model.addAttribute("news", newsList);

	        return "news";
	    }
}
