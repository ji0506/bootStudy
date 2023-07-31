package com.cafe.study.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="Kategorie")
@NamedQuery(name="Kategorie.findAll", query="SELECT k FROM Kategorie k")
@Data
public class Kategorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kateNo = 0;
	
	
	private String kateName;
	
	private String userTypeCd;
	
	private String kateDetail;
}