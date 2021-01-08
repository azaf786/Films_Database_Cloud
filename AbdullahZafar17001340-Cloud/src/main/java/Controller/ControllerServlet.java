package Controller;

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
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		FilmDAO dao = new FilmDAO();
		//puts the data retrieved from the database in an array
		ArrayList<Film> films = dao.getAllFilms();
		//to ensure all films are received from the database also prevents the null pointer exception
		System.out.println("FILMS: " + films); 
		//lets other files have access of the film object using getAttribute
		request.setAttribute("films", films); 
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
