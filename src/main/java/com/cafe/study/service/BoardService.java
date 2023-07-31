package com.cafe.study.service;

import com.cafe.study.model.Board;
import com.cafe.study.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

import java.util.List;

//@Log4j
@Service
public class BoardService  {

    @Autowired
    BoardRepository boardRepository;

	public List<Board> getBoardViewList(){
        return boardRepository.findMainView();
    }
}
