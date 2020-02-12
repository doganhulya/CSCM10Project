package com.iot.device.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "idGenerator")
	private int id;
	
	@Column(name = "CREATEDDATE")
	private Date createdDate = new Date();


	@Column(name = "CREATEDBY")
	private int createdBy = 1;
	
}
