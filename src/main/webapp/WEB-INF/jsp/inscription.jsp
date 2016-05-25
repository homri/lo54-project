<%@ page import="fr.utbm.controller.Course_sessionController" %>
<%@ page import="fr.utbm.entity.Course_session" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Mac-Guillaume
  Date: 23/05/16
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription session</title>
</head>
<body>
    <h1>Inscription session</h1>

    <form action="http://localhost:8080/inscription" method="post" role="form">
    	<legend><%
			SimpleDateFormat formater = new SimpleDateFormat("dd MMMM yyyy");
			Course_sessionController course_sessionController = new Course_sessionController();
			Course_session course_session = course_sessionController.getCourse_sessionById(request.getParameter("id_session"));
			out.println(course_session.getCourse_code().getCourse_code() + " - "
					+ course_session.getCourse_code().getTitle() + " : du "
					+ formater.format(course_session.getStart_date()) + " au "
					+ formater.format(course_session.getEnd_date()));
		%></legend>
		<br>
    
    	<div class="form-group" hidden="true">
    		<input type="text" class="form-control" name="id_session" id="id_session"
				   value="<%
						if (request.getParameter("id_session") == null) {
							out.println("Donner l'id de la session");
						} else {
							out.println(request.getParameter("id_session"));
						}
					%>">
    	</div>

		<div class="form-group">
			<label for="lastname">Lastname </label>
			<input type="text" class="form-control" name="lastname" id="lastname" placeholder="Dupont">
		</div>

		<div class="form-group">
			<label for="firstname">Firstname </label>
			<input type="text" class="form-control" name="firstname" id="firstname" placeholder="Michel">
		</div>

		<div class="form-group">
			<label for="address">Address </label>
			<input type="text" class="form-control" name="address" id="address"
				   placeholder="3 chemin des loups 90000 Belfort" size="50px">
		</div>

		<div class="form-group">
			<label for="phone">Phone </label>
			<input type="text" class="form-control" name="phone" id="phone" placeholder="0123456789">
		</div>
		<br>
    	<button type="submit" class="btn btn-primary">S'inscrire</button>
    </form>
</body>
</html>
