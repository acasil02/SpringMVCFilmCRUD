<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Film</title>
</head>
<body>

	<div class="creatFilmMasterDiv">
		<div class="createFilmFormDiv">
			<form action="CreateFilm.do" method="post">
				<label for="filmTitle">Film Title:</label> 
				<input type="text" name="title"><br>
			
				<label for="filmDescription">Film Description:</label> 
				<input type="text" name="description"><br>
			
				<label for="filmReleaseYear">Film Release Year:</label> 
				<input type="text" name="releaseYear"><br>
			
				<label for="filmlanguage">Film Language:</label> 
				<input type="text" name="language_id"><br>
				
				<label for="filmRentalDuration">Film Rental Duration:</label> 
				<input type="text" name="rentalDuration"><br>
		
				<label for="filmRentalRate">Film Rental Rate:</label> 
				<input type="text" name="rentalRate"><br>
				
				<label for="filmLength">Film Length:</label> 
				<input type="text" name="length"><br>
				
				<label for="filmReplacementCost">Film Replacement Cost:</label> 
				<input type="text" name="replacementCost"><br>
				
				<label for="filmRating">Film Rating:</label> 
				<input type="text" name="rating"><br>
				
				<label for="filmSpecitalFeatures">Film Special Features:</label> 
				<input type="text" name="specitalFeatures"><br>
				
				<label for="filmCast">Film Cast:</label> 
				<input type="text" name="cast"><br>
				
				<label for="filmCategories">Film Categories:</label> 
				<input type="text" name="categories"><br>

			</form>
		</div>
	</div>

	<h1></h1>


</body>
</html>