package com.jitin.collegemgmtsystem.attendanceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jitin.collegemgmtsystem.attendanceservice.model.Attendance;
import com.jitin.collegemgmtsystem.attendanceservice.service.AttendanceService;

@RestController
@RequestMapping("/college")
public class AttendanceControllerImpl implements AttendanceController {
	@Autowired
	private AttendanceService attendanceService;

	@RequestMapping(value = "/getattendance/{id}", method = RequestMethod.GET)
	public Attendance getAttendance(@PathVariable("id") Integer id) {

		return attendanceService.getAttendance(id);
	}

	@RequestMapping(value = "/saveattendance", method = RequestMethod.POST)
	public Attendance saveAttendance(@RequestBody Attendance attendance) {
		return attendanceService.saveAttendance(attendance);
	}

	@RequestMapping(value = "/updateattendance", method = RequestMethod.PUT)
	public Attendance updateAttendance(@RequestBody Attendance attendance) {
		return attendanceService.updateAttendance(attendance);
	}

	@RequestMapping(value = "/deleteattendance/{id}", method = RequestMethod.DELETE)
	public String deleteAttendance(@PathVariable("id") Integer id) {
		return attendanceService.deleteAttendance(id);
	}

}
