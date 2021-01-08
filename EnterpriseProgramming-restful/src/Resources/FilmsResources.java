package Resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import Model.FilmDAO;
import Model.Film;

@Path("/films")
public class FilmsResources {
	
	FilmDAO dao = new FilmDAO();
	
	Film film;
	
	List<Film> films = new ArrayList<Film>();
	
	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	// Return the list of films to the user in the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Film> getTodosBrowser() {
		films.addAll(dao.getAllFilms());
		return films;
	}

	// Return the list of films for applications
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Film> getTodos() {
		films.addAll(dao.getAllFilms());
		return films;
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newTodo(@FormParam("filmId") int film_id, @FormParam("filmName") String title,
			@FormParam("filmYear") int year, @FormParam("filmDuration") String director,
			@FormParam("filmCredits") String stars, @FormParam("filmReview") String review,
			@Context HttpServletResponse servletResponse) throws IOException {

		Film film = new Film(film_id, title, year, director, stars, review);
		if (dao.insertFilm(film)) {
			servletResponse.sendRedirect("../index.html");
		}

	}

	// Defines that the next path parameter after films is treated as a parameter and passed to the TodoResources
	// Allows to type http://localhost:8080/com.democo.jersey.todo/rest/todos/1
	// 1 will be treated as parameter todo and passed to TodoResource
	@Path("{film}")
	public FilmResource getFilm(@PathParam("film") String id) {
		return new FilmResource(uriInfo, request, id);
	}

}
