<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Editar usuário</h1>
	<form method="POST" action="formUser.jsp">
		<label>
			Nome: <input type="text" name="name" required/>
		</label>
		<br />
		<label>
			E-mail: <input type="email" name="email" required/>
		</label>
		<br />
		<label>
			CPF: <input type="text" name="cpf" required/>
		</label>
		<br />
		<input type="submit" value="Enviar"/>
	</form>

</body>
</html>