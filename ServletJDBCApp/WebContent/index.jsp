<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.bridgelabz.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demonstration of Session and Cookie using JSP</title>
</head>
<body>
	<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    
	String sessionId = null;
	String userName = null;
	HttpSession session1 = request.getSession();
	if(session1.getAttribute("name") == null){
		response.sendRedirect("Index.html");
	}else{	
		
		Cookie[] ck = request.getCookies();
		if (ck != null) {
			for (Cookie cookie : ck) {
				if (cookie.getName().equals("uname")) {
					if (cookie.getValue().equals(null) || cookie.getValue().equals("")){
						response.sendRedirect("Index.html");
					}else{
						userName = cookie.getValue();
					}
				}
				if (cookie.getName().equals("JSESSIONID")){
					if (cookie.getValue().equals(null) || cookie.getValue().equals("")){
						response.sendRedirect("Index.html");
					}else{
						sessionId = cookie.getValue();
					}
				}
			}
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
	<div>
		<a href="profile.jsp">My Profile</a>
	</div>
</body>
</html>
