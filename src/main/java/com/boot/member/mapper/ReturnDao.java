package com.boot.member.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.boot.member.dto.BoardDto;
import com.boot.member.dto.Criteria;
import com.boot.member.dto.MemDto;
import com.boot.member.dto.ReturnDto;

@Repository
@Mapper
public interface ReturnDao {
	public void return_write(HashMap<String, String> param);
	public ArrayList<ReturnDto> return_list(Criteria cri);
	public int return_getTotalCount(Criteria cri);
	public ReturnDto rent_content_view(HashMap<String, String>param);
	public void rent_yn(String rent_seq);
	public void rent_delete(); 
	public void book_rent_update(String book_seq);
//	public MemDto board_userseq(String user_seq);
}	
