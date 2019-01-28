<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demonstration of Session and Cookie using JSP</title>
</head>
<body>
	<%
		String user = null;
		if (session.getAttribute("name") == null) {
			response.sendRedirect("login.html");
		} else
			user = (String) session.getAttribute("name");
		String sessionId = null;
		String userName = null;
		Cookie[] ck = request.getCookies();
		if (ck != null) {
			for (Cookie cookie : ck) {
				if (cookie.getName().equals("uname"))
					userName = cookie.getValue();
				if (cookie.getName().equals("JSESSIONID"))
					sessionId = cookie.getValue();
			}
		}
	%>
	<h4>
		Hello
		<%=userName%>, you've logged in successfully
	</h4>
	<br> Your sessionID is
	<%=sessionId%>
	<br>
	<form action="logout" method="post">
		<input type="submit" value="logout">
	</form>
</body>
</html>