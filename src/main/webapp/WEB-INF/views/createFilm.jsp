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
				<label for="filmTitle">Film Title:</label> <input type="text"
					name="title" required><br> <label
					for="filmDescription">Description:</label> <input type="text"
					name="description" required><br> <label
					for="filmReleaseYear">Release Year:</label> <input type="text"
					name="releaseYear" required><br> <label
					for="filmlanguage">Language:</label> <select name="language"
					required>
					<option value="1">English</option>
					<option value="2">Italian</option>
					<option value="3">Japanese</option>
					<option value="4">Mandarin</option>
					<option value="5">French</option>
					<option value="6">German</option>
				</select><br> <label for="filmRentalDuration">Rental Duration:</label> <input
					type="number" name="rentalDuration" required><br> <label
					for="filmRentalRate">Rental Rate:</label> <input type="number"
					name="rentalRate" required><br> <label
					for="filmLength">Length:</label> <input type="number" name="length"
					required><br> <label for="filmReplacementCost">Replacement
					Cost:</label> <input type="text" name="replacementCost" required><br>

				<label for="filmRating">Rating:</label> <select name="rating"
					required><br>
					<option value="G">G</option>
					<option value="PG">PG</option>
					<option value="PG13">PG13</option>
					<option value="R">R</option>
					<option value="NC17">NC17</option>
				</select><br> <label for="filmSpecitalFeatures">Special
					Features:</label> <input type="text" name="specialFeatures"><br>

				<input type="submit" value="Submit" />

			</form>
		</div>
	</div>




</body>
</html>
