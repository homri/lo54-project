package fr.utbm.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Mac-Guillaume on 21/05/16.
 */
@WebServlet(name = "testServlet", value = "/test")
public class testServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void service (ServletRequest req, ServletResponse res ) throws ServletException, IOException  {
		res.setContentType( "text/html" );
		PrintWriter out = res.getWriter();
		out.println( "<HTML>" );
		out.println( "<HEAD>");
		out.println( "<TITLE>Page generee par une servlet</TITLE>" );
		out.println( "</HEAD>" );
		out.println( "<BODY>" );
		out.println( "<H1>Bonjour</H1>" );
		out.println( "</BODY>" );
		out.println( "</HTML>" );
		out.close();
	}
}
