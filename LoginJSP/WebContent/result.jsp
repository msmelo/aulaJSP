<jsp:useBean id="pageBean" class="br.marcel.melo.JavaBean" scope="request"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Valor: <%= pageBean.getValor() %></h1>
</body>
</html>