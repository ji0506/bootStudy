package com.cafe.study.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;


/**
 * The persistent class for the boards database table.
 * 
 */
@Entity
@Table(name="User")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userId;

	private String userPwd;

	private String userName;
	
	private String userEmail;

	private String userCp;

	private String userAddr;

	private String userDaddr;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date joinDate;
	
	private String userGrade;
	
	private String userTypeCd;


}