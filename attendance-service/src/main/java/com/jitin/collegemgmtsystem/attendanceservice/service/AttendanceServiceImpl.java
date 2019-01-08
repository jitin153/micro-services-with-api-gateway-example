package com.jitin.collegemgmtsystem.attendanceservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitin.collegemgmtsystem.attendanceservice.model.Attendance;
import com.jitin.collegemgmtsystem.attendanceservice.repository.AttendanceRepository;

@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
	private static final Logger LOG = LoggerFactory.getLogger(AttendanceServiceImpl.class);
	@Autowired
	private AttendanceRepository attendanceRepository;

	public Attendance getAttendance(Integer id) {
		Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);
		Attendance attendance = new Attendance();
		if (optionalAttendance.isPresent()) {
			attendance = optionalAttendance.get();
		} else {
			LOG.info("No attendance record found for the given id : {}", id);
		}
		return attendance;
	}

	@Override
	public Attendance saveAttendance(Attendance attendance) {
		return attendanceRepository.save(attendance);
	}

	@Override
	public Attendance updateAttendance(Attendance attendance) {
		return attendanceRepository.save(attendance);
	}

	@Override
	public String deleteAttendance(Integer id) {
		attendanceRepository.deleteById(id);
		return "Successfully Deleted!";
	}

}
