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


@WebServlet("/getFilmAttribute")
public class getFilmAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//initializes the dao
		FilmDAO dao = new FilmDAO();
		//sends the value of attribute to the database e.g filmName, filmId
		String attributeToSearch = request.getParameter("attributeToSearch");
		//sends the new value to update
		String informationEntered = request.getParameter("informationEntered");
		System.out.println("attributeToSearch"+ attributeToSearch );
		//puts the data retrieved from the database in an array list
		ArrayList<Film> allFilms = dao.getFilmAttribute(attributeToSearch,informationEntered);
		//lets other files have access of the film object using getAttribute
		request.setAttribute("getSearchedAttributeFilm", allFilms);
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