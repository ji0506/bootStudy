package com.cafe.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.study.model.Seat;
import org.springframework.data.jpa.repository.Query;

public interface SeatRepository extends JpaRepository<Seat, Long>{
	
//	public List<Seat> findAll();

    @Query("SELECT COUNT(a) FROM Seat a WHERE seat_comment <> '01'")
    int selectSeatCount();

}
