package com.shinhan.firstzone.vo4;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shinhan.firstzone.vo2.MemberEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@ToString(exclude= {"replies"})
@Table(name="t_webboard")
public class WebBoardEntity {

	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	private String title;
	
	@ManyToOne
	private MemberEntity writer;
	
	private String content;
	@CreationTimestamp//insert 시에 자동으로 들어감
	private Timestamp regdate;
	@UpdateTimestamp//insert, update 시 자동
	private Timestamp updatedate;
	
	//하나의 board에 여러 댓글
	@OneToMany(mappedBy = "board", 
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER)//모든전의, 즉시로딩
	List<WebReplyEntity> replies;
}
