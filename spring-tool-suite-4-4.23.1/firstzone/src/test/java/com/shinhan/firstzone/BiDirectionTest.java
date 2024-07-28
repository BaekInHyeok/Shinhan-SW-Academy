package com.shinhan.firstzone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.querydsl.core.BooleanBuilder;
import com.shinhan.firstzone.repository3.FreeBoardRepository;
import com.shinhan.firstzone.repository3.FreeReplyRepository;
import com.shinhan.firstzone.vo3.FreeBoardEntity;
import com.shinhan.firstzone.vo3.FreeReplyEntity;
import com.shinhan.firstzone.vo3.QFreeBoardEntity;

import jakarta.transaction.Transactional;

@SpringBootTest
public class BiDirectionTest {

	@Autowired
	FreeBoardRepository boardRepo;
	@Autowired
	FreeReplyRepository replyRepo;

	/*
	 * // @Test
	 * 
	 * void queryDslTest() { String title = "c"; String keyword = "맑음";
	 * 
	 * BooleanBuilder builder = new BooleanBuilder(); QFreeBoardEntity board =
	 * QFreeBoardEntity.freeBoardEntity; if (type.contains("t")) {
	 * builder.and(board.title.like("%" + keyword + "%")); }
	 * builder.and(board.bno.gt(0L)); Pageable page = PageRequest.of(0, 10);
	 * Page<FreeBoard> result = boardRepo.findAll(builder, page); List<FreeBoard>
	 * list = result.getContent(); list.forEach(b -> { System.out.println(b); });
	 * System.out.println("getSize:" + result.getSize());
	 * System.out.println("getTotalPages:" + result.getTotalPages());
	 * System.out.println("getTotalElements:" + result.getTotalElements());
	 * System.out.println("nextPageable:" + result.nextPageable());
	 * 
	 * }
	 */

	// @Test
	void join2() {
		// N:1에서 test하는 중
		// Reply select... Reply가 참조하는 board가 5가지라면, Reply select 1개, board select문 5개
		// N+1 문제 발생
		// replyRepo.fiindAllWithReplyUsingJoin().forEach(b->System.out.println(b));

		// N+1 문제 해결(Join Fetch)
		replyRepo.findAllWithReplyUsingJoinFetch().forEach(b -> System.out.println(b));
	}

	// @Test
	void join1() {
		// N:1에서 test하는 중
		// Reply select
		// N+1 문제 발생
		// boardRepo.fiindAllWithReplyUsingJoin().forEach(b->System.out.println(b));

		// N+1 문제 해결(Join Fetch)
		boardRepo.findAllWithReplyUsingJoinFetch().forEach(b -> System.out.println(b));
	}

	// 조건조회 bno>=10 and bno<=20
	// @Transactional
	// @Test
	void selectBoard2() {
		// 2번째 page 5건
		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
		// where bno between 1 and 10 order by bno desc
		Page<FreeBoardEntity> result = boardRepo.findByBnoBetween(1L, 10L, pageable);
		System.out.println(result.getNumber());
		System.out.println(result.getSize());
		System.out.println(result.getTotalElements());
		System.out.println(result.getTotalPages());
		System.out.println(result.getSort());
		System.out.println(result.getPageable());
		result.getContent().forEach(board -> {
			System.out.println(board);
			System.out.println(board.getReplies().size() + "건");
		});

		boardRepo.findByBnoBetween(1L, 10L, pageable).forEach(board -> {
			System.out.println(board);
			System.out.println(board.getReplies().size() + "건");
		});
	}

	// BoardTitle, Reply건수
	// @Test
	void selectBoardReply() {
		boardRepo.getFreeBoardReplyCount().forEach(arr -> System.out.println(Arrays.toString(arr)));
	}

	// @Transactional
	// @Test
	void selectBoard() {
		boardRepo.findAll().forEach(board -> {
			System.out.println(board);
			System.out.println("댓글건수:" + board.getReplies().size());
		});
	}

	// 조회(Board 번호를 알고 있을 때 댓글들의 정보 조회)
	// @Transactional
	// @Test
	void selectByReply() {
		FreeBoardEntity board = FreeBoardEntity.builder().bno(4L).build();
		replyRepo.findByBoard(board).forEach(reply -> {
			System.out.println(reply);
			System.out.println(reply.getBoard());
		});

	}

	// 댓글수정
	// @Test
	void updateReply() {
		FreeBoardEntity board = FreeBoardEntity.builder().bno(5L).build();
		List<Long> idList = new ArrayList<>();
		idList.add(20L);
		idList.add(21L);
		idList.add(22L);
		idList.add(23L);
		idList.add(24L);
		replyRepo.findAllById(idList).forEach(reply -> {
			reply.setBoard(board);
			replyRepo.save(reply);
		});
	}

	// 댓글삽입
	// @Test
	void insertReply() {
		FreeBoardEntity board = FreeBoardEntity.builder().bno(4L).build();
		FreeReplyEntity reply = FreeReplyEntity.builder().reply("점심메뉴").replyer("user1").board(board).build();
		replyRepo.save(reply);

	}

	// 특정 board의 댓글 삽입
	// @Test
	void insertBoard2() {
		boardRepo.findById(1L).ifPresent(board -> {
			List<FreeReplyEntity> replyList = board.getReplies();
			IntStream.rangeClosed(1, 5).forEach(i -> {
				FreeReplyEntity reply = FreeReplyEntity.builder().reply("댓글..." + i).replyer("user" + i % 2)
						.board(board).build();
				replyList.add(reply);
			});
			boardRepo.save(board);
		});
	}

	// @Test
	void insertBoard() {
		// 30건
		IntStream.rangeClosed(1, 30).forEach(i -> {
			FreeBoardEntity entity = FreeBoardEntity.builder().title("점심메뉴" + i)
					.content("오늘은 " + (i % 2 == 0 ? "맑음" : "비")).writer("user" + i % 5).build();

			boardRepo.save(entity);
		});
	}
}
