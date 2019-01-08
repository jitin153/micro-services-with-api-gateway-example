package com.jitin.collegemgmtsystem.teacherinfoservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jitin.collegemgmtsystem.teacherinfoservice.model.Attendance;
import com.jitin.collegemgmtsystem.teacherinfoservice.model.Teacher;
import com.jitin.collegemgmtsystem.teacherinfoservice.repository.TeacherRepository;
import com.jitin.collegemgmtsystem.teacherinfoservice.util.TeacherServiceConstant;
import com.jitin.collegemgmtsystem.teacherinfoservice.util.TeacherServiceUtil;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
	private static final Logger LOG = LoggerFactory.getLogger(TeacherServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	TeacherRepository teacherRepository;

	@Value("${attendance-service.url}")
	private String attendanceServiceUrl;

	public Teacher getTeacher(Integer id) {
		Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
		Teacher teacherWithAttendance = new Teacher();
		if (optionalTeacher.isPresent()) {
			teacherWithAttendance = optionalTeacher.get();
			teacherWithAttendance.setAttendance(this.getAttendance(id));
		} else {
			LOG.info("Teacher not found for given id : {}", id);
		}
		return teacherWithAttendance;
	}

	public Teacher saveTeacher(Teacher teacher) {
		Teacher teacherWithAttendance = teacherRepository.save(teacher);
		teacherWithAttendance.setAttendance(this.saveAttendance(teacher.getAttendance()));
		return teacherWithAttendance;
	}

	public Teacher updateTeacher(Teacher teacher) {
		Teacher teacherWithAttendance = teacherRepository.save(teacher);
		teacherWithAttendance.setAttendance(this.updateAttendance(teacher.getAttendance()));
		return teacherWithAttendance;
	}

	public String deleteTeacher(Integer id) {
		teacherRepository.deleteById(id);
		this.deleteAttendance(id);
		return "Successfully Deleted!";
	}

	private Attendance getAttendance(Integer id) {
		String attendanceServiceCompleteUrl = attendanceServiceUrl + TeacherServiceConstant.GET_ATTENDANCE_ENDPOINT
				+ id;
		return restTemplate.getForObject(attendanceServiceCompleteUrl, Attendance.class);
	}

	private String deleteAttendance(Integer id) {
		String attendanceServiceCompleteUrl = attendanceServiceUrl + TeacherServiceConstant.DELETE_ATTENDANCE_ENDPOINT
				+ id;
		ResponseEntity<String> reponse = restTemplate.exchange(attendanceServiceCompleteUrl, HttpMethod.DELETE,
				TeacherServiceUtil.getHttpEntity(id, MediaType.APPLICATION_JSON), String.class);
		return reponse.getBody();
	}

	private Attendance saveAttendance(Attendance attendance) {
		String attendanceServiceCompleteUrl = attendanceServiceUrl + TeacherServiceConstant.SAVE_ATTENDANCE_ENDPOINT;
		ResponseEntity<Attendance> reponse = restTemplate.exchange(attendanceServiceCompleteUrl, HttpMethod.POST,
				TeacherServiceUtil.getHttpEntity(attendance, MediaType.APPLICATION_JSON),
				new ParameterizedTypeReference<Attendance>() {
				}, Attendance.class);
		return reponse.getBody();
	}

	private Attendance updateAttendance(Attendance attendance) {
		String attendanceServiceCompleteUrl = attendanceServiceUrl + TeacherServiceConstant.UPDATE_ATTENDANCE_ENDPOINT;
		ResponseEntity<Attendance> reponse = restTemplate.exchange(attendanceServiceCompleteUrl, HttpMethod.PUT,
				TeacherServiceUtil.getHttpEntity(attendance, MediaType.APPLICATION_JSON),
				new ParameterizedTypeReference<Attendance>() {
				}, Attendance.class);
		return reponse.getBody();
	}

}
