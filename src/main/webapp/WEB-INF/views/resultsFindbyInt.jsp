 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film!</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty film}">
		<strong>${film.title }</strong> <br>
		Released in: ${film.releaseYear } <br>
				${film.description } <br>
				Starring: ${film.cast } <br>
				${film.categories }
		</c:when>
		<c:otherwise>
			<h1>No film found</h1>
		</c:otherwise>
	</c:choose>
	<form action="getFilmFromId.do?">
    <input type="submit" value="Go back to Input another ID" />
</form>

<form action="updateFilm.do">
		<input type ="submit" value="Update Film">
	</form>
	

	<form action="home.do">
    <input type="submit" value="Go Home" />
</form>
</body>
</html>