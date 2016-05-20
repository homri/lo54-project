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
    int client_id;
    int course_session_id;
    String lastname;
    String firstname;
    String adress;
    String phone;
    String email;

    public int getClient_id() {
        return client_id;
    }

    public int getCourse_session_id() {
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

    public void setCourse_session_id(int course_session_id) {
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
