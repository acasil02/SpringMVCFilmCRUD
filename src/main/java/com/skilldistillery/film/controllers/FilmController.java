package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDao;

	@RequestMapping(path = { "/", "home.do" })
	public String home() {
		return "WEB-INF/views/home.jsp";
	}

	@RequestMapping(path = { "/", "createFilmForm.do" })
	public String createFilmForm() {
		return "WEB-INF/views/createFilm.jsp";
	}

	@RequestMapping(path = { "/", "getFilmFromId.do" })
	public String getFilmFromID() {
		return "WEB-INF/views/findByID.jsp";
	}

	@RequestMapping(path = { "/", "getFilmFromSearch.do" })
	public String getFilmFromSearch() {
		return "WEB-INF/views/findBySearch.jsp";
	}
	@RequestMapping(path = { "/", "beginTheUpdate.do" })
	public String updatButtonPath() {
		return "WEB-INF/views/UpdateFilm.jsp";
	}
	@RequestMapping(path = "CreateFilm.do", method = RequestMethod.POST)
	public ModelAndView createFilm(Film film, RedirectAttributes redi) {
		ModelAndView mv = new ModelAndView();
		Film createdFilm = filmDao.createFilm(film);
		redi.addFlashAttribute("Film", createdFilm);
		mv.setViewName("WEB-INF/views/filmCreated.jsp");

		return mv;
	}

	@RequestMapping(path = "findByID.do", method = RequestMethod.GET)
	public ModelAndView findFilmById(@RequestParam(defaultValue = "000") int filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.findFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/resultsFindbyInt.jsp");

		return mv;

	}
	@RequestMapping(path = "findByUpdateID.do", method = RequestMethod.GET)
	public ModelAndView findFilmByUpdateId(@RequestParam(defaultValue = "000") int filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.findFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/UpdateFilm.jsp");

		return mv;

	}

	@RequestMapping(path = "findBySearch.do", method = RequestMethod.GET)
	public ModelAndView searchFilm(String userInput) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDao.searchFilm(userInput);
		mv.addObject("films", films);
		mv.setViewName("WEB-INF/views/resultsFindbySearch.jsp");

		return mv;

	}

	@RequestMapping(path = "deleteFilm.do", params = "id", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView deleteFilm(Integer id, RedirectAttributes redir, HttpSession session) throws SQLException {
		ModelAndView mv = new ModelAndView();
		Film dbFilm = filmDao.findFilmById(id);
		if (dbFilm != null) {
			boolean isDeleted = filmDao.deleteFilm(dbFilm);
			redir.addFlashAttribute("isFilmDeleted", isDeleted);
			boolean confirmDeletion = true;
			redir.addFlashAttribute("confirmDeletion", confirmDeletion);

		}

//		mv.addObject(dbFilm);
		mv.setViewName("redirect:filmDeleted.do");
		return mv;
	}

	@RequestMapping(path = "filmDeleted.do", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView filmHasBeenDeleted() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/deleteFilm.jsp");
		return mv;

	}

	@RequestMapping(path = "updateFilmForm.do", params = "filmId", method = RequestMethod.GET)
	public ModelAndView updateFilmForm(HttpSession session, Integer filmId) {
		ModelAndView mv = new ModelAndView();
		Film current = filmDao.findFilmById(filmId);
		

		mv.addObject("film", current);
		mv.setViewName("filmUpdate");

		return mv;
	}

	@RequestMapping(path = "updateFilm.do", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView updateFilm(Integer id, String title, String description, int releaseYear, String language, String rentalDuration,
			double rentalRate, String length, double replacementCost, String rating, String specitalFeatures, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		Film createdFilm = new Film(id, title, description, releaseYear, language, rentalDuration, rentalRate, length, replacementCost, rating, specitalFeatures);
		createdFilm = filmDao.updateFilm(createdFilm);
		redir.addFlashAttribute("Film", createdFilm);


//		boolean isUpdated = film.getId() > 0 ? true : false;
//		redir.addFlashAttribute("isFilmUpdated", isUpdated);
//
//		boolean updateConfirm = true;
//		redir.addFlashAttribute("updateConfirm", updateConfirm);
		mv.addObject("film", createdFilm);
		mv.setViewName("WEB-INF/views/resultsFindbyInt.jsp");

		return mv;

	}

//	@RequestMapping(path = "filmUpdated.do", method = { RequestMethod.POST, RequestMethod.GET })
//	public ModelAndView filmUpdated(int id) {
//		ModelAndView mv = new ModelAndView();
//		Film current = filmDao.findFilmById(id);
//
//		mv.addObject("film", current);
//		mv.setViewName("delete");
//
//		return mv;
//	}

}
