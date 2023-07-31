package com.cafe.study.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.study.model.Seat;
import com.cafe.study.repository.SeatRepository;

@Service
public class SeatService  {
	
	@Autowired
	private SeatRepository seatRepository;
	
	public List<Seat> getSeatList() {
		return seatRepository.findAll();
	}


	public Map<String,Integer> getSeatCount() {


		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("TotalCnt", (int) seatRepository.count());
		map.put("SeatCnt",  seatRepository.selectSeatCount());

		return map;

	}

	public void SeatUpdate(Seat vo) {
		seatRepository.save(vo);
	}
}
