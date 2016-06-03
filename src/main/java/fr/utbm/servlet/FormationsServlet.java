package fr.utbm.servlet;

import fr.utbm.controller.CourseController;
import fr.utbm.controller.Course_sessionController;
import fr.utbm.entity.Course;
import fr.utbm.entity.Course_session;
import fr.utbm.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Mac-Guillaume on 25/05/16.
 */
@WebServlet(name = "FormationsServlet", value = "/formations")
public class FormationsServlet extends HttpServlet {

	private CourseController courseController = new CourseController();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();

		SimpleDateFormat formater = new SimpleDateFormat("dd MMMM yyyy");
		List<Course> courses = courseController.getAllCourses();

		out.println( "<HTML>" );
		out.println( "<HEAD>");
		out.println( "<TITLE>Liste formations</TITLE>" );
        out.println("<script src=\"../js/jquery.js\"></script>");
        out.println("<script src=\"styles/bootstrap/js/bootstrap.min.js\" ></script>\n" +
                    "<link type=\"text/css\" rel=\"stylesheet\" href=\"styles/bootstrap/css/bootstrap.min.css\" />");
		out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"styles/styles.css\" />\n");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println( "</HEAD>" );
		out.println( "<BODY>" );
		out.println( "<H1>Liste des formations disponibles : </H1>" );

		for (Course course : courses) {
			out.println("<b>" + course.getCourse_code() + " - " + course.getTitle() + "</b>");
			out.println("<br>");
			for (Object object : course.getCourse_sessions()) {
				Course_session course_session = (Course_session) object;
				out.println("<a class=\"icon\" href='http://localhost:8080/inscription?id_session="
						+ course_session.getCourse_session_id() + "'>Du "
						+ formater.format(course_session.getStart_date()) + " au "
						+ formater.format(course_session.getEnd_date()) + "<img src=\"styles/svg/add-button.svg\"></a> à "
						+ course_session.getId_location().getCity() + "<br>");
			}
			out.println("<br>");
		}
        out.println("<script src=\"../js/script.js\"></script>");
		out.println( "</BODY>" );
		out.println( "</HTML>" );
		out.close();
	}
}
