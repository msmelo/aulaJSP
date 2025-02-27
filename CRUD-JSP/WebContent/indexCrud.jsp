<%@page import="br.marcel.melo.crud.User"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>CRUD Users</title>
		<link type="text/css" href="estilos.css" rel="stylesheet">
	</head>
	<body>
		<h1>List of users</h1>
		
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>CPF</th>
					<th>E-mail</th>
					<th colspan="2">Ações</th>
				</tr>
			</thead>
			<tbody>
		
		
		<%
			ArrayList<User> usuarios = (ArrayList<User>)request.getAttribute("usuarios");
			for(User user : usuarios){
		%>
				<tr>
					<th><%= user.getId()%></th>
					<th><%= user.getName()%></th>
					<th><%= user.getCpf()%></th>
					<th><%= user.getEmail()%></th>
					<th><a href=<%= "EditarUsuario?id="+user.getId()%>>Editar</a></th>
					<th><a href=<%= "RemoverUsuario?id="+user.getId()%>>Deletar</a></th>
				</tr>
				
		<%	
			}
		%>
		</tbody>
		</table>
		
		<form method="GET" action="NovoUsuario">
			<input type="submit" value="Novo Usuário" />
		</form>
	
	</body>
</html>