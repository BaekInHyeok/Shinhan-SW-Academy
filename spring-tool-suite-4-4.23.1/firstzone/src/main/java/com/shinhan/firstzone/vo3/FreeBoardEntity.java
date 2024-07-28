package com.shinhan.firstzone.vo3;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@ToString
@EqualsAndHashCode(of = {"bno"})
@Entity
@Table(name="t_freeboard")
public class FreeBoardEntity {
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	private String title;
	private String writer;
	private String content;
	
	@CreationTimestamp//insert 시에 자동으로 들어감
	private Timestamp regdate;
	@UpdateTimestamp//insert, update 시 자동
	private Timestamp upddatedate;
	
	
	@JsonIgnore
	
	//N+1 해결 방법 중 하나. Join 사용 시 대상 entity의 갯수만큼 상대 entity를 select하는 문제
	//in을 사용하여 BatchSize만큼 한꺼번에 select 가능
	@BatchSize(size=100)
	//하나의 board에 댓글이 여러 개 있음(부모)
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.LAZY)//모든전의, 즉시로딩
	List<FreeReplyEntity> replies;
}
