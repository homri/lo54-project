<%--
  Created by IntelliJ IDEA.
  User: Mac-Guillaume
  Date: 23/05/16
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Home sweet home</h1>

    <form action="http://localhost:8080/test" method="post" role="form">
    	<legend>Test Form</legend>
    
    	<div class="form-group">
    		<label for="id_session">Session ID </label>
    		<input type="text" class="form-control" name="id_session" id="id_session" placeholder="1">
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
			<label for="adress">Adress </label>
			<input type="text" class="form-control" name="adress" id="adress" placeholder="3 chemin des loups 90000 Belfort">
		</div>

		<div class="form-group">
			<label for="phone">Phone </label>
			<input type="text" class="form-control" name="phone" id="phone" placeholder="0123456789">
		</div>

    	<button type="submit" class="btn btn-primary">Envoyer</button>
    </form>
</body>
</html>
