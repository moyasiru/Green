package com.boot.member.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.member.dto.BoardDto;
import com.boot.member.dto.Criteria;
import com.boot.member.dto.MemDto;
import com.boot.member.mapper.BoardDao;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
	
	public void board_write(HashMap<String, String> param) {
		dao.board_write(param);
	}
	public int board_write_check(HashMap<String, String> param) {
		return dao.board_write_check(param);
	}
	public BoardDto board_contentView(HashMap<String, String>param) {
		return dao.board_contentView(param);
	}
	public ArrayList<BoardDto> board_list(Criteria cri){
		return dao.board_list(cri);
	}
	public int board_getTotalCount(Criteria cri) {
		return dao.board_getTotalCount(cri);
	}
	public MemDto board_userseq(String user_seq) {
		return dao.board_userseq(user_seq);
	}
	public void board_delete(HashMap<String, String> param) {
		dao.board_delete(param);
	}
}
