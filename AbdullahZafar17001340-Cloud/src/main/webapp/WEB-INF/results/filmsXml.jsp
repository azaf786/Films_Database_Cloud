<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.xml.bind.JAXBContext"%>
<%@ page import="javax.xml.bind.JAXBException"%>
<%@ page import="javax.xml.bind.Marshaller"%>
<%@ page import="Model.Film"%>
<%@ page import="Model.FilmList"%>
<%@ page import="java.util.ArrayList"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%
if(request.getAttribute("films") != null){
	FilmList films = new FilmList((List<Film>) request.getAttribute("films"));
	try {
		JAXBContext jaxbContext = JAXBContext.newInstance(FilmList.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(films, out);
	} catch (JAXBException je) {
		je.printStackTrace();
	}
}
else if(request.getAttribute("getSearchedAttributeFilm") != null){
	FilmList getSearchedAttributeFilm = new FilmList((List<Film>) request.getAttribute("getSearchedAttributeFilm"));
	try {
		JAXBContext jaxbContext = JAXBContext.newInstance(FilmList.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(getSearchedAttributeFilm, out);
	} catch (JAXBException je) {
		je.printStackTrace();
	}
}
else if(request.getAttribute("deleteFilm") != null){
	FilmList deleteFilm = new FilmList((List<Film>) request.getAttribute("deleteFilm"));
	try {
		JAXBContext jaxbContext = JAXBContext.newInstance(FilmList.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(deleteFilm, out);
	} catch (JAXBException je) {
		je.printStackTrace();
	}
}

else if(request.getAttribute("insertFilm") != null){
	Film insertFilm = (Film)(request.getAttribute("insertFilm"));
	try {
		JAXBContext jaxbContext = JAXBContext.newInstance(FilmList.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(insertFilm, out);
	} catch (JAXBException je) {
		je.printStackTrace();
	}
}

else if(request.getAttribute("updateFilm") != null){
	Film updateFilm = (Film)(request.getAttribute("updateFilm"));
	try {
		JAXBContext jaxbContext = JAXBContext.newInstance(FilmList.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(updateFilm, out);
	} catch (JAXBException je) {
		je.printStackTrace();
	}
}


else
{
	FilmList films = new FilmList((List<Film>) request.getAttribute("getFilm"));
	try {
		JAXBContext jaxbContext = JAXBContext.newInstance(FilmList.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(films, out);
	} catch (JAXBException je) {
		je.printStackTrace();
	}
}

%>