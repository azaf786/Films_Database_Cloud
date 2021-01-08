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

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//intialised dao
		FilmDAO dao = new FilmDAO();
		//retreives and stores parameter values from the url
		int filmId = Integer.parseInt(request.getParameter("filmId"));
		String filmName = request.getParameter("filmName");
		int filmYear = Integer.parseInt(request.getParameter("filmYear"));
		String filmCredits = request.getParameter("filmCredits");
		String filmDuration = request.getParameter("filmDuration");
		String filmReview = request.getParameter("filmReview");
		//retrieved parameter values are used in this function which updates the film record
		Film in = new Film(filmId ,filmName ,filmYear ,filmCredits , filmDuration, filmReview);
		//runs the update query in dao by putting the values stored in local parameters
		dao.updateFilm(in);
		//prints the updated film. Also, helps with debugging
		System.out.println("Film Updated: " + in + "\n" );
		Film updatedFilm = dao.getFilmByName(in.getFilmName());
		//lets other files have access of the film object using getAttribute
		request.setAttribute("updateFilm", updatedFilm);
		System.out.println("Film Updated by Name: " + updatedFilm );
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
