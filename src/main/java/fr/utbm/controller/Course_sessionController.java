package fr.utbm.controller;

import fr.utbm.entity.Course_session;
import fr.utbm.service.Course_sessionService;

import java.util.List;

/**
 * Created by Mac-Guillaume on 24/05/16.
 */
public class Course_sessionController {

	private Course_sessionService course_sessionService = new Course_sessionService();

	public List<Course_session> getAllCourse_session() {
		return course_sessionService.getAllCourse_session();
	}

	public Course_session getCourse_sessionById(String id_session) {
		return course_sessionService.getCourse_sessionFromId(Integer.parseInt(id_session));
	}

	public Course_session getCourse_sessionById(Integer id_session) {
		return course_sessionService.getCourse_sessionFromId(id_session);
	}
}
