<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>

<c:if test="${!empty nom }"><p><c:out value =" Bonjour, vous vous appelez ${ nom }"/></p></c:if>
<c:if test="${!empty form.resultat }"><p><c:out value ="${ form.resultat }"/></p></c:if>
	<form method="post" action="formulaire">
		<label for="nom">Nom : </label>
		<input type="text" id="nom" name= "nom"/>
		<input type="submit"/>
	</form>

		<form method="post" action="formulaire">
		<p>
		<label for="login">Login : </label>
		<input type="text" id="login" name= "login"/>
		</p>
		
		<p>
		<label for="password">Password : </label>
		<input type="password" id="password" name= "password"/>
		</p>
		
		<input type="submit"/>	
	</form>
</body>
</html>