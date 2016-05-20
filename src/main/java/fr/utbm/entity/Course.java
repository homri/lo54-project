/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.entity;

/**
 *
 * @author khalil
 */
public class Course {
    String course_code;
    String title;

    public String getCourse_code() {
        return course_code;
    }

    public String getTitle() {
        return title;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
