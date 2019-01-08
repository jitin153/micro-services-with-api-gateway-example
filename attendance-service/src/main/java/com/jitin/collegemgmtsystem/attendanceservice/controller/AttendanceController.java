package com.jitin.collegemgmtsystem.attendanceservice.controller;

import com.jitin.collegemgmtsystem.attendanceservice.model.Attendance;

public interface AttendanceController {
	public Attendance getAttendance(Integer id);

	public Attendance saveAttendance(Attendance attendance);

	public Attendance updateAttendance(Attendance attendance);

	public String deleteAttendance(Integer id);
}
