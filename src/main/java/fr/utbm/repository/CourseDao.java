/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.entity.Course;
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
public class CourseDao {
    public Course getInformation (int id){
        Session session =null;
        Course cr = null;
     session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        cr = (Course) session.get(Course.class, id);
                Hibernate.initialize(cr.getCourse_sessions());
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
                return cr;
                }
            }
    public List<Course> getInformationHql (){
        Session session =null;
        List<Course> courseList=null;
     session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("from Course");
                courseList = query.list();
                for(Iterator iterator1 = courseList.iterator();iterator1.hasNext();){
        Course cr = (Course)iterator1.next();
                Hibernate.initialize(cr.getCourse_sessions());
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
                return courseList;
                }
            }
}
