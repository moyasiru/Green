package com.boot.member.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.member.dto.BookDto;
import com.boot.member.dto.Criteria;
import com.boot.member.dto.PageDTO;
import com.boot.member.dto.ReturnDto;
import com.boot.member.service.BookService;
import com.boot.member.service.ReturnService;

import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class ReturnController {

	@Autowired
	private ReturnService service;
	
	@Autowired
	private BookService bookservice;
	
	@RequestMapping("/return_write")
	public String book_Write(@RequestParam HashMap<String, String> param) {
		log.info("@@@###  book_Write()");
		
		service.return_write(param);
		
		return "mainpage";
	}

	
	@RequestMapping("/return_list")
	public String return_list(Criteria cri, Model model) {
		log.info("@@@### returncontroller return_list");
		log.info("@@@### returncontroller return_ cri ===>" + cri);

		ArrayList<ReturnDto> return_list = service.return_list(cri);
		

		log.info(""+return_list);
		model.addAttribute("list", return_list);
		int total = service.return_getTotalCount(cri);

		log.info("@# returncontroller return_list total ===>" + total);

		model.addAttribute("pageMaker", new PageDTO(total, cri));

		return "return_list";
	}
	@RequestMapping("/book_rent")
	public String book_rent(HttpServletRequest request) {
		log.info("@@@### rent_controller book_rent() ");

		String book_seq = request.getParameter("book_seq");
		bookservice.book_rent(book_seq);
		return "mainpage";
	}
	@RequestMapping("/rent_content_view")
	public String rent_content_view(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@@@### rent_controller rent_content_view() ");

		ReturnDto dto = service.rent_content_view(param);

		model.addAttribute("rent_content_view", dto);

		return "rent_content_view";
	}
	@RequestMapping("/rent_yn")
	public String rent_yn(HttpServletRequest request) {
		log.info("@@@### rent_controller rent_yn() ");

		String rent_seq = request.getParameter("rent_seq");
		service.rent_yn(rent_seq);
		return "return_list";
	}
	
	@RequestMapping("/rent_delete")
	public String rent_delete(HttpServletRequest request) {
		log.info("@@@### rent_controller rent_delete() ");
		
		service.rent_delete();
		return "return_list";
	}
	
	@RequestMapping("/book_rent_update")
	public String book_rent_update(HttpServletRequest request) {
		log.info("@@@### rent_controller book_rent_update() ");

		String book_seq = request.getParameter("book_seq");
		service.book_rent_update(book_seq);
		return "return_list";
	}
	
}
