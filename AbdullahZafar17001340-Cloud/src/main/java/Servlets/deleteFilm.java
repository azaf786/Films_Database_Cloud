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
@WebServlet("/deleteFilm")
public class deleteFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//http://localhost:8080/EnterpriseProgramming-BasicApplication/deleteFilm?filmId=9
		//initializes the dao
		FilmDAO dao = new FilmDAO();
		//film id is requested and stored in a local variable
		int deleteFilmId = Integer.parseInt(request.getParameter("filmId"));
		//puts the data retrieved from the database in an array
		ArrayList<Film> deleteFilm = new ArrayList<Film>();
		//shows the film on the front end that gets deleted
		deleteFilm.add(dao.getFilmById(deleteFilmId));
		//lets other files have access of the deleted film using getAttribute
		request.setAttribute("deleteFilm", deleteFilm);
		System.out.println("Film Deleted: " + deleteFilm);
		//deletes the film from the database
		dao.deleteFilm(deleteFilmId);
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
