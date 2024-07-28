package com.shinhan.firstzone.vo3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name="tb_child1")
@IdClass(MultiKeyA.class)
public class MultiKeyAClass {

	@Id
	private Integer id1;
	@Id
	private Integer id2;
	
	private String productName;
	int price;
}
