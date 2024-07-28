package com.shinhan.firstzone;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.firstzone.repository.PDSBoardRepository;
import com.shinhan.firstzone.repository.PDSFileRepository;
import com.shinhan.firstzone.vo2.PDSBoardEntity;
import com.shinhan.firstzone.vo2.PDSFileEntity;

import jakarta.transaction.Transactional;

@SpringBootTest
public class OneToManyTest {
	
	@Autowired
	PDSFileRepository fileRepo;
	@Autowired
	PDSBoardRepository boardRepo;
	
	//삭제
	@Test
	//ㅊㅁㄴㅅㅊㅁㅇ
	void deleteFile() {
		fileRepo.deleteById(10L);
	}
	
	//boardRepo에서 PDSFile를 수정, 직접 SQL 작성
	//@Transactional 추가 , 실행 후 test 환경은 rollback 처리 된다.. class Level에 commit 추가
	@Transactional
	@Test
	void updateFile() {
		boardRepo.updatePDSFile(60L, "파일이름수정");
	}
	
	//PDSBoard의 이름 변경 : 본래 이름 뒤에 pid 붙이기
	@Test
	void update() {
		boardRepo.findAll().forEach(board->{
			//bo
		});
	}
	
	
	//입력....board의 file 추가
	//@Test
	void insertBoard() {
		PDSBoardEntity board = boardRepo.findById(4L).orElse(null);
		if(board==null) return;
		List<PDSFileEntity> flist = board.getFiles();
		PDSFileEntity file1 = PDSFileEntity.builder().pdsfilename("파일추가1.jpg").build();
		PDSFileEntity file2 = PDSFileEntity.builder().pdsfilename("파일추가2.jpg").build();
		flist.add(file1);
		flist.add(file2);
		
		board.setWriter("작성자수정");
		boardRepo.save(board);
	}
	
//	@Test
//	void selectBoard5() {
//		boardRepo.getFilesCount2().ForEach(Arrays.toString(null));
//	}
	
	
	@Test
	void selectBoard4() {
		long pid = 4L;
		List<Object[]> blist = boardRepo.getFilesInfo2(pid);
		blist.forEach(arr->System.out.println(Arrays.toString(arr)));
	}
	
	
	//조회
	//@Transactional
	//@Test
	void selectBoard3() {
		
		PDSBoardEntity board = boardRepo.findById(4L).orElse(null);
		if(board==null) return;
		System.out.println(board.getPname());
		
	}
	//조회
	//@Test
	void selectBoard2() {
		String w="수영";
		List<PDSBoardEntity> blist = boardRepo.findByWriter(w);
		
	}
	
	
	
	//PDSFileEntity의 pdsfilename으로 조회
	//@Test
	void selectFile2() {
		String pdsfilename = "ptyhon-8-1.ppt";
		PDSFileEntity file = fileRepo.findByPdsfilename(pdsfilename);
		System.out.println(file);
	}
}
