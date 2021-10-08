package com.example.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student_name")
public class Students implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name= "s_Name")
	private String name;
	
	@Column (name= "Last_Name")
	private String lastName;
	
	private long mobile_num;

	
	@OneToMany( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="STUDENT_COURSE", joinColumns = @JoinColumn(name="STUDENT_ID"), 
	inverseJoinColumns = @JoinColumn(name="COURSE_ID"))
	
	private Set<Courses> course;
	
	public Students() {
		super();
	}



	public Students(long id, String name, String lastName, long mobile_num) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.mobile_num = mobile_num;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public long getMobile_num() {
		return mobile_num;
	}



	public void setMobile_num(long mobile_num) {
		this.mobile_num = mobile_num;
	}



	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", lastName=" + lastName + ", mobile_num=" + mobile_num + "]";
	}
	
	
	

}
