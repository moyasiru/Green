package com.boot.member.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.boot.member.dto.BoardDto;
import com.boot.member.dto.Criteria;
import com.boot.member.dto.MemDto;
import com.boot.member.dto.PageDTO;
import com.boot.member.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/main")
	public String main(Model model, HttpSession session) {
		log.info("@@@###  main()");
		
		String user_id = (String) session.getAttribute("user_id"); // 세션 받아서 변수화
		if (user_id != null) { // id 있으면 -> 로그인 상태
			model.addAttribute("user_id", user_id); // 세션 넘겨줌
			log.info("@# success ,  session user_id : " + user_id);
		}
		
		
		
		return "main";
	}

	@ResponseBody
	@RequestMapping(value = "/board_userseq", produces = "application/json; charset=utf8")
	public MemDto board_userseq(HttpServletRequest request,Model model) {
		log.info("@@@###  board_userseq()");
			String user_id = request.getParameter("user_id");
		
			log.info("@@@###  user_seq ==>" +service.board_userseq(user_id));
		
		return service.board_userseq(user_id);
	}
	
	

		@RequestMapping(value = "/image/upload")
		public ModelAndView image(MultipartHttpServletRequest request) throws Exception {
			
			ModelAndView mav = new ModelAndView("jsonView");

			MultipartFile uploadFile = request.getFile("upload");

			String originalFileName = uploadFile.getOriginalFilename();

			String ext = originalFileName.substring(originalFileName.indexOf("."));

			String newFileName = UUID.randomUUID() + ext;

			String realPath = request.getServletContext().getRealPath("/");

			String savePath = realPath + "upload/" + newFileName;
	  
			String uploadPath = "./upload/" + newFileName; 

			File file = new File(savePath);

			uploadFile.transferTo(file);

			mav.addObject("uploaded", true);
			mav.addObject("url", uploadPath);

			return mav;
		}

	
		@RequestMapping("/board_write")
		public String board_write(@RequestParam HashMap<String, String> param) {
			log.info("@@@###  board_write()");
			
			service.board_write(param);

			log.info("@@@###  board_write() end");
			
			return "redirect:board_list";
		}
		
		@RequestMapping("/board_content_view")
		public String board_content_view(@RequestParam HashMap<String, String> param,HttpSession session,Model model) {
			log.info("@@@###  board_content_view()");
			
			String user_id = (String) session.getAttribute("user_id"); // 세션 받아서 변수화
			if (user_id != null) { // id 있으면 -> 로그인 상태
				model.addAttribute("user_id", user_id); // 세션 넘겨줌
				log.info("@# success ,  session user_id : " + user_id);
			}
			
			BoardDto dto = service.board_contentView(param);

			model.addAttribute("board_content_view", dto);
			model.addAttribute("realid", dto.getUser_id());
			log.info(dto.getUser_id());
			model.addAttribute("pageMaker", param);	
			
			return "board_content_view";
		}
		@RequestMapping("/board_list")
		public String board_list(HttpSession session,Criteria cri, Model model) {
			log.info("@@@###  board_list()");
			
			String user_id = (String) session.getAttribute("user_id"); // 세션 받아서 변수화
			if (user_id != null) { // id 있으면 -> 로그인 상태
				model.addAttribute("user_id", user_id); // 세션 넘겨줌
				log.info("@# success ,  session user_id : " + user_id);
			}
			
			
			ArrayList<BoardDto> board_list = service.board_list(cri);
			

			log.info(""+board_list);
			model.addAttribute("list", board_list);
			int total = service.board_getTotalCount(cri);

			log.info("@# prodcontroller book_list total ===>" + total);

			model.addAttribute("pageMaker", new PageDTO(total, cri));
						
			return "board_list";
		}
		
		@RequestMapping("/board_delete")
		public String board_delete(@RequestParam HashMap<String, String> param) {
			log.info("@@@###  board_delete()");
			
			service.board_delete(param);

			log.info("@@@###  board_delete() end");
			
			return "redirect:board_list";
		}

		@RequestMapping("/board_write_check")
		public String board_write_check(@RequestParam HashMap<String, String> param,HttpSession session,Model model) {
			log.info("@@@###  board_write_check()");
			
				int res = service.board_write_check(param);
				
				if (res==1) {
					return "board_warnning";
				}else {
					String user_id = (String) session.getAttribute("user_id"); // 세션 받아서 변수화
					if (user_id != null) { // id 있으면 -> 로그인 상태
						model.addAttribute("user_id", user_id); // 세션 넘겨줌
						log.info("@# success ,  session user_id : " + user_id);
					}
					
					return "redirect:main";
				}
		}
}
