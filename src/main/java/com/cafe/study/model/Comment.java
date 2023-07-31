package com.cafe.study.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="board_comment")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
@Data
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int comNo;

	private int parentNo;
	
	private int brdNo;
	
	private String comContent;

	private String userId;

	private Date regDate;

	private Date modDate;
		
}