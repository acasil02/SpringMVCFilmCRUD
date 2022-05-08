package com.skilldistillery.film.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;

public class FilmDAOJdbcImpl implements FilmDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String USER = "student";
	private static final String PWD = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
@Override
	public List<Film> searchFilm(String searchTerm) {
		List<Film> films = new ArrayList<>();
		try {
			Film film = null;

			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration, ";
			sql += " rental_rate, length, replacement_cost, rating, special_features, language.name "
					+ " FROM film JOIN language ON film.language_id = language.id WHERE title LIKE ? or description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + searchTerm + "%");
			stmt.setString(2, "%" + searchTerm + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int filmId = rs.getInt("film.id");
				film = new Film(rs.getInt("film.id"), rs.getString("film.title"), rs.getString("film.description"),
						rs.getInt("film.release_year"), rs.getString("language.name"), rs.getString("rental_duration"),
						rs.getDouble("film.rental_rate"), rs.getString("film.length"),
						rs.getDouble("film.replacement_cost"), rs.getString("film.rating"),
						rs.getString("film.special_features"), findActorsByFilmId(filmId),
						findCategoriesByFilmId(filmId));
				films.add(film);
			}
			return films;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public Film findFilmById(int filmId) {
		String sql = "SELECT film.id, film.title, film.description, film.release_year, language.name, film.rental_duration, film.rental_rate, film.length, film.replacement_cost, film.rating, film.special_features FROM film JOIN language ON language.id = film.language_id WHERE film.id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
				PreparedStatement ps = conn.prepareStatement(sql);)

		{
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Film film = new Film(rs.getInt("film.id"), rs.getString("film.title"), rs.getString("film.description"),
						rs.getInt("film.release_year"), rs.getString("language.name"), rs.getString("rental_duration"),
						rs.getDouble("film.rental_rate"), rs.getString("film.length"),
						rs.getDouble("film.replacement_cost"), rs.getString("film.rating"),
						rs.getString("film.special_features"), findActorsByFilmId(filmId),
						findCategoriesByFilmId(filmId));
				return film;
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println("The application has encountered a SQL Exception.");
			e.printStackTrace();
		}

		return null;
	}

	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actorList = new ArrayList<>();

		String sql = "SELECT actor.id, actor.first_name, actor.last_name FROM actor JOIN film_actor ON film_actor.actor_id = actor.id JOIN film ON film.id = film_actor.film_id WHERE film.id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
				PreparedStatement ps = conn.prepareStatement(sql);)

		{
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();
			actorList = new ArrayList<>();
			while (rs.next()) {
				Actor actor = new Actor(rs.getInt("actor.id"), rs.getString("actor.first_name"),
						rs.getString("actor.last_name"));
				actorList.add(actor);
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println("The application has encountered a SQL Exception.");
			e.printStackTrace();
		}
		return actorList;
	}

	public List<Category> findCategoriesByFilmId(int filmId) {
		List<Category> categoryList = new ArrayList<>();

		String sql = "SELECT film.id, category.name FROM category JOIN film_category ON film_category.category_id = category.id JOIN film ON film.id = film_category.film_id WHERE film.id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
				PreparedStatement ps = conn.prepareStatement(sql);)

		{
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();
			categoryList = new ArrayList<>();
			while (rs.next()) {
				Category category = new Category(rs.getInt("film.id"), rs.getString("category.name"));
				categoryList.add(category);
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println("The application has encountered a SQL Exception.");
			e.printStackTrace();
		}
		return categoryList;
	}

	public Actor findActorById(int actorId) {

		String sql = "SELECT actor.id, actor.first_name, actor.last_name FROM actor WHERE actor.id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
				PreparedStatement ps = conn.prepareStatement(sql);)

		{
			ps.setInt(1, actorId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Actor actor = new Actor(rs.getInt("actor.id"), rs.getString("actor.first_name"),
						rs.getString("actor.last_name"));
				return actor;
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println("The application has encountered a SQL Exception.");
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public Film createFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			conn.setAutoCommit(false);
			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features) VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setString(4, film.getLanguage());
			stmt.setString(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setString(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecitalFeatures());
			int updateCount = stmt.executeUpdate();

			try {
				int cf = stmt.executeUpdate();
				conn.commit();
				System.out.println(cf + "Film Added");
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					System.out.println("New ID " + keys.getInt(1));
				}

			} catch (SQLException e) {
				System.out.println("ERROR CREATING FILM");
			}

			stmt.close();
			conn.close();

		} catch (

		SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error encountered");
				}
			}
		}

		return film;
	}

	@Override
	public boolean deleteFilm(Film film) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			conn.setAutoCommit(false);
			String sql = "DELETE FROM film WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				Film test = null;
				test = findFilmById(film.getId());
				conn.commit();
				return true;
			} else {
				conn.rollback();
				return false;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error encountered");
				}
			}

			return false;
		}
	}

	@Override
	public Film updateFilm(Film film) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			conn.setAutoCommit(false);

			String sql = "UPDATE film SET title=?, description=?, release_year=?, language_id=?, rental_duration=?, rental_rate=?, length=?, replacement_cost=?, rating=?, special_features=? WHERE film.id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setString(4, film.getLanguage());
			stmt.setString(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setString(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecitalFeatures());

			int updateCount = stmt.executeUpdate();

			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int updatedFilmId = keys.getInt(1);
				}

				keys.close();

			} else {
				film = null;

			}

			conn.commit();
			stmt.close();
			conn.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error encountered");
				}
			}
		}

		return film;
	}
}