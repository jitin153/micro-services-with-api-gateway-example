package com.jitin.collegemgmtsystem.teacherinfoservice.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "teacher_info")
public class Teacher {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Department department;
	@Transient
	private Attendance attendance;

	public Teacher() {

	}

	public Teacher(Integer id, String name, Department department, Attendance attendance) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.attendance = attendance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

}
