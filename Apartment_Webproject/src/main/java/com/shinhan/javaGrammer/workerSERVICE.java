package com.shinhan.javaGrammer;

import java.util.List;

public class workerSERVICE {

	workerDAO wrkDAO = new workerDAO();
	
	// 1.주민 ID로 주민 정보 조회
	public workerDTO findBYID(int wrkID) {
		return wrkDAO.findBYID(wrkID);
	}

	//2.업무명을 입력해 해당 업무에 참가하는 근로자 목록
	public List<wrkINworkDTO> findByWork(String work) {
		// TODO Auto-generated method stub
		return wrkDAO.findByWork(work);
	}

	//3.근로자 정보 입력(근로자 추가)
	public int wkrInsert(workerDTO wkr) {
		// TODO Auto-generated method stub
		return wrkDAO.wrkInsert(wkr);
	}
	
	//4.근로자 정보 수정
	public int wrkUpdate(int key, int resid, Object obj) {
		// TODO Auto-generated method stub
		return wrkDAO.wrkUpdate(key, resid, obj);
	}

	//5.근로자 삭제
	public int wrkDelete(int wrkid) {
		// TODO Auto-generated method stub
		return wrkDAO.wrkDelete(wrkid);
	}
}
