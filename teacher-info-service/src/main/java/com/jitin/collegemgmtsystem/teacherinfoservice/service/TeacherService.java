package com.jitin.collegemgmtsystem.teacherinfoservice.service;

import com.jitin.collegemgmtsystem.teacherinfoservice.model.Teacher;

public interface TeacherService {

	public Teacher getTeacher(Integer id);

	public Teacher saveTeacher(Teacher teacher);

	public Teacher updateTeacher(Teacher teacher);

	public String deleteTeacher(Integer id);

}
