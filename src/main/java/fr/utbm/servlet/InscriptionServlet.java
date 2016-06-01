package fr.utbm.servlet;

import fr.utbm.controller.ClientController;
import fr.utbm.controller.Course_sessionController;
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

/**
 * Created by Mac-Guillaume on 21/05/16.
 */
@WebServlet(name = "InscriptionServlet", value = "/inscription")
public class InscriptionServlet extends HttpServlet {

	private ClientController clientController = new ClientController();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
		SimpleDateFormat formater = new SimpleDateFormat("dd MMMM yyyy");
		Course_sessionController course_sessionController = new Course_sessionController();
		Course_session course_session = course_sessionController.getCourse_sessionById(request.getParameter("id_session"));
		PrintWriter out = response.getWriter();

		clientController.insertClientControllerWithoutEmail(
				Integer.parseInt(request.getParameter("id_session")),
				request.getParameter("lastname"),
				request.getParameter("firstname"),
				request.getParameter("address"),
				request.getParameter("phone"));
		out.println( "<!DOCTYPE HTML>");
		out.println( "<HTML>" );
		out.println( "<HEAD>");
		out.println( "<TITLE>Insert client</TITLE>" );
		out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"styles/styles.css\" />\n");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println( "</HEAD>" );
		out.println( "<BODY>" );
		out.println( "<H1>Le client suivant à été ajouté : </H1>" );
		out.println(course_session.getCourse_code().getCourse_code() + " - <b>"
				+ course_session.getCourse_code().getTitle() + "</b> : du <b>"
				+ formater.format(course_session.getStart_date()) + "</b> au <b>"
				+ formater.format(course_session.getEnd_date())+ "</b>");
		out.println("<br><br>");
		out.println("Lastname : " +request.getParameter("lastname")
				+ "<br>Firstname : " + request.getParameter("firstname")
				+ "<br>Address : " +request.getParameter("address")
				+ "<br>Phone : " + request.getParameter("phone"));
		out.println("<br><br>");
		out.println("<a href='http://localhost:8080/formations'>Retour liste des sessions</a>");
		out.println( "</BODY>" );
		out.println( "</HTML>" );
		out.close();


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	}
}
