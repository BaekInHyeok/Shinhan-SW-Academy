package com.shinhan.firstzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shinhan.firstzone.vo2.PDSBoardEntity;
import com.shinhan.firstzone.vo2.PDSFileEntity;

public interface PDSFileRepository extends JpaRepository<PDSFileEntity, Long>{
	
	//1.기본
	//2.
	PDSFileEntity findByPdsfilename(String pdsfilename);
	
	
}
