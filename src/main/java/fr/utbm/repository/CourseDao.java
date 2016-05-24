/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.entity.Client;
import fr.utbm.entity.Course;
import fr.utbm.entity.Course_session;
import fr.utbm.entity.Location;
import fr.utbm.util.HibernateUtil;
import java.util.Date;
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

	public void insertCourseDAO(Course crs) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(crs);
			session.flush() ;
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
				} catch(SessionException se){
					se.printStackTrace();
				}
			}
		}
	}

    public List<Course> getAllCourses (){
        Session session = session = HibernateUtil.getSessionFactory().openSession();
        List<Course> courseList = null;

	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("from Course");
			courseList = query.list();

			functionIterator(courseList);

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
		return courseList;
	}


    public List<Course> getAllCoursesPerKeyWord (String keyword){
		Session session = session = HibernateUtil.getSessionFactory().openSession();
		List<Course> courseList=null;

		try {
	        session.beginTransaction();
			keyword=keyword.concat("%");
			System.out.println("aaaaaa"+keyword);
			Query query = session.createQuery("from Course where title like ?");
			query.setString(0, keyword);
			courseList = query.list();

			functionIterator(courseList);

			session.flush();
	        session.getTransaction().commit();
		} catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            } catch(HibernateException he2) {he2.printStackTrace(); }
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
		return courseList;
	}


    public List<Course> getAllCoursesAtDate (Date date){
        Session session = session = HibernateUtil.getSessionFactory().openSession();
        List<Course> courseList=null;

	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("select cr from Course as cr "
                                                +"inner join cr.course_sessions as crs"
                                                +" where ? <= crs.start_date");
			query.setDate(0, date);
			courseList = query.list();

			functionIterator(courseList);

			session.flush();
	        session.getTransaction().commit();
		} catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            } catch(HibernateException he2) {he2.printStackTrace(); }
	        }
		}

		finally {
	        if(session != null) {
	            try {
					session.close();
				} catch(SessionException se){
					se.printStackTrace();
				}
			}
		}
		return courseList;
	}


    public List<Course> getAllCoursesAtLocation (Location location){
        Session session = session = HibernateUtil.getSessionFactory().openSession();
        List<Course> courseList=null;

		try {
	        session.beginTransaction();
	        Query query = session.createQuery("select cr from Course as cr"
                + "                        inner join cr.course_sessions as crs"
                + "                        inner join crs.id_location as lc"
                + "                        where lc.city = ?");
			query.setString(0, location.getCity());
			courseList = query.list();

			for(Iterator iterator1 = courseList.iterator();iterator1.hasNext();) {
				Course cr = (Course)iterator1.next();
				Hibernate.initialize(cr.getCourse_sessions());
			}
			session.flush();
	        session.getTransaction().commit();
		} catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            } catch(HibernateException he2) {he2.printStackTrace(); }
	        }
		}

		finally {
	        if(session != null) {
	            try {
					session.close();
				} catch(SessionException se){
					se.printStackTrace();
				}
			}
		}
		return courseList;
	}

	private void functionIterator(List<Course> courseList) {
		for(Iterator iterator1 = courseList.iterator();iterator1.hasNext();) {
			Course cr = (Course)iterator1.next();
			Hibernate.initialize(cr.getCourse_sessions());

			for(Iterator iterator2 = cr.getCourse_sessions().iterator();iterator2.hasNext();) {
				Course_session crs = (Course_session) iterator2.next();
				Hibernate.initialize(crs.getCourse_code());
				Hibernate.initialize(crs.getId_location());
				Hibernate.initialize(crs.getClients());

				for (Iterator iterator3 = crs.getClients().iterator();iterator3.hasNext();){
					Client cl =  (Client) iterator3.next();
					Hibernate.initialize(cl.getCourse_session_id());
				}
			}
		}
	}
}
