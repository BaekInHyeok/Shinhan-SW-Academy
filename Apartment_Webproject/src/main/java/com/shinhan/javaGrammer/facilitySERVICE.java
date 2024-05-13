package com.shinhan.javaGrammer;

import java.util.List;

public class facilitySERVICE {

	facilityDAO facDAO = new facilityDAO();

	// 1.시설ID로 정보 조회
	public facilityDTO findBYID(int facID) {
		return facDAO.findBYID(facID);
	}
	
	//1-1.시설매니저ID로 정보 조회
	public facilityDTO findBYMgrID(int mgrID) {
		return facDAO.findBYMgrID(mgrID);
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
	public int facUpdate(facilityDTO fac) {
		return facDAO.facUpdate(fac);
	}
	//4-1.매니저ID를 0으로 리셋
	public int eraseMgrId(int mgrid) {
		return facDAO.eraseMgrId(mgrid);
	}
	
	//5. 시설 정보 삭제
	public int facDelete(int facID) {
		return facDAO.facDelete(facID);
	}
	
	public List<facilityDTO> selectAll(){
		return facDAO.selectAll();
	}
	
	
}
