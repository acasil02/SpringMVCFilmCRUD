<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Film</title>
</head>
<body>


<h3>Create Film</h3>
	<div class="creatFilmMasterDiv">
		<div class="createFilmFormDiv">
			<form action="CreateFilm.do" method="post">
				<label for="filmTitle">Film Title:</label> 
				<input type="text" name="title"><br>
			
				<label for="filmDescription">Description:</label> 
				<input type="text" name="description"><br>
			
				<label for="filmReleaseYear">Release Year:</label> 
				<input type="text" name="releaseYear"><br>
			
				<label for="filmlanguage">Language:</label> 
						<select name="language">
  						<option value="English">English</option>
  						<option value="Italian">Italian</option>
  						<option value="Japanese">Japanese</option>
  						<option value="Mandarin">Mandarin</option>
  						<option value="French">French</option>
  						<option value="German">German</option>
  						</select><br>
				
				<label for="filmRentalDuration">Rental Duration:</label> 
				<input type="text" name="rentalDuration"><br>
		
				<label for="filmRentalRate">Rental Rate:</label> 
				<input type="text" name="rentalRate"><br>
				
				<label for="filmLength">Length:</label> 
				<input type="text" name="length"><br>
				
				<label for="filmReplacementCost">Replacement Cost:</label> 
				<input type="text" name="replacementCost"><br>
				
				<label for="filmRating">Rating:</label> 
				<select name="rating"><br>
  						<option value="G">G</option>
  						<option value="PG">PG</option>
  						<option value="PG13">PG13</option>
  						<option value="R">R</option>
  						<option value="NC17">NC17</option>
  						</select><br>
				
				<label for="filmSpecitalFeatures">Special Features:</label> 
						<select name="specialFeatures"><br>
  						<option value="Trailers">Trailers</option>
  						<option value="Commentaries">Commentaries</option>
  						<option value="Deleted Scenes">Deleted Scenes</option>
  						<option value="Behind the Scenes">Behind the Scenes</option>
  						</select><br>
  						
				
				<label for="filmCast">Cast:</label> 
				<input type="text" name="cast"><br>
				
				<label for="filmCategories">Categories:</label> 
				<input type="text" name="categories"><br>

				
				<input type="submit">
				
				
				
	
			</form>
		</div>
	</div>

	<h1></h1>


</body>
</html>