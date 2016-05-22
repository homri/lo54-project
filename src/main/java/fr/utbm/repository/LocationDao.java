/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.entity.Location;
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
public class LocationDao {

    public Location getLocation (int id_location){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Location lc = null;
	    try {
	        session.beginTransaction();
	        lc = (Location) session.get(Location.class, id_location);
                Hibernate.initialize(lc.getCourse_sessions());
                session.flush(); 
	        session.getTransaction().commit();
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            } catch(HibernateException he2) {
					he2.printStackTrace();
				}
	        }
		}
		finally {
	        if(session != null) {
	            try {
					session.close();
				} catch(SessionException se) {
					se.printStackTrace();
				}
			}
		}
		return lc;
	}


    public List<Location> getAllLocations () {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Location> locationList=null;

	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("from Location");
			locationList = query.list();
			for(Iterator iterator1 = locationList.iterator();iterator1.hasNext();) {
        		Location lc = (Location)iterator1.next();
                Hibernate.initialize(lc.getCourse_sessions());
			}
			session.flush();
	        session.getTransaction().commit();
		} catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            } catch(HibernateException he2) {
					he2.printStackTrace();
				}
	        }
		}
		finally {
	        if(session != null) {
	            try {
					session.close();
				} catch(SessionException se) {
                    se.printStackTrace();
				}
			}
		}
		return locationList;
	}
}
