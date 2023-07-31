package com.cafe.study.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.util.Date;


@Entity
@Table(name="Seat")
@NamedQuery(name="Seat.findAll", query="SELECT s FROM Seat s")
@Data
public class Seat {

	@Id
	String seatNo;

	String seatComment;	

	String seatType;	

	@OneToOne
	@JoinColumn(name = "seatComment", insertable = false, updatable = false)
	@JsonIgnore
	SeatComment comment;

	@OneToOne
	@JoinColumn(name = "seatType", insertable = false, updatable = false)
	@JsonIgnore
	SeatType type;

	String userId;

	@Temporal(TemporalType.TIMESTAMP)
	Date regDate;
	  	
}
