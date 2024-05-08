package com.shinhan.javaGrammer;

import java.util.List;

//Controller -> Service -> DAO
//			 <- 		<-

//Service : 비즈니스 로직을 수행함
public class residentSERVICE {

	residentDAO resDAO = new residentDAO();

	// 1.주민 ID로 주민 정보 조회
	public residentDTO findBYID(int resID) {
		return resDAO.findBYID(resID);
	}

	// 2.동별 주민 목록 조회(이름, 호, 관리비)
	public List<residentDTO> findBYDONG(int resDONG) {
		return resDAO.findBYDONG(resDONG);
	}

	// 3.주민 정보 입력(주민 추가)
	public int resInsert(residentDTO res) {
		return resDAO.resInsert2(res);
	}

	// 4.주민 정보 수정
	public int resUpdate(residentDTO res) {
		return resDAO.resUpdate(res);
	}

	// 5.주민 정보 삭제
	public int resDelete(int resID) {
		return resDAO.resDelete(resID);
	}

	// 6.세대주 중복을 막기 위해 세대주 존재 여부 확인
	public int isOwnerExist(int dong, int ho) {
			return resDAO.isOwnerExist(dong, ho);
	}

	// 7. 아파트 단지 전체 주민 목록
	public List<residentDTO> selectAll(){
		return resDAO.selectAll();
	}

}
