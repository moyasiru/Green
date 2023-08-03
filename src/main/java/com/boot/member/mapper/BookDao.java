package com.boot.member.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.boot.member.dto.BookDto;
import com.boot.member.dto.Criteria;
@Repository
@Mapper
public interface BookDao {
	public ArrayList<BookDto> bookcat_list();
	public ArrayList<BookDto> bookcat4image();
	public void book_write(HashMap<String, String> param);
	public ArrayList<BookDto> book_list(Criteria cri);
	public ArrayList<BookDto> book_search(HashMap<String, String> param); //book_list에서 검색
	public ArrayList<BookDto> search_list(HashMap<String, String> param);//nav검색
	public ArrayList<BookDto> mainpage();
	public int book_getTotalCount(Criteria cri);
	public BookDto book_contentView(HashMap<String, String> param);
	public BookDto book_user_view(HashMap<String, String> param);
	public void book_modify(HashMap<String, String> param);
	public void book_delete(HashMap<String, String> param);
	public void book_rent(String book_seq);
	public ArrayList<BookDto> book_catlist(HashMap<String, String> param);
	public int book_catcount(HashMap<String, String> param);
}
