<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie</title>
</head>
<body>
<%@ include file="menu.jsp" %>
    <c:out value="${ prenom }" />
    <form method="post" action="cookie">
        <p>
            <label for="cookienom">Nom : </label>
            <input type="text" name="cookienom" id="cookienom" />
        </p>
        <p>
            <label for="cookieprenom">Prénom : </label>
            <input type="text" name="cookieprenom" id="cookieprenom" />
        </p>
        
        <input type="submit" />
    </form>
</body>
</html>