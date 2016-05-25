package fr.utbm.service;

import fr.utbm.entity.Course;
import fr.utbm.entity.Course_session;
import fr.utbm.repository.CourseDao;

import java.util.List;

/**
 * Created by Mac-Guillaume on 24/05/16.
 */
public class CourseService {

	private CourseDao courseDao = new CourseDao();

	public void insertCourseService(Course crs) {
		courseDao.insertCourseDAO(crs);
	}

	public List<Course> getAllCourse() {
		return courseDao.getAllCourses();
	}
}
