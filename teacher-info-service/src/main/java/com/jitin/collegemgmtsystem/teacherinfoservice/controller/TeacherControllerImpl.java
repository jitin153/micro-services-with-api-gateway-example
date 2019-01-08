package com.jitin.collegemgmtsystem.teacherinfoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jitin.collegemgmtsystem.teacherinfoservice.model.Teacher;
import com.jitin.collegemgmtsystem.teacherinfoservice.service.TeacherService;

@RestController
@RequestMapping("/college")
public class TeacherControllerImpl implements TeacherController {
	@Autowired
	private TeacherService teacherService;

	@RequestMapping(value = "/getteacher/{id}", method = RequestMethod.GET)
	public Teacher getTeacher(@PathVariable("id") Integer id) {
		return teacherService.getTeacher(id);
	}

	@RequestMapping(value = "/saveteacher", method = RequestMethod.POST)
	public Teacher saveTeacher(@RequestBody Teacher teacher) {
		return teacherService.saveTeacher(teacher);
	}

	@RequestMapping(value = "/updateteacher", method = RequestMethod.PUT)
	public Teacher updateTeacher(@RequestBody Teacher teacher) {
		return teacherService.updateTeacher(teacher);
	}

	@RequestMapping(value = "/deleteteacher/{id}", method = RequestMethod.DELETE)
	public String deleteTeacher(@PathVariable Integer id) {
		return teacherService.deleteTeacher(id);
	}

}
