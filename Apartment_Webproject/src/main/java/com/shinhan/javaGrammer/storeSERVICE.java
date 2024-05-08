package com.shinhan.javaGrammer;

import java.util.List;

public class storeSERVICE {
	
	storeDAO strDAO = new storeDAO();

	//1.상점 ID로 정보 조회
	public storeDTO findBYID(int strID) {
		return strDAO.findBYID(strID);
	}
	
	//2.업종을 입력하여 정보 조회
	public List<storeDTO> findByType(String type){
		return strDAO.findByType(type);
	}
	
	//3.상가 정보 입력
	public int strInsert(storeDTO str) {
		return strDAO.strInsert(str);
	}

	//4.상가 정보 수정
	public int strUpdate(int select, int strid, Object obj) {
		// TODO Auto-generated method stub
		return strDAO.strUpdate(select, strid, obj);
	}

	//4.상가 정보 삭제
	public int resDelete(int strid) {
		// TODO Auto-generated method stub
		return strDAO.strDelete(strid);
	}

	public List<storeDTO> findIsOpen() {
		// TODO Auto-generated method stub
		return strDAO.findISOpen();
	}

}
