package com.cafe.study.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Table(name="seat_type")
@Data
public class SeatType {

	@Id	
	String seatType;
	
	String seatTypeName;

	   
	
}
