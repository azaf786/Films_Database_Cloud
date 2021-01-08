package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Film;
import Model.FilmDAO;
import Utils.Util;


@WebServlet("/insertFilm")
public class insertFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//http://localhost:8080/EnterpriseProgramming-BasicApplication/insertFilm?filmId=0&filmName=FastAndFurious8&filmYear=2017&filmCredits=Dwayne%20Johnson&filmDuration=189mins&filmReview=Hollywood%20Blockbuster
		//initializes the dao
		FilmDAO dao = new FilmDAO();
		//gets and stores parameter values from the url
		String filmName = request.getParameter("filmName");
		int    filmYear = Integer.parseInt(request.getParameter("filmYear"));
		String filmCredits = request.getParameter("filmCredits");
		String filmDuration = request.getParameter("filmDuration");
		String filmReview = request.getParameter("filmReview");
		//stored parameter values are used in the function
		//film id is set as 0 as film id is auto increment in the database.
		Film in = new Film(0 ,filmName ,filmYear ,filmCredits , filmDuration, filmReview);
		dao.insertFilm(in);
		System.out.println("Film Inserted: " + in);
		
		Film insertedFilm = dao.getFilmByName(in.getFilmName());
		//lets other files have access of the film object using getAttribute
		request.setAttribute("insertFilm", insertedFilm);
		System.out.println("Film Inserted by Name: " + insertedFilm );
		String type = request.getParameter("type");
		//sends the response + type parameter to utils; utils sets the correct output page
		String outputPage = Util.formatType(response, type);
		//the client is redirected to the correct output page 
		RequestDispatcher rd = request.getRequestDispatcher(outputPage);
		rd.include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
