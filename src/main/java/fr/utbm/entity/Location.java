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
public class Location {
    private int id_location;
    private String city;
    private Set course_sessions;

    public Location() {}

    public Location(String city, Set course_sessions) {
        this.city = city;
        this.course_sessions = course_sessions;
    }

    public int getId_location() {
        return id_location;
    }

    public String getCity() {
        return city;
    }

    public Set getCourse_sessions() {
        return course_sessions;
    }

    public void setId_location(int id_location) {
        this.id_location = id_location;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCourse_sessions(Set course_sessions) {
        this.course_sessions = course_sessions;
    }
    
}
