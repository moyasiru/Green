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
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.member.dto.Criteria;
import com.boot.member.dto.MemDto;
import com.boot.member.dto.PageDTO;
import com.boot.member.dto.ReturnDto;
import com.boot.member.service.MemService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	
	@Autowired
	private MemService service;
	
	@RequestMapping("/login")
    public String home(){
		log.info("@# login22");
        return "login";
    }
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		log.info("logged out");
		
		String user_id = (String) session.getAttribute("user_id");
		log.info("@# log out ,  user_id : " + user_id);
		
		session.invalidate();
		
		return "mainpage";
	}
	
	@RequestMapping("/nav")
    public String nav(Model model, HttpSession session){
		log.info("@# nav");
		
		String user_id = (String) session.getAttribute("user_id"); // 세션 받아서 변수화
		if (user_id != null) { // id 있으면 -> 로그인 상태
			model.addAttribute("user_id", user_id); // 세션 넘겨줌
			log.info("@# success ,  session user_id : " + user_id);
		}
		
        return "nav";
    }	
	
	@RequestMapping("/login_ok")
	public String login_ok() {
		log.info("@# login_ok");
		
		return "redirect:nav";
	}
	
	@ResponseBody
	@RequestMapping(value = "/member_login_yn", produces = "application/json")
//	public String login_yn(HttpServletRequest request, Model model) {
	public int cust_loginYn(HttpServletRequest request) {
		log.info("@# login_yn");

		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		MemDto dtos = service.member_loginYn(user_id);
		
		int res = 0;
		if (dtos != null) {
			if (user_pwd.equals(dtos.getUser_pwd())) {
				log.info("success");
				res = 1;
			} else {
				log.info("failed");
				res = 0;
			}
		} else {
			log.info("empty");
			res = 0;
		}
		return res;
	}
	
	@RequestMapping("/member_loginOk")
	public String member_loginOk(HttpServletRequest request) {
		log.info("@# member_loginOk");

		String user_id = request.getParameter("user_id");
		log.info("@# member_loginOk session " + user_id);
		// 세션 있으면 반환, 없으면 생성
		HttpSession session = request.getSession(true);
		log.info("@# member_loginOk session222222 " + user_id);
		session.setAttribute("user_id", user_id);
		log.info("@# member_loginOk session3333 " + user_id);

		return "redirect:mainpage";
	}
	
	
	@RequestMapping("/member_registerOk")
	public String member_registerOk(@RequestParam HashMap<String, String> param) {
		log.info("@# registerOk start()");

		service.member_registerOk(param);

		log.info("@# registerOk end()");
		return "redirect:login";
	}
	
	@RequestMapping("/member_mypage")
	public String member_mypage(HttpSession session, Model model) {
		log.info("@# member_mypage");
		
		String user_id = (String) session.getAttribute("user_id"); // 세션 받아서 변수화

			model.addAttribute("user_id", user_id); // 세션 넘겨줌
			log.info("@# myPage - user_id : " + user_id);
			MemDto dto = service.member_mypage(user_id);
			model.addAttribute("list", dto);			
			
			if (user_id.equals("admin")) {
				return "admin_mypage";
			}else {	
				return "member_mypage";
			}
	}
	@RequestMapping("/member_rent_count")
	public String member_rent_count(HttpServletRequest request) {
		log.info("@@@### membercontroller member_rent_count() ");

		String user_seq = request.getParameter("user_seq");
		service.member_rent_count(user_seq);
		return "mainpage";
	}
	
	@RequestMapping("/member_rent_count_back")
	public String member_rent_count_back(HttpServletRequest request) {
		log.info("@@@### membercontroller member_rent_count_back() ");
		
		String user_seq = request.getParameter("user_seq");
		service.member_rent_count_back(user_seq);
		return "mainpage";
	}
	
	@ResponseBody
	@RequestMapping("/member_modify")
	public void member_modify(@RequestParam HashMap<String, String> param) {
		log.info("@# member_modify param : " + param);
		service.member_modify(param);
	}

	@ResponseBody
	@RequestMapping("/member_delete")
	public void member_delete(String user_id, HttpSession session) {
		service.member_delete(user_id);
		log.info("@# member_delete - user_id : " + user_id);
		session.invalidate();
		log.info("@# member_delete - session invalidate");
	}
	
	@RequestMapping("/return_user_list")
	public String return_user_list(@RequestParam HashMap<String, String> param,Model model) {
		log.info("@@@### returncontroller return_user_list");

		ArrayList<ReturnDto> return_user_list = service.return_user_list(param);
		

		log.info(""+return_user_list);
		model.addAttribute("return_user_list", return_user_list);

		return "return_user_list";
	}

	@RequestMapping("/member_list")
	public String member_list(@RequestParam HashMap<String, String> param,Model model) {

		ArrayList<MemDto> member_list = service.member_list(param);
		
		log.info("member_list");
		model.addAttribute("member_list", member_list);
		
		return "member_list";
	}

}
