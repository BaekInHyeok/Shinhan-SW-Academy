package com.shinhan.firstzone.vo3;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude= {"board"})
@EqualsAndHashCode(of = {"bno"})
@Entity
@Table(name="t_freereply")
public class FreeReplyEntity {
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rsno;
	private String reply;//댓글내용
	private String replyer;//댓글작성자
	
	@CreationTimestamp//insert 시에 자동으로 들어감
	private Timestamp regdate;
	@UpdateTimestamp//insert, update 시 자동
	private Timestamp upddatedate;
	
	//하나의 board에 댓글이 여러 개 있음(자식)
	@ManyToOne(fetch=FetchType.LAZY)//DB의 칼럼은 => board_bno
	private FreeBoardEntity board;
	
	
}
