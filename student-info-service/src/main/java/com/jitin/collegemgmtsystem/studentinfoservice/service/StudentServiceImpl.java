package com.jitin.collegemgmtsystem.studentinfoservice.service;

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

import com.jitin.collegemgmtsystem.studentinfoservice.model.Attendance;
import com.jitin.collegemgmtsystem.studentinfoservice.model.Student;
import com.jitin.collegemgmtsystem.studentinfoservice.repository.StudentRepository;
import com.jitin.collegemgmtsystem.studentinfoservice.util.StudentServiceConstants;
import com.jitin.collegemgmtsystem.studentinfoservice.util.StudentServiceUtil;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	private static final Logger LOG = LoggerFactory.getLogger(StudentServiceImpl.class);
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${attendance-service.url}")
	private String attendanceServiceUrl;

	public Student getStudent(Integer id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student student = new Student();
		if (optionalStudent.isPresent()) {
			student = optionalStudent.get();
			student.setAttendance(this.getAttendance(id));
		} else {
			LOG.info("Student record not found for given id : {}", id);
		}
		return student;
	}

	public Student saveStudent(Student student) {
		Student studentWithAttendance = studentRepository.save(student);
		studentWithAttendance.setAttendance(this.saveAttendance(student.getAttendance()));
		return studentWithAttendance;
	}

	public Student updateStudent(Student student) {
		Student studentWithAttendance = studentRepository.save(student);
		studentWithAttendance.setAttendance(this.updateAttendance(student.getAttendance()));
		return studentWithAttendance;
	}

	public String deleteStudent(Integer id) {
		studentRepository.deleteById(id);
		this.deleteAttendance(id);
		return "Successfully Deleted!";
	}

	private Attendance getAttendance(Integer id) {
		String attendanceServiceCompleteUrl = attendanceServiceUrl + StudentServiceConstants.GET_ATTENDANCE_ENDPOINT
				+ id;
		return restTemplate.getForObject(attendanceServiceCompleteUrl, Attendance.class);
	}

	private String deleteAttendance(Integer id) {
		String attendanceServiceCompleteUrl = attendanceServiceUrl + StudentServiceConstants.DELETE_ATTENDANCE_ENDPOINT
				+ id;
		ResponseEntity<String> reponse = restTemplate.exchange(attendanceServiceCompleteUrl, HttpMethod.DELETE,
				StudentServiceUtil.getHttpEntity(id, MediaType.APPLICATION_JSON), String.class);
		return reponse.getBody();
	}

	private Attendance saveAttendance(Attendance attendance) {
		String attendanceServiceCompleteUrl = attendanceServiceUrl + StudentServiceConstants.SAVE_ATTENDANCE_ENDPOINT;
		ResponseEntity<Attendance> reponse = restTemplate.exchange(attendanceServiceCompleteUrl, HttpMethod.POST,
				StudentServiceUtil.getHttpEntity(attendance, MediaType.APPLICATION_JSON),
				new ParameterizedTypeReference<Attendance>() {
				}, Attendance.class);
		return reponse.getBody();
	}

	private Attendance updateAttendance(Attendance attendance) {
		String attendanceServiceCompleteUrl = attendanceServiceUrl + StudentServiceConstants.UPDATE_ATTENDANCE_ENDPOINT;
		ResponseEntity<Attendance> reponse = restTemplate.exchange(attendanceServiceCompleteUrl, HttpMethod.PUT,
				StudentServiceUtil.getHttpEntity(attendance, MediaType.APPLICATION_JSON),
				new ParameterizedTypeReference<Attendance>() {
				}, Attendance.class);
		return reponse.getBody();
	}

}
