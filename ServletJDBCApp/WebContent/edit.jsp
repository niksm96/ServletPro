<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.bridgelabz.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
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
	<form action="update" method="post">
		First Name:<br> <input type="text" name="firstName" placeholder="<%=user.getFirstName() %>" /><br>
		Last Name:<br> <input type="text" name="lastName" placeholder="<%=user.getLastName() %>"/><br>
		Contact No:<br> <input type="text" name="contact" placeholder="<%=user.getContact() %>"/><br>
		Email-Id:<br>
		<%=user.getEmailId()%><br> Password:<br> <input type="text"
			name="password" /><br>
		<button type="submit" value="save"></button>
	</form>
</body>
</html>