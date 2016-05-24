/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.entity;

import java.util.Set;

/**
 *
 * @author khalil
 */
public class Course {
    private String course_code;
    private String title;
    private Set course_sessions;

    public Course() {}

    public Course(String course_code, String title) {
        this.title = title;
        this.course_code = course_code;
    }

    public Course(String course_code, String title, Set course_sessions) {
        this.title = title;
        this.course_code = course_code;
        this.course_sessions = course_sessions;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getTitle() {
        return title;
    }

    public Set getCourse_sessions() {
        return course_sessions;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCourse_sessions(Set course_sessions) {
        this.course_sessions = course_sessions;
    }
}
