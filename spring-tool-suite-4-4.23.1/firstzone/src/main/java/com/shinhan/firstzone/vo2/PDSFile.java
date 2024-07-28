package com.shinhan.firstzone.vo2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_pdsfiles")
@EqualsAndHashCode(of = "fno")
public class PDSFile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long fno;
	private String pdsfilename;
}
