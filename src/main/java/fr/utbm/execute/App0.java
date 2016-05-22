/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.execute;

import fr.utbm.controller.ClientController;
import fr.utbm.entity.Course;
import fr.utbm.entity.Course_session;
import fr.utbm.entity.Location;
import fr.utbm.repository.CourseDao;
import fr.utbm.util.HibernateUtil;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khalil
 */
public class App0 {
    public static void main(String[] arg){
        /**
         * le travail dans la servlet pour ajouter un client
         */
        /*
        ClientController clc = new ClientController();
	 	clc.insertClientControllerWithoutEmail(1, "lahmade","felix","2 rue Sadeline","0782524183");
        HibernateUtil.getSessionFactory().close();
        */

        CourseDao crd = new CourseDao();
        //List<Course> listecourses = crd.getAllCourses();
        //List<Course> listecourses = crd.getAllCoursesPerKeyWord("z");
        Date d;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            d=simpleDateFormat.parse("2016-06-09");
         	List<Course> listecourses = crd.getAllCoursesAtDate(d);
         	System.out.println(listecourses.size());
        	if(listecourses.size()>0) {
        		System.out.println(listecourses.size()+" : "+listecourses.get(0).getTitle());
			}

        } catch (ParseException ex) {
            Logger.getLogger(App0.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Location lcn = new Location("Belfort", 1);
        
        List<Course> listecourses = crd.getAllCoursesAtLocation(lcn);
        System.out.println(listecourses.size());

        if(listecourses.size()>0) {
            System.out.println(listecourses.size()+" : "+listecourses.get(0).getTitle());
        }

        for(Iterator iterator1 = listecourses.get(0).getCourse_sessions().iterator();iterator1.hasNext();) {
            Course_session a=(Course_session)iterator1.next();
            System.out.println(a.getId_location().getCity());
        }
        HibernateUtil.getSessionFactory().close();
        */
    }
}
