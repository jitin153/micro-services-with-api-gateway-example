package com.jitin.collegemgmtsystem.teacherinfoservice.model;

public class Attendance {
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
