<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Test Jsp</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<p> Bonjour, ${ empty name ? '': name } from JSP </p>
<p> Bonjour, ${ names[1] } from tableau </p>
<p> L'auteur du site est  ${ auteur.prenom } ${ auteur.nom } </p>
<p> ${ auteur.actif ? 'Vous êtes très actif' : 'Vous êtes inactif !' } </p>
<p>
	<%
		String heure = (String) request.getAttribute("heure");
		if(heure.equals("jour")){
			out.println("Bonjour");
		} else {
			out.println("Bonsoir");
		}
	%>
</p><p>
	<%
		String variable = (String) request.getAttribute("myvar");
		out.println(variable);
	%>
</p>
<p>
	<%
		for(int i = 0; i< 20; i++){
			out.println("Une nouvelle ligne " + (i+1) + "! <br>");
		}
	%>
</p>

</body>
</html>