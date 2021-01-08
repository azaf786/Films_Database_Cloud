package Resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import Model.FilmDAO;
import Model.Film;

public class FilmResource {

	FilmDAO dao = new FilmDAO();

	Film film;

	@Context
	UriInfo uriInfo;

	@Context
	Request request;

	String id;

	public FilmResource(UriInfo uriInfo, Request request, String id) {

		this.uriInfo = uriInfo;

		this.request = request;

		this.id = id;

	}

	// Application integration
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Film getFilm() {

		film = dao.getFilmById(Integer.parseInt(id));

		if (film == null) {

			throw new RuntimeException("Get: Film with " + id + " not found in the Database.");

		} else {

			return film;

		}

	}

	// For the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public Film getFilmHTML() {

		film = dao.getFilmById(Integer.parseInt(id));

		if (film == null) {

			throw new RuntimeException("Get: Film with " + id + " not found in the Database.");

		} else {

			return film;

		}

	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putFilm(JAXBElement<Film> jsonFilm) {

		film = jsonFilm.getValue();

		return putAndGetResponse(film);

	}

	@DELETE
	public void deleteTodo() {

		boolean deleted = dao.deleteFilm(Integer.parseInt(id));

		if (deleted == false) {

			throw new RuntimeException("Delete: Todo with " + id + " not found");

		}

	}

	private Response putAndGetResponse(Film film) {

		Response response;

		if (dao.getFilmById(film.getFilmID()) == null) {

			response = Response.noContent().build();

		} else {

			response = Response.created(uriInfo.getAbsolutePath()).build();

		}

		System.out.print("Film Updated: " + film);

		dao.updateFilm(film);

		return response;

	}

}
