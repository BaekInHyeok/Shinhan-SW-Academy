package com.shinhan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dto.BoardDTO;
import com.shinhan.util.DBUtil;

public class BoardService {
	BoardDAO boardDAO = new BoardDAO();
	
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
