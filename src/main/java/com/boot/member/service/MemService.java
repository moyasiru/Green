package com.boot.member.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.member.dto.MemDto;
import com.boot.member.dto.ReturnDto;
import com.boot.member.mapper.MemDao;

@Service
public class MemService{

	@Autowired
	private MemDao dao;
	
	public MemDto member_loginYn(String cust_id) {
		return dao.member_loginYn(cust_id);
	}
	public void member_registerOk(HashMap<String, String> param) {
		dao.member_registerOk(param);
	}
	public MemDto member_mypage(String user_id) {
		return dao.member_mypage(user_id);
	}
	public void member_rent_count(String user_seq) {
		 dao.member_rent_count(user_seq);
	}
	public void member_modify(HashMap<String, String> param) {
		dao.member_modify(param);
	}
	public void member_delete(String user_id) {
		dao.member_delete(user_id);
	}
	public void member_rent_count_back(String user_seq) {
		dao.member_rent_count_back(user_seq);
	}
	public ArrayList<ReturnDto> return_user_list(HashMap<String, String> param){
		return dao.return_user_list(param);
	}
	public ArrayList<MemDto> member_list(HashMap<String, String> param){
		return dao.member_list(param);
	}
}
