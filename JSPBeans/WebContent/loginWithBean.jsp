<jsp:useBean id="loginBean" class="br.marcel.melo.LoginBean"/>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:setProperty name="loginBean" property="*"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login com Bean</title>
</head>
<body>
	<h1>Login With Bean!</h1>
	<% 
		if(request.getMethod().equalsIgnoreCase("post")){
			if(loginBean.login()){
				response.sendRedirect("welcome.jsp");
			}
		}
	%>
	<h1 style="color: red;">
		<jsp:getProperty property="error" name="loginBean"/>
	</h1>
	
	<form method="post" action="loginWithBean.jsp">
		<label>Username:</label>
		<input type="text" name="username" />
		<br />
		<label>Password:</label>
		<input type="password" name="password" />
		<br />
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>