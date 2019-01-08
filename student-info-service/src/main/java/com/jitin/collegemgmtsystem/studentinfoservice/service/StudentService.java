package com.jitin.collegemgmtsystem.studentinfoservice.service;

import com.jitin.collegemgmtsystem.studentinfoservice.model.Student;

public interface StudentService {
	public Student getStudent(Integer id);

	public Student saveStudent(Student student);

	public Student updateStudent(Student student);

	public String deleteStudent(Integer id);
}
