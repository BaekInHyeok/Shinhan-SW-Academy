package com.shinhan.firstzone.vo2;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@MappedSuperclass // table생성안됨
@EntityListeners(value = { AuditingEntityListener.class })
public abstract class BaseEntity {
	@CreatedDate
	@Column(name = "regdate", updatable = false)
	protected LocalDateTime regDate;
	@LastModifiedDate
	@Column(name = "moddate")
	protected LocalDateTime modDate;
}
