package com.shinhan.javasqlproject;

import java.util.List;

public class facilitySERVICE {

	facilityDAO facDAO = new facilityDAO();

	// 1.시설ID로 정보 조회
	public facwnameDTO findBYID(int facID) {
		return facDAO.findBYID(facID);
	}

	// 2.시설명을 입력하여 해당 시설의 근무자 목록 검색
	public List<wrkINfacDTO> findBYfacname(String facname) {
		return facDAO.findBYfacname(facname);
	}

	// 3.시설 정보 입력(시설 추가)
	public int facInsert(facilityDTO fac) {
		return facDAO.facInsert(fac);
	}
	
	//4. 시설 정보 수정
	public int facUpdate(int key, int facid, Object obj) {
		return facDAO.facUpdate(key,facid,obj);
	}
	
	//5. 시설 정보 삭제
	public int facDelete(int facID) {
		return facDAO.facDelete(facID);
	}
	

}
