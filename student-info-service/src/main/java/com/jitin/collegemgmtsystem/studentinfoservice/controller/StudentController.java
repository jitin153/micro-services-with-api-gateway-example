package com.jitin.collegemgmtsystem.studentinfoservice.controller;

import com.jitin.collegemgmtsystem.studentinfoservice.model.Student;

public interface StudentController {
	public Student getStudent(Integer id);

	public Student saveStudent(Student student);

	public Student updateStudent(Student student);

	public String deleteStudent(Integer id);
}
