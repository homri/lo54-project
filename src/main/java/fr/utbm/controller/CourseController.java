package fr.utbm.controller;

import fr.utbm.entity.Course;
import fr.utbm.entity.Course_session;
import fr.utbm.service.CourseService;

import java.util.List;

/**
 * Created by Mac-Guillaume on 24/05/16.
 */
public class CourseController {

	private CourseService courseService = new CourseService();

	public void insertCourseController(String code, String title) {
		Course crs = new Course(code ,title);
		courseService.insertCourseService(crs);
	}

	public List<Course> getAllCourse() {
		return courseService.getAllCourse();
	}
}
