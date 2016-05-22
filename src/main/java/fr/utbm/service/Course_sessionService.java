/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.service;

import fr.utbm.entity.Course_session;
import fr.utbm.repository.Course_sessionDao;

/**
 *
 * @author khalil
 */
public class Course_sessionService {
    public Course_session getCourse_sessionFromId(int course_session_id){
        Course_sessionDao crsd = new Course_sessionDao();
        Course_session crs = crsd.getCourse_session(course_session_id);
        return crs;
    }
}
