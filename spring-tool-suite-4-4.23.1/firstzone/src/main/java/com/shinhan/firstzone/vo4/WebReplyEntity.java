package com.shinhan.firstzone.vo4;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.shinhan.firstzone.vo3.FreeBoardEntity;
import com.shinhan.firstzone.vo3.FreeReplyEntity;

import jakarta.persistence.CascadeType;
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
@Entity
@Table(name="t_webreply")
public class WebReplyEntity {

	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rno;
	private String reply;//댓글내용
	private String replyer;//댓글작성자
	
	@CreationTimestamp//insert 시에 자동으로 들어감
	private Timestamp regdate;
	@UpdateTimestamp//insert, update 시 자동
	private Timestamp updatedate;
	
	//하나의 board에 댓글이 여러 개 있음(자식)
	@ManyToOne( fetch=FetchType.LAZY)//DB의 칼럼은 => board_bno
	private WebBoardEntity board;
}
