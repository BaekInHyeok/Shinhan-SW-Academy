package com.shinhan.firstzone.repository;

import org.springframework.data.repository.CrudRepository;

import com.shinhan.firstzone.vo2.MemberDTO;

public interface MemberRepository extends CrudRepository<MemberDTO, String>{

}
