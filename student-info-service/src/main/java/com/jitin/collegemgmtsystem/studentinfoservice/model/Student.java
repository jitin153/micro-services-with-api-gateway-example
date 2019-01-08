package com.jitin.collegemgmtsystem.studentinfoservice.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "student_info")
public class Student {
	@Id	
	private Integer id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Course course;
	@Transient
	private Attendance attendance;

	public Student() {

	}

	public Student(Integer id, String name, Course course, Attendance attendance) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

}
