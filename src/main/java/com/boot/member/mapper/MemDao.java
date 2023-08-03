package com.boot.member.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.boot.member.dto.MemDto;
import com.boot.member.dto.ReturnDto;

@Repository
@Mapper
public interface MemDao {
	public MemDto member_loginYn(String user_id);
	public void member_registerOk(HashMap<String, String> param); 
	public void member_modify(HashMap<String, String> param); 
	public void member_delete(String user_id); 
	public MemDto member_mypage(String user_id);
	public void member_rent_count(String user_seq);
	public void member_rent_count_back(String user_seq);
	public ArrayList<ReturnDto> return_user_list(HashMap<String, String> param);
	public ArrayList<MemDto> member_list(HashMap<String, String> param);
}
