package com.shinhan.firstzone.vo3;

import java.util.Set;

import com.shinhan.firstzone.vo2.MemberRole;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="tbl_enum")

public class ENumTypeVO {

	@Id
	private String mid;
	private String mpassword;
	private String mname;

	@ElementCollection(targetClass = MemberRole.class,
			fetch = FetchType.EAGER
	)
	@CollectionTable(name = "tbl_enum_mroles", 
	                joinColumns = @JoinColumn(name="mid")) //tbl_enum_mroles테이블의 조인칼럼
	private Set<MemberRole> mrole;
}
