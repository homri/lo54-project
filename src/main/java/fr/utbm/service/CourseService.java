package fr.utbm.service;

import fr.utbm.entity.Course;
import fr.utbm.repository.CourseDao;

/**
 * Created by Mac-Guillaume on 24/05/16.
 */
public class CourseService {

	private CourseDao courseDao = new CourseDao();

	public void insertCourseService(Course crs) {
		courseDao.insertCourseDAO(crs);
	}
}
