package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Film;
import Model.FilmDAO;
import Utils.Util;

//url pattern
@WebServlet("/getAllFilms")
public class getAllFilms extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//initializes the dao
		FilmDAO dao = new FilmDAO();
		//puts the data retrieved from the database in an array list
		ArrayList<Film> films = dao.getAllFilms();
		//this ensures that data is retrived from the database; also prevents the null pointer exception
		System.out.println("FILMS: " + films);
		//lets other files have access of all films using getAttribute
		request.setAttribute("films", films);
		String type = request.getParameter("type");
		String outputPage = Util.formatType(response, type);
		
		RequestDispatcher rd = request.getRequestDispatcher(outputPage);
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
