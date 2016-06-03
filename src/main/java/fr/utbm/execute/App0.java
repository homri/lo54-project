/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.execute;

import fr.utbm.controller.ClientController;
import fr.utbm.controller.CourseController;
import fr.utbm.controller.Course_sessionController;
import fr.utbm.entity.Course;
import fr.utbm.entity.Course_session;
import fr.utbm.entity.Location;
import fr.utbm.repository.CourseDao;
import fr.utbm.util.HibernateUtil;
import org.osgi.framework.*;

import java.io.File;
import java.io.InputStream;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khalil
 */
public class App0 {
    public static void main(String[] arg){
		BundleContext contexte = new BundleContext() {
			@Override
			public String getProperty(String key) {
				return null;
			}

			@Override
			public Bundle getBundle() {
				return null;
			}

			@Override
			public Bundle installBundle(String location, InputStream input) throws BundleException {
				return null;
			}

			@Override
			public Bundle installBundle(String location) throws BundleException {
				return null;
			}

			@Override
			public Bundle getBundle(long id) {
				return null;
			}

			@Override
			public Bundle[] getBundles() {
				return new Bundle[0];
			}

			@Override
			public void addServiceListener(ServiceListener listener, String filter) throws InvalidSyntaxException {

			}

			@Override
			public void addServiceListener(ServiceListener listener) {

			}

			@Override
			public void removeServiceListener(ServiceListener listener) {

			}

			@Override
			public void addBundleListener(BundleListener listener) {

			}

			@Override
			public void removeBundleListener(BundleListener listener) {

			}

			@Override
			public void addFrameworkListener(FrameworkListener listener) {

			}

			@Override
			public void removeFrameworkListener(FrameworkListener listener) {

			}

			@Override
			public ServiceRegistration<?> registerService(String[] clazzes, Object service, Dictionary<String, ?> properties) {
				return null;
			}

			@Override
			public ServiceRegistration<?> registerService(String clazz, Object service, Dictionary<String, ?> properties) {
				return null;
			}

			@Override
			public <S> ServiceRegistration<S> registerService(Class<S> clazz, S service, Dictionary<String, ?> properties) {
				return null;
			}

			@Override
			public <S> ServiceRegistration<S> registerService(Class<S> clazz, ServiceFactory<S> factory, Dictionary<String, ?> properties) {
				return null;
			}

			@Override
			public ServiceReference<?>[] getServiceReferences(String clazz, String filter) throws InvalidSyntaxException {
				return new ServiceReference<?>[0];
			}

			@Override
			public ServiceReference<?>[] getAllServiceReferences(String clazz, String filter) throws InvalidSyntaxException {
				return new ServiceReference<?>[0];
			}

			@Override
			public ServiceReference<?> getServiceReference(String clazz) {
				return null;
			}

			@Override
			public <S> ServiceReference<S> getServiceReference(Class<S> clazz) {
				return null;
			}

			@Override
			public <S> Collection<ServiceReference<S>> getServiceReferences(Class<S> clazz, String filter) throws InvalidSyntaxException {
				return null;
			}

			@Override
			public <S> S getService(ServiceReference<S> reference) {
				return null;
			}

			@Override
			public boolean ungetService(ServiceReference<?> reference) {
				return false;
			}

			@Override
			public <S> ServiceObjects<S> getServiceObjects(ServiceReference<S> reference) {
				return null;
			}

			@Override
			public File getDataFile(String filename) {
				return null;
			}

			@Override
			public Filter createFilter(String filter) throws InvalidSyntaxException {
				return null;
			}

			@Override
			public Bundle getBundle(String location) {
				return null;
			}
		};


		/**
         * le travail dans la servlet pour ajouter un client
         */
        /*
        ClientController clc = new ClientController();
	 	clc.insertClientControllerWithoutEmail(1, "lahmade","felix","2 rue Sadeline","0782524183");
        HibernateUtil.getSessionFactory().close();
        */
/*
		Course_sessionController course_sessionController = new Course_sessionController();
		for (Course_session course_session : course_sessionController.getAllCourse_session()) {
			System.out.println(course_session.getCourse_code().getCourse_code() + " - " + course_session.getCourse_code().getTitle());
		}
*/
        CourseDao crd = new CourseDao();
        //List<Course> listecourses = crd.getAllCourses();
        //List<Course> listecourses = crd.getAllCoursesPerKeyWord("z");
        Date d;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            d=simpleDateFormat.parse("2016-06-10");
            Location lcn = new Location(1, "Belfort");
         	List<Course> listecourses = crd.getAllCoursesAtDateLocation(d,lcn);
         	System.out.println(listecourses.size());
        	if(listecourses.size()>0) {
        		System.out.println(listecourses.size()+" : "+listecourses.get(0).getTitle());
			}

        } catch (ParseException ex) {
            Logger.getLogger(App0.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Location lcn = new Location("Montbéliard", 1);
        
        List<Course> listecourses = crd.getAllCoursesAtLocation(lcn);
        System.out.println(listecourses.size());

        if(listecourses.size()>0) {
            System.out.println(listecourses.size()+" : "+listecourses.get(0).getTitle());
        }

        for(Iterator iterator1 = listecourses.get(0).getCourse_sessions().iterator();iterator1.hasNext();) {
            Course_session a=(Course_session)iterator1.next();
            System.out.println(a.getId_location().getCity());
        }*/
        HibernateUtil.getSessionFactory().close();
       
    }
}
