package com.shinhan.firstzone.vo2;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//하나의 Board에 첨부File이 여러개있다. 
@Table(name = "t_pdsboard")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PDSBoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long pid;
	String pname;
	String writer;
	//cascade : 전이
	@OneToMany(cascade = CascadeType.ALL, 
			   fetch = FetchType.EAGER ) 
	@JoinColumn(name = "pdsno") //PDSFileEntity의 테이블에 pdsno칼럼이 생성된다. 
	//join칼럼이 생략되면 중간테이블이 생성된다. PDSBoard키, PDSFileEntity키를칼럼으로 갖는 중간테이블만들어짐 
	List<PDSFileEntity> files;
}






