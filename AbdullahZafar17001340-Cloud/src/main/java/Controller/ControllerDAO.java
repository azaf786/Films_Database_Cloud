package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import Model.Film;
import Model.FilmDAO;

public class ControllerDAO {

	public static void main(String[] args) throws SQLException {
		
		//RETRIEVE ALL FILMS
		FilmDAO dao = new FilmDAO();
		ArrayList<Film> allFilms = dao.getAllFilms();
		System.out.println("Text: " + allFilms + "\n");
		Gson gson = new Gson();
		String allFilmsJSON = gson.toJson(allFilms);
		System.out.println("\nJSON: " + allFilmsJSON + "\n");
		
		//SEARCH FILM BY Name
		String search = "Bang Bang";
		Film oneFilm = dao.getFilmByName(search);
		System.out.println("Film by Name: " + oneFilm);
		
		//SEARCH FILM BY Id
		int id = 1;
		Film searchFilm = dao.getFilmById(id);
		System.out.println("Film by Id: " + searchFilm);

		//INSERT
		Film in = new Film(0, "Dabangg 3", 2019, "Salman Khan", "249mins", "comedy movie. Exceeded the expectations.");
		dao.insertFilm(in);
		System.out.println("Film Inserted: " + in );
		
		//DELETE 
		int filmId = 6;
		dao.deleteFilm(filmId);
		System.out.println("Film Deleted, Film ID: " + filmId);
		
		//UPDATE
		Film update = new Film(4, "Dabangg 4", 2019, "Salman Khan", "249mins", "comedy movie. Exceeded the expectations.");
		dao.updateFilm(update);
		System.out.println("Film Updated: " + update + "\n");
	}

}
