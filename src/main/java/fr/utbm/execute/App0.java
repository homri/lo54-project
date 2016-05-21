/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.execute;

import fr.utbm.entity.Client;
import fr.utbm.entity.Course_session;
import fr.utbm.repository.ClientDao;
import fr.utbm.repository.Course_sessionDao;
import fr.utbm.util.HibernateUtil;

/**
 *
 * @author khalil
 */
public class App0 {
    public static void main(String[] arg){
        /*Course_sessionDao crsd = new Course_sessionDao();
        Course_session crs = crsd.getInformation(3);
        Client cl = new Client(crs,"renaud","guillaume","1 rue Gaston Defferre","0782698652","renaud.guillaume@utbm.fr");
        ClientDao cld = new ClientDao();
        cld.insert(cl);
        */HibernateUtil.getSessionFactory();
        HibernateUtil.getSessionFactory().close();
        
            
    }
}
