package com.jitin.collegemgmtsystem.studentinfoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jitin.collegemgmtsystem.studentinfoservice.model.Student;
import com.jitin.collegemgmtsystem.studentinfoservice.service.StudentService;

@RestController
@RequestMapping("/college")
public class StudentControllerImpl implements StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/getstudent/{id}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("id") Integer id) {
		return studentService.getStudent(id);
	}

	@RequestMapping(value = "/savestudent", method = RequestMethod.POST)
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@RequestMapping(value = "/updatestudent", method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@RequestMapping(value = "/deletestudent/{id}", method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable Integer id) {
		return studentService.deleteStudent(id);
	}

}
