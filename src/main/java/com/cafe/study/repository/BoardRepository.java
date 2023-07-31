package com.cafe.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.study.model.Board;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer>{

    @Query(nativeQuery = true, value = "select t1.* from (" +
            "select a.* from board a where kate_no = 1  ORDER BY reg_date desc LIMIT 2) t1 union select t2.* from ( " +
            "select b.* from board b where kate_no != 1  ORDER BY reg_date desc LIMIT 3) t2 ")
	public List<Board> findMainView();
}
