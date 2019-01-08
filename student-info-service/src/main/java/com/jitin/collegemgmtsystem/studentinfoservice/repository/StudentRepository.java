package com.jitin.collegemgmtsystem.studentinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jitin.collegemgmtsystem.studentinfoservice.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
