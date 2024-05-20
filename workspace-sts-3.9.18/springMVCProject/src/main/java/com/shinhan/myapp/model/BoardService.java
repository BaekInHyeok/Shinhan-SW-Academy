package com.shinhan.myapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("bService2") 
public class BoardService {
	//BoardDAO boardDAO = new BoardDAO();
	
	@Autowired
	BoardDAO boardDAO;
	
	public int deleteBoard(int bno) {
		return boardDAO.deleteBoard(bno);
	}
	
	public int updateBoard(BoardDTO board) {
		return boardDAO.updateBoard(board);
	}
	
	public int insertBoard(BoardDTO board) {
		return boardDAO.insertBoard(board);
	}
	
	public BoardDTO selectById(int bno) {
		return boardDAO.selectById(bno);
	}
	
	public List<BoardDTO> selectAll() {
		return boardDAO.selectAll();
	}
}
