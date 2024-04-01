package com.app.raghu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="stdtab")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sid")
	private Integer stdId;
	
	//@NotNull(message="Name Can not be null")
	@NotBlank(message="Student name must not be null")
	@Column(name="sname")
	private String stdName;
	
	@Column(name="sgen")
	private String stdGen;
	
	@Column(name="scourse")
	private String stdCourse;
	
	@Column(name="saddress")
	@NotBlank
	@Pattern(regexp = "[A-Za-z0-9\\.\\s\\?\\-\\,]{10,50}")
	private String stdAddr;
}
