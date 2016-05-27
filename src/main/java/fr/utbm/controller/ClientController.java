/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.controller;

import fr.utbm.entity.Client;
import fr.utbm.entity.Course_session;
import fr.utbm.repository.Course_sessionDao;
import fr.utbm.service.ClientService;
import fr.utbm.service.Course_sessionService;

/**
 *
 * @author khalil
 */
public class ClientController {

    private ClientService cls = new ClientService();

    public void insertClientControllerWithoutEmail(int course_session_id, String lastname, String firstname, String adress, String phone){
        Course_sessionService crss = new Course_sessionService();
        Course_session crs = crss.getCourse_sessionFromIdService(course_session_id);
        Client cl = new Client(crs, lastname, firstname, adress, phone);
        cls.insertClientService(cl);
    }
    public void insertClientControllerWithEmail(int course_session_id, String lastname, String firstname, String adress, String phone, String email){
        Course_sessionService crss = new Course_sessionService();
        Course_session crs = crss.getCourse_sessionFromIdService(course_session_id);
        Client cl = new Client(crs, lastname, firstname, adress, phone, email);
        cls.insertClientService(cl);
    }
}
