package com.boot.member.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.member.dto.BookDto;
import com.boot.member.dto.Criteria;
import com.boot.member.dto.ReturnDto;
import com.boot.member.mapper.BookDao;
import com.boot.member.mapper.ReturnDao;

@Service
public class ReturnService {
	
	@Autowired
	private ReturnDao dao;
	
	public void return_write(HashMap<String, String> param) {
		dao.return_write(param);
	}
	public ArrayList<ReturnDto> return_list(Criteria cri){
		return dao.return_list(cri);
	}
	public int return_getTotalCount(Criteria cri) {
		return dao.return_getTotalCount(cri);
	}
	public ReturnDto rent_content_view(HashMap<String, String>param) {
		return dao.rent_content_view(param);
	}
	public void rent_yn(String rent_seq) {
		dao.rent_yn(rent_seq);
	}
	public void rent_delete() {
		dao.rent_delete();
	}
	public void book_rent_update(String book_seq) {
		dao.book_rent_update(book_seq);
	}
}
