package com.jitin.collegemgmtsystem.attendanceservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attendance")
public class Attendance {
	@Id
	private Integer id;
	private Float attendancePercentage;

	public Attendance() {

	}

	public Attendance(Integer id, Float attendancePercentage) {
		super();
		this.id = id;
		this.attendancePercentage = attendancePercentage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getAttendancePercentage() {
		return attendancePercentage;
	}

	public void setAttendancePercentage(Float attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}

}
