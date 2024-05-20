package com.shinhan.myapp.aop2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//Service:비지니스 로직 생성
@Service("bService2") //@Service = @Component+서비스역할
public class BoardService {
	//BoardDAO boardDAO = new BoardDAO();
	
	//타입이 같으면 객체를 인젝션한다.
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
