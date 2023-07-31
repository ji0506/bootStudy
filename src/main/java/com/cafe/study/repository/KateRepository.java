package com.cafe.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.study.model.Kategorie;

public interface KateRepository extends JpaRepository<Kategorie, Long>{
	
	
	public List<Kategorie> findByUserTypeCd(String userTypeNo);
	
}
