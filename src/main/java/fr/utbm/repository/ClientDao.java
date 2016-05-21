/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.entity.Client;
import fr.utbm.util.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionException;

/**
 *
 * @author khalil
 */
public class ClientDao {
    public void insert(Client cl){
        Session session =null;
     session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        session.save(cl);
                session.flush() ; 
	        session.getTransaction().commit();
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
		}
		finally {
	        if(session != null) {
	            try {
                        session.close();
                        
                    }
                    catch(SessionException se){
                    se.printStackTrace();
                    }
                }
                }
            }
    public Client getInformation (int client_id){
        Session session =null;
        Client cl = null;
     session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        cl = (Client) session.get(Client.class, client_id);
                Hibernate.initialize(cl.getCourse_session_id());
                session.flush(); 
	        session.getTransaction().commit();
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
		}
		finally {
	        if(session != null) {
	            try {
                        session.close();                     
                    }
                    catch(SessionException se){
                    se.printStackTrace();
                    }
                }
                return cl;
                }
            }
    public List<Client> getInformationHql (){
        Session session =null;
        List<Client> clientList=null;
     session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("from Client");
                clientList = query.list();
                for(Iterator iterator1 = clientList.iterator();iterator1.hasNext();){
                Client cl = (Client)iterator1.next();
                Hibernate.initialize(cl.getCourse_session_id());
                }
                session.flush(); 
	        session.getTransaction().commit();
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
		}
		finally {
	        if(session != null) {
	            try {
                        session.close();
                        
                    }
                    catch(SessionException se){
                    se.printStackTrace();
                    }
                }
                return clientList;
                }
            }
}
