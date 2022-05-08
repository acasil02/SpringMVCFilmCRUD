package com.skilldistillery.film.dao;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	  public Film findFilmById(int filmId);
	  public Actor findActorById(int actorId);
	  public List<Actor> findActorsByFilmId(int filmId);
	  public List<Film> searchFilm(String searchTerm);
	  public List<Category> findCategoriesByFilmId(int filmId);
	  public Film createFilm(Film film);
	  public boolean deleteFilm(Film film);
	  public Film updateFilm(Film film);
	  
}