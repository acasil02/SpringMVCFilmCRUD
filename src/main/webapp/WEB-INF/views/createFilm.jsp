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
			<form action="CreateFilm.do" method="POST">
				<label for="filmTitle">Film Title:</label> 
				<input type="text" name="title"><br>
			
				<label for="filmDescription">Description:</label> 
				<input type="text" name="description"><br>
			
				<label for="filmReleaseYear">Release Year:</label> 
				<input type="text" name="releaseYear"><br>
			
				<label for="filmlanguage">Language:</label> 
						<select name="language">
  						<option value="1">English</option>
  						<option value="2">Italian</option>
  						<option value="3">Japanese</option>
  						<option value="4">Mandarin</option>
  						<option value="5">French</option>
  						<option value="6">German</option>
  						</select><br>
				
				<label for="filmRentalDuration">Rental Duration:</label> 
				<input type="number" name="rentalDuration"><br>
		
				<label for="filmRentalRate">Rental Rate:</label> 
				<input type="number" name="rentalRate"><br>
				
				<label for="filmLength">Length:</label> 
				<input type="number" name="length"><br>
				
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
					<input type="text" name="specialFeatures"><br>
				
				<input type="submit">
				
			</form>
		</div>
	</div>

	<!-- <h1></h1>
	<form action="createFilmForm.do">
    <input type="submit" value="Go back to create another film" />
</form>
	<form action="home.do">
    <input type="submit" value="Go Home" />
</form> -->


</body>
</html>