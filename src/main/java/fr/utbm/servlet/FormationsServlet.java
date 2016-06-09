package fr.utbm.servlet;

import fr.utbm.controller.CourseController;
import fr.utbm.controller.LocationController;
import fr.utbm.entity.Course;
import fr.utbm.entity.Course_session;
import fr.utbm.entity.Location;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Mac-Guillaume on 25/05/16.
 */
@WebServlet(name = "FormationsServlet", value = "/formations")
public class FormationsServlet extends HttpServlet {

	private CourseController courseController = new CourseController();
    private LocationController locationController = new LocationController();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();

        SimpleDateFormat formater = new SimpleDateFormat("MM/dd/yyyy");

        String type=request.getParameter("type");
        List<Course> courses=null;

        if(type.equals("date-sorting")) {
            Date date = null;
            try {
                date = formater.parse(request.getParameter("date"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            courses = courseController.getAllCoursesAtDateController(date);
        }else if(type.equals("place-sorting")) {
            String res= request.getParameter("place");
            int id = Integer.parseInt(res);
            Location location = locationController.getLocationById(id);
            courses = courseController.getAllCoursesAtLocationController (location);
        }else if(type.equals("filter-sorting")) {
            courses = courseController.getAllCoursesPerKeyWordController(request.getParameter("keyword"));
        }else{
                out.println("On n'applique pas bien le filtre.");
        }

        List<Location> locations = LocationController.getAllLocations();

        out.println( "<HTML>" );
        out.println( "<HEAD>");
        out.println( "<TITLE>Liste formations</TITLE>" );
        out.println("<script src=\"../js/jquery.js\"></script>");
        out.println("<script src=\"../jquery-ui/jquery-ui.min.js\"></script>");
        out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"../jquery-ui/jquery-ui.min.css\" />\n");
        out.println("<script src=\"styles/bootstrap/js/bootstrap.min.js\" ></script>\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"styles/bootstrap/css/bootstrap.min.css\" />");
        out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"styles/styles.css\" />\n");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<script>  $(function() {\n" +
                "    $( \"#datepicker\" ).datepicker();\n" +
                "  });\n" +
                "  </script>");
        out.println( "</HEAD>" );
        out.println( "<BODY>" );
        out.println( "<H1>Liste des formations disponibles : </H1>" );

        for (Course course : courses) {
            out.println("<b>" + course.getCourse_code() + " - " + course.getTitle() + "</b>");
            out.println("<br>");
            for (Object object : course.getCourse_sessions()) {
                Course_session course_session = (Course_session) object;
                out.println("<a class=\"icon\" href='/inscription?id_session="
                        + course_session.getCourse_session_id() + "'>Du "
                        + formater.format(course_session.getStart_date()) + " au "
                        + formater.format(course_session.getEnd_date()) + "<img src=\"styles/svg/add-button.svg\"></a> à "
                        + course_session.getId_location().getCity() + "<br>");
            }
            out.println("<br>");
        }
        out.println("<a href=\"./formations\">Retour à la liste complète</a>");
        out.println("<script src=\"../js/script.js\"></script>");
        out.println( "</BODY>" );
        out.println( "</HTML>" );
        out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();

		SimpleDateFormat formater = new SimpleDateFormat("dd MMMM yyyy");
		List<Course> courses = courseController.getAllCourses();
        List<Location> locations = LocationController.getAllLocations();

		out.println( "<HTML>" );
		out.println( "<HEAD>");
		out.println( "<TITLE>Liste formations</TITLE>" );
        out.println("<script src=\"../js/jquery.js\"></script>");
        out.println("<script src=\"../jquery-ui/jquery-ui.min.js\"></script>");
        out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"../jquery-ui/jquery-ui.min.css\" />\n");
        out.println("<script src=\"styles/bootstrap/js/bootstrap.min.js\" ></script>\n" +
                    "<link type=\"text/css\" rel=\"stylesheet\" href=\"styles/bootstrap/css/bootstrap.min.css\" />");
		out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"styles/styles.css\" />\n");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<script>  $(function() {\n" +
                "    $( \"#datepicker\" ).datepicker();\n" +
                "  });\n" +
                "  </script>");
		out.println( "</HEAD>" );
		out.println( "<BODY>" );
		out.println( "<H1>Liste des formations disponibles : </H1>" );
		out.println("<div class=\"sort\"><span>Trier par :</span>" +
                        "<ul class=\"sort-list\">" +
                            "<li><a id=\"sort-by-date\">Date<img src=\"styles/svg/note.svg\"></a></li>" +
                            "<li><a id=\"sort-by-place\">Lieu<img src=\"styles/svg/pin.svg\"></a></li>" +
                            "<li><a id=\"sort-by-search\">Mot-Clé<img src=\"styles/svg/browser-visualization.svg\"></a></li>" +
                        "</ul>" +
                    "</div>");
		for (Course course : courses) {
			out.println("<b>" + course.getCourse_code() + " - " + course.getTitle() + "</b>");
			out.println("<br>");
			for (Object object : course.getCourse_sessions()) {
				Course_session course_session = (Course_session) object;
				out.println("<a class=\"icon\" href='./inscription?id_session="
						+ course_session.getCourse_session_id() + "'>Du "
						+ formater.format(course_session.getStart_date()) + " au "
						+ formater.format(course_session.getEnd_date()) + "<img src=\"styles/svg/add-button.svg\"></a> à "
						+ course_session.getId_location().getCity() + "<br>");
			}
			out.println("<br>");
		}
        out.println("<div class=\"date-sorting modale\">" +
                "<form action=\"./formations\" method=\"post\" role=\"form\">" +
                "<input type=\"hidden\" name=\"type\" value=\"date-sorting\">" +
                "Choisir une date : <input type=\"text\"  id=\"datepicker\" name=\"date\">" +
                "<button type=\"submit\" class=\"btn btn-primary\">Valider</button>" +
                "<img src=\"styles/svg/close.svg\" class=\"close-modale\" />" +
                "</form>" +
                "</div>");
        out.println("<div class=\"place-sorting modale\">" +
                "<form action=\"./formations\" method=\"post\" role=\"form\">" +
                "<input type=\"hidden\" name=\"type\" value=\"place-sorting\">" +
                "<select name=\"place\" class=\"form-control\">\n");
                for (Location location : locations) {
                    out.println("<option value=\""+location.getId_location()+"\">"+location.getCity()+"</option>");
                }
                out.println("</select>" +
                "<button type=\"submit\" class=\"btn btn-primary\">Valider</button>" +
                "</form>" +
                "<img src=\"styles/svg/close.svg\" class=\"close-modale\"/>" +
                "</div>");
        out.println("<div class=\"filter-sorting modale\">" +
                "<form action=\"./formations\" method=\"post\" role=\"form\">" +
                "<input type=\"hidden\" name=\"type\" value=\"filter-sorting\">" +
                "Mot-clé : <input type=\"text\"  name=\"keyword\">" +
                "<button type=\"submit\" class=\"btn btn-primary\">Valider</button>" +
                "<img src=\"styles/svg/close.svg\" class=\"close-modale\"/>" +
                "</form>" +
                "</div>");
        out.println("<script src=\"../js/script.js\"></script>");
		out.println( "</BODY>" );
		out.println( "</HTML>" );
		out.close();
	}
}
