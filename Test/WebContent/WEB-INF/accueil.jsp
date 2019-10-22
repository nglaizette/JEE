
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

<h1> JSTL et conditions</h1>
<c:if test="${ 50 > 10 }">
	C'est vrai !
</c:if>

<c:if test="${ 50 > 10 }" var="test1" scope="page">
	C'est vrai !
</c:if>
<p><c:out value="${ test1 }" /></p>
<h2>Tests multiples</h2>
<c:choose>
    <c:when test="${ test1 }">Du texte (test1)</c:when>
    <c:when test="${ autreVariable }">Du texte</c:when>
    <c:when test="${ encoreUneAutreVariable }">Du texte</c:when>
    <c:otherwise>"text sinon"</c:otherwise>
</c:choose>

<h1> JSTL et boucles</h1>
<c:forEach step ="1" begin="0" end="10" var="i">
	Un message n°<c:out value="${ i }"></c:out> !<br/>
</c:forEach>

<c:forEach items="${ titres }" var="titre" begin="0" end="1" varStatus="status">
	N°<c:out value="${ status.count }" /> : <c:out value = "${ titre }"/><br/>
</c:forEach>

<h2>Spécial chaine de caractère</h2>
<c:forTokens var="morceau" items="Un élément/Encore un autre élément/Un dernier pour la route" delims="/ ">
    <p>${ morceau }</p>
</c:forTokens>
</body>
</html>