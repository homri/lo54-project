package fr.utbm.service;

import fr.utbm.entity.Course;
import fr.utbm.entity.Course_session;
import fr.utbm.entity.Location;
import fr.utbm.repository.CourseDao;
import java.util.Date;

import java.util.List;

/**
 * Created by Mac-Guillaume on 24/05/16.
 */
public class CourseService {

	private CourseDao courseDao = new CourseDao();

	public void insertCourseService(Course crs) {
		courseDao.insertCourseDAO(crs);
	}

	public List<Course> getAllCoursesService() {
		return courseDao.getAllCourses();
	}
        
        public List<Course> getAllCoursesPerKeyWordService(String keyword) {
		return courseDao.getAllCoursesPerKeyWord(keyword);
	}
        
        public List<Course> getAllCoursesAtDateService (Date date){
                return courseDao.getAllCoursesAtDate(date);
        }
        
        public List<Course> getAllCoursesAtLocationService (Location location){
                return courseDao.getAllCoursesAtLocation(location);
        }
        
        public List<Course> getAllCoursesAtDateLocationService (Date date, Location location){
                return courseDao.getAllCoursesAtDateLocation(date, location);
        }
        
        public List<Course> getAllCoursesPerKeyWordLocationService ( String keyword, Location location){
                return courseDao.getAllCoursesPerKeyWordLocation(keyword, location);
        }
        
        public List<Course> getAllCoursesPerKeyWordDateService (String keyword, Date date){
                return courseDao.getAllCoursesPerKeyWordDate(keyword, date);
        }
        
        public List<Course> getAllCoursesPerKeyWordDateLocationService (String keyword, Date date,Location location){
                return courseDao.getAllCoursesPerKeyWordDateLocation(keyword, date, location);
        }
}
