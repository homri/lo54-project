/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.entity.Course_session;
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
public class Course_sessionDao {
    public Course_session getCourse_session (int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Course_session crs = null;
	    try {
	        session.beginTransaction();
			crs = (Course_session) session.get(Course_session.class, id);
			Hibernate.initialize(crs.getId_location());
			Hibernate.initialize(crs.getCourse_code());
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
		return crs;
	}


    public List<Course_session> getAllCourse_sessions (){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course_session> course_sessionList=null;

	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("from Course_session");
			course_sessionList = query.list();
                for(Iterator iterator1 = course_sessionList.iterator();iterator1.hasNext();) {
					Course_session crs = (Course_session)iterator1.next();
					Hibernate.initialize(crs.getId_location());
					Hibernate.initialize(crs.getCourse_code());
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
		return course_sessionList;
	}
}
