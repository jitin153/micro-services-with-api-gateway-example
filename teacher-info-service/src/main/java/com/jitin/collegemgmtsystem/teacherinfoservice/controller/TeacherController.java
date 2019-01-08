package com.jitin.collegemgmtsystem.teacherinfoservice.controller;

import com.jitin.collegemgmtsystem.teacherinfoservice.model.Teacher;

public interface TeacherController {
	public Teacher getTeacher(Integer id);

	public Teacher saveTeacher(Teacher teacher);

	public Teacher updateTeacher(Teacher teacher);

	public String deleteTeacher(Integer id);
}
