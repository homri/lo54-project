/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.service;

import fr.utbm.entity.Client;
import fr.utbm.repository.ClientDao;

/**
 *
 * @author khalil
 */
public class ClientService {
    public void insertClientService(Client cl){
    ClientDao cld = new ClientDao();
        cld.insertClient(cl);
    }
}
