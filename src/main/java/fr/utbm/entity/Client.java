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
public class Client {
    private int client_id;
    private Course_session course_session_id;
    private String lastname;
    private String firstname;
    private String adress;
    private String phone;
    private String email;

    public Client() {
    }

    public Client(Course_session course_session_id, String lastname, String firstname, String adress, String phone) {
        this.course_session_id = course_session_id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.adress = adress;
        this.phone = phone;
    }

    public Client(Course_session course_session_id, String lastname, String firstname, String adress, String phone, String email) {
        this.course_session_id = course_session_id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
    }

    public int getClient_id() {
        return client_id;
    }

    public Course_session getCourse_session_id() {
        return course_session_id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public void setCourse_session_id(Course_session course_session_id) {
        this.course_session_id = course_session_id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
