package com.skilldistillery.film.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDao;

	@RequestMapping(path = {"/", "home.do"})
	public String home() {
		return "WEB-INF/views/home.jsp";
	}

	@RequestMapping(path = "CreateFilm.do", method = RequestMethod.POST)
	public ModelAndView createFilm(int id, String title, String description, int releaseYear, String language, String rentalDuration,
			double rentalRate, String length, double replacementCost, String rating, String specitalFeatures, List<Actor> cast, List<Category> categories, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.createFilm(new Film(id, title, description, releaseYear, language, rentalDuration, rentalRate, length, replacementCost, rating, specitalFeatures, cast, categories));
		mv.addObject("film", film);
		mv.setViewName("result");
		session.setAttribute("film", film);

		return mv;
	}
	
	
	
	
	
	
	
	
}
