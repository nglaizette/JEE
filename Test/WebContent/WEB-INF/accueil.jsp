
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Accueil Jsp</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<p> Accueil of my website from JSP </p>
<p> <c:out value="Bonjour from Jstl !" /></p>
<p> <c:out value="${ variable }" default="My default value">  </c:out></p>
<p> <c:out value="${ variable }" default="My default value" escapeXml="false"></c:out></p>
<p> <c:out value="${ variable }" escapeXml="false"> My default value</c:out></p>
<c:set var="pseudo" value="Mateo21" scope="page"/>
<p><c:out value="${ pseudo }" /></p>
<p> Autre façon d'initialiser la variable</p>
<c:set var="pseudo" scope="page">NewPseudo</c:set>
<p><c:out value="${ pseudo }" /></p>

<h1> Modification de bean</h1>
<p><c:out value="${ auteur.prenom }" /></p>
<c:set target="${ auteur }" property="prenom" value="Mathieu" />
<p><c:out value="${ auteur.prenom }" /></p>

</body>
</html>