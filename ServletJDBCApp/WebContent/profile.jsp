<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.bridgelabz.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>
</head>
<body>
<%
		User user = new User();
		if (session.getAttribute("name") == null) {
			response.sendRedirect("Index.html");
		} else
			user = (User) session.getAttribute("name");
		String userName = null;
		Cookie[] ck = request.getCookies();
		if (ck != null) {
			for (Cookie cookie : ck) {
				if (cookie.getName().equals("uname"))
					userName = cookie.getValue();
			}
		}
	%>
	<h4><%=userName %>, Welcome to your profile</h4>
	<br>
	<h5>Your Details: </h5>
	<br>
	First Name: <%=user.getFirstName() %> <br>
	Last Name: <%=user.getLastName() %><br>
	Contact: <%=user.getContact()%><br>	
	<form action="logout" method="post"> 
	<input type="submit" value="logout">
	</form>
	<form action="edit">
	<input type="submit" value="edit">
	</form>
	
</body>
</html>