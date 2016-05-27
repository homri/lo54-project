package fr.utbm.controller;

import fr.utbm.entity.Course;
import fr.utbm.entity.Course_session;
import fr.utbm.entity.Location;
import fr.utbm.service.CourseService;
import java.util.Date;

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

	public List<Course> getAllCourses() {
		return courseService.getAllCoursesService();
	}
        public List<Course> getAllCoursesPerKeyWordController(String keyword) {
		return courseService.getAllCoursesPerKeyWordService(keyword);
	}
        
        public List<Course> getAllCoursesAtDateController (Date date){
                return courseService.getAllCoursesAtDateService(date);
        }
        
        public List<Course> getAllCoursesAtLocationController (Location location){
                return courseService.getAllCoursesAtLocationService(location);
        }
        
        public List<Course> getAllCoursesAtDateLocationController (Date date, Location location){
                return courseService.getAllCoursesAtDateLocationService(date, location);
        }
        
        public List<Course> getAllCoursesPerKeyWordLocationController ( String keyword, Location location){
                return courseService.getAllCoursesPerKeyWordLocationService(keyword, location);
        }
        
        public List<Course> getAllCoursesPerKeyWordDateController (String keyword, Date date){
                return courseService.getAllCoursesPerKeyWordDateService(keyword, date);
        }
        
        public List<Course> getAllCoursesPerKeyWordDateLocationController (String keyword, Date date,Location location){
                return courseService.getAllCoursesPerKeyWordDateLocationService(keyword, date, location);
        }
}
