<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
=======
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
>>>>>>> 23d4ded86761297aa075d177677c90bac60d3ac7
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results</title>
</head>
<body>


	<c:if test="${confirmDeletion}">
		<c:choose>
			<c:when test="${isFilmDeleted}">
				<div>
					<h2>Film Deleted</h2>
					<form action="home.do">
						<input type="submit" value="home">
					</form>



				</div>
			</c:when>
			<c:when test="${!isFilmDeleted}">
				<div>
					<h2>Film cannot be deleted</h2>
					<form action="home.do">
						<input type="submit" value="home">
					</form>
				</div>
			</c:when>
		</c:choose>

	</c:if>






</body>
</html>