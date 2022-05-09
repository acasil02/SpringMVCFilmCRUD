<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Film</title>
</head>
<body>

	<form action="updateFilm.do" method="POST">
	
		<label for="title">Title</label>
		<input type="text" name="title" placeholder="${film.title}" value="${film.title}" > 
		<br>
		
		<label for="description">Description</label>
		<input type="text" name="description" value="${film.description}" >
		<br>
		
		<label for="releaseYear">Release Year</label> 
		<input type="text" name="releaseYear" value="${film.releaseYear}" >
		 <br>
		 
		<label for="languageId">Language </label>
						<select name="language" required>
  						<option value="1">English</option>
  						<option value="2">Italian</option>
  						<option value="3">Japanese</option>
  						<option value="4">Mandarin</option>
  						<option value="5">French</option>
  						<option value="6">German</option>
  						</select><br>
		
		
		<label for="rentalDuration">Rental Duration</label>
		<input type="text" name="rentalDuration" value="${film.rentalDuration}" > 
		<br>
		
		<label for="rentalRate">Rental Rate</label>
		<input type="text" name="rentalRate" value="${film.rentalRate}" > 
		<br>
		
		<label for="length">Length</label>
		<input type="text" name="length" value="${film.length}" > 
		<br>
		
		<label for="replacementCost">Replacement Cost</label>
		<input type="text" name="replacementCost" value="${film.replacementCost}" >
		<br>
		
		<label for="rating">Rating</label> 
		<select name="rating" required><br>
  						<option value="G">G</option>
  						<option value="PG">PG</option>
  						<option value="PG13">PG13</option>
  						<option value="R">R</option>
  						<option value="NC17">NC17</option>
  						</select><br>
		
		<label for="specialFeature">Special Features</label>
		<input type="text" name="specialFeatures" min="1" max="5" value="${film.specitalFeatures}" > 
		<br>
		<input type="hidden" name="filmId" value="${film.id}" />
		<input class="Submit" type="submit" value="Submit" />
		
		
		<br><br><br>
	</form>
	<br>
	
	
	<form action="home.do" method="GET">
		<input type="submit" value="Home" />
	</form>




</body>
</html>