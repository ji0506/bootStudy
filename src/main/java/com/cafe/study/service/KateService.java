package com.cafe.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.study.model.Kategorie;
import com.cafe.study.repository.KateRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KateService  {
	
	@Autowired
	private KateRepository kateRepository;
	
	public List<Kategorie> getMenu(String userTypeNo) {
		
		return kateRepository.findByUserTypeCd(userTypeNo);
		
		
	}

}
