package com.shinhan.firstzone.vo2;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="mid")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_members")
public class MemberDTO {
    @Id
	String mid;
	String mpassword;
	String mname;
	
	@Enumerated(EnumType.STRING)
	MemberRole mrole;
	
}

