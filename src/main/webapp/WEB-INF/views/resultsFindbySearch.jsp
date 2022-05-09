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
		<c:when test="${!empty films}">
			<c:forEach var="film" items="${films}">

				<strong>${film.title }</strong> ${film.id }<br> 
		Released in: ${film.releaseYear } <br>
				${film.description } <br>
				Starring: ${film.cast } <br>
				${film.categories } <br>
				<br>
				<form action="findByUpdateID.do">
					<label for="id"> <input type="text" name="filmId"
						value=${film.id } name="id" hidden> <input type="submit"
						value="Update Film">
					</label>
				</form>
				<form action="deleteFilm.do">
				<input type="submit" value="Delete Film" />
				<input style="display:none" name="id" value="${film.id}" />
			</form>
	
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h1>No films found</h1>
		</c:otherwise>
	</c:choose>
	<form action="getFilmFromId.do?">
		<input type="submit" value="Go back to Input another ID" />
	</form>
	<form action="home.do">
		<input type="submit" value="Go Home" />
	</form>
</body>
</html>