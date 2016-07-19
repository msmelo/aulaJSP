<%@ page import="br.marcel.melo.crud.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% User usuario = (User) request.getAttribute("usuario"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Editar usuário</h1>
	<form method="POST" action="EditarUsuario">
		<label>
			ID: <input type="hidden" name="id" value=${usuario.id} />
		</label>
		<label>
			Nome: <input type="text" name="name" required value=${usuario.name} />
		</label>
		<br />
		<label>
			E-mail: <input type="email" name="email" required value=${usuario.email} />
		</label>
		<br />
		<label>
			CPF: <input type="text" name="cpf" required value=${usuario.cpf} />
		</label>
		<br />
		<input type="submit" value="Enviar"/>
	</form>
	<form method="GET" action="ListarUsuarios">
			<input type="submit" value="Voltar" />
	</form>
</body>
</html>