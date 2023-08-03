package com.boot.member.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.boot.member.dto.BoardDto;
import com.boot.member.dto.Criteria;
import com.boot.member.dto.MemDto;

@Repository
@Mapper
public interface BoardDao {
	public void board_write(HashMap<String, String> param);
	public int board_write_check(HashMap<String, String> param);
	public ArrayList<BoardDto> board_list(Criteria cri);
	public BoardDto board_contentView(HashMap<String, String>param);
	public int board_getTotalCount(Criteria cri);
	public MemDto board_userseq(String user_seq);
	public void board_delete(HashMap<String, String>param);
}	
