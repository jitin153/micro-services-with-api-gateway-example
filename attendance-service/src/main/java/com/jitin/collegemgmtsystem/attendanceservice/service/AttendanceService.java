package com.jitin.collegemgmtsystem.attendanceservice.service;

import com.jitin.collegemgmtsystem.attendanceservice.model.Attendance;

public interface AttendanceService {
	public Attendance getAttendance(Integer id);

	public Attendance saveAttendance(Attendance attendance);

	public Attendance updateAttendance(Attendance attendance);

	public String deleteAttendance(Integer id);

}
