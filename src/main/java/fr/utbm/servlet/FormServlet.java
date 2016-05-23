package fr.utbm.servlet;

import fr.utbm.controller.ClientController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Mac-Guillaume on 21/05/16.
 */
@WebServlet(name = "FormServlet", value = "/test")
public class FormServlet extends HttpServlet {

	private ClientController clientController = new ClientController();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();

		clientController.insertClientControllerWithoutEmail(
				Integer.parseInt(request.getParameter("id_session")),
				request.getParameter("lastname"),
				request.getParameter("firstname"),
				request.getParameter("adress"),
				request.getParameter("phone"));

		out.println( "<HTML>" );
		out.println( "<HEAD>");
		out.println( "<TITLE>Insert client</TITLE>" );
		out.println( "</HEAD>" );
		out.println( "<BODY>" );
		out.println( "<H1>Le client suivant à été ajouté : </H1>" );
		out.println("Id_session : "+request.getParameter("id_session")+"<br>Lastname : " +request.getParameter("lastname")
				+ "<br>Firstname : " + request.getParameter("firstname")+ "<br>Adress : " +request.getParameter("adress")
				+ "<br>Phone : " + request.getParameter("phone"));
		out.println( "</BODY>" );
		out.println( "</HTML>" );
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
	}
}
