<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Test Jsp</title>
</head>
<body>
<p> Bonjour from JSP </p>
<p>
	<%
		String heure = (String) request.getAttribute("heure");
		if(heure.equals("jour")){
			out.println("Bonjour");
		} else {
			out.println("Bonsoir");
		}
	%>
</p>
<p>
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