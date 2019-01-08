package com.jitin.collegemgmtsystem.attendanceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jitin.collegemgmtsystem.attendanceservice.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer>{

}
