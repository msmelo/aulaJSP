<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" 
content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	<% out.println("Hello World, JSP!");%>
</h1>

<% out.println("Server address: "+ request.getRemoteAddr()+
		":"+ request.getRemotePort()); %>
		
</body>
</html>