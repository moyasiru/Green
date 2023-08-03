package com.boot.member.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.member.dto.BookDto;
import com.boot.member.dto.Criteria;
import com.boot.member.mapper.BookDao;

@Service
public class BookService {
	
	@Autowired
	private BookDao dao;
	
	public ArrayList<BookDto> bookcat_list(){
		return dao.bookcat_list();
	}
	
	public void book_write(HashMap<String, String> param) {
		dao.book_write(param);
	}
	public ArrayList<BookDto> book_list(Criteria cri){
		return dao.book_list(cri);
	}
	public int book_getTotalCount(Criteria cri) {
		return dao.book_getTotalCount(cri);
	}
	public BookDto book_contentView(HashMap<String, String>param) {
		return dao.book_contentView(param);
	}
	public void book_modify(HashMap<String, String>param) {
		 dao.book_modify(param);
	}
	public void book_delete(HashMap<String, String>param) {
		dao.book_delete(param);		
	}
	public BookDto book_user_view(HashMap<String, String>param) {
		return dao.book_user_view(param);
	}
	public void book_rent(String book_seq) {
		dao.book_rent(book_seq);
	}
	public ArrayList<BookDto> mainpage(){
		return dao.mainpage();
	}
	public ArrayList<BookDto> search_list(HashMap<String, String> param){
		return dao.search_list(param);
	}
	public ArrayList<BookDto> book_search(HashMap<String, String> param){
		return dao.book_search(param);		
	}
	public ArrayList<BookDto> book_catlist(HashMap<String, String> param){
		return dao.book_catlist(param);
	}
	public int book_catcount(HashMap<String, String> param) {
		return dao.book_catcount(param);
	}
	public ArrayList<BookDto> bookcat4image(){
		return dao.bookcat4image();
	}
}
