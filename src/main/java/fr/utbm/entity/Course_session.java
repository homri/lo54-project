/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.entity;

import java.util.Date;

/**
 *
 * @author khalil
 */
public class Course_session {
    int course_session_id;
    int id_location;
    String course_code;
    Date start_date;
    Date end_date;

    public int getCourse_session_id() {
        return course_session_id;
    }

    public int getId_location() {
        return id_location;
    }

    public String getCourse_code() {
        return course_code;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setCourse_session_id(int course_session_id) {
        this.course_session_id = course_session_id;
    }

    public void setId_location(int id_location) {
        this.id_location = id_location;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
    
}
