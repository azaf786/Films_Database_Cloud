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
@WebServlet("/getFilm")
public class getFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//search FILM BY Name
		
		//initialises the console
		FilmDAO dao = new FilmDAO();
	    //requests the filmname which is then used to find the correct film from the database
		String searchResult = request.getParameter("filmName");
		//puts the data retrieved from the database in an array
		ArrayList<Film> searchURL = new ArrayList<Film>();

		searchURL.add(dao.getFilmByName(searchResult));
		System.out.println("Film Name, Method: URL: " + searchURL);
		//lets other files have access of the  get film object using getAttribute
		request.setAttribute("getFilm", searchURL);
		//used to change the data format to json, xml or text by the help of type parameter
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
