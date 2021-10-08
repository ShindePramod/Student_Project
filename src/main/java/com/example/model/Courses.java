package com.example.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name = "coursee")
public class Courses implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long c_id;
	
	@Column(name = "course_name")
	private String c_name;
	
	@Column(name = "c_duration")
	private String c_duration;
	
	
	

	public Courses() {
		super();
	}

	public Courses(long c_id, String c_name, String c_duration) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_duration = c_duration;
	}

	@Override
	public String toString() {
		return "Courses [c_id=" + c_id + ", c_name=" + c_name + ", c_duration=" + c_duration + "]";
	}

	public long getC_id() {
		return c_id;
	}

	public void setC_id(long c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_duration() {
		return c_duration;
	}

	public void setC_duration(String c_duration) {
		this.c_duration = c_duration;
	}
	
	
	

}
