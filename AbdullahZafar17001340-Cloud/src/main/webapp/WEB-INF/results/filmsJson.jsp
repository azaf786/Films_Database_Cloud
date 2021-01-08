<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="Model.Film"%>

<%
	Gson gson = new Gson();

	/* All films */
	if (request.getAttribute("films") != null) {
		List<Film> films = (List<Film>) request.getAttribute("films");
		String getAllFilmsJsonString = gson.toJson(films);
		response.getWriter().println(getAllFilmsJsonString);
	}

	/* Delete Film */
	else if (request.getAttribute("deleteFilm") != null) {

		List<Film> deleteFilm = (List<Film>) request.getAttribute("deleteFilm");
		String deleteFilmJsonString = gson.toJson(deleteFilm);
		response.getWriter().println(deleteFilmJsonString);
	}

	/* Insert Film */
	else if (request.getAttribute("insertFilm") != null) {
		Film insertFilm = (Film) (request.getAttribute("insertFilm"));
		String insertFilmJsonString = gson.toJson(insertFilm);
		response.getWriter().println(insertFilmJsonString);
	}

	/* Update Film */
	else if (request.getAttribute("updateFilm") != null) {
		Film updateFilm = (Film) (request.getAttribute("updateFilm"));
		String insertFilmJsonString = gson.toJson(updateFilm);
		response.getWriter().println(insertFilmJsonString);
	}

	/* Search Film*/
	else if (request.getAttribute("getFilm") != null) {
		List<Film> oneFilm = (List<Film>) request.getAttribute("getFilm");
		String getFilmJsonString = gson.toJson(oneFilm);
		response.getWriter().println(getFilmJsonString);
	}

	/* Search Film using any attribute */
	else if (request.getAttribute("getSearchedAttributeFilm") != null) {
		List<Film> oneFilmAttribute = (List<Film>) request.getAttribute("getSearchedAttributeFilm");
		String oneFilmAttributeJson = gson.toJson(oneFilmAttribute);
		response.getWriter().println(oneFilmAttributeJson);
	}
%>


