package client;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

import model.Film;

public class Tester {

	public static void main(String[] args) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());

		// Update Film
		String updateFilmID = "53";

		Film film = new Film(Integer.parseInt(updateFilmID), "War", 2019, "Siddharth Anand", "2h23mins", "An Indian soldier is assigned to eliminate his former mentor and he must keep his wits about him if he is to be successful in his mission. When the two men collide, it results in a barrage of battles and bullets.");
		ClientResponse response = service.path("rest").path("films").path(Integer.toString(film.getFilmID())).accept(MediaType.APPLICATION_XML).put(ClientResponse.class, film);

		// Return code should be 201 == created resource
		System.out.println("Film with ID: " + updateFilmID + " has been updated, Code Status(" + response.getStatus() + ")");

		// Get all Films
		System.out.println("\nGet all Films: " + service.path("rest").path("films").accept(MediaType.TEXT_XML).get(String.class));

		// Get all Films JSON
		System.out.println("\nGet all Films; Format = JSON: "+ service.path("rest").path("films").accept(MediaType.APPLICATION_JSON).get(String.class));

		// Get all Films XML
		System.out.println("\nGet all Films; Format = XML: "+ service.path("rest").path("films").accept(MediaType.APPLICATION_XML).get(String.class));

		// Get Film with id

		System.out.println("\nGet Film by ID; Format XML: "+ service.path("rest").path("films/40").accept(MediaType.APPLICATION_XML).get(String.class));

		// Get Film with following ID and DELETE it
		String deleteFilmID = "30";
		service.path("rest").path("films/" + deleteFilmID).delete();
		System.out.println("\nFilm with the ID of: (" + deleteFilmID + " has been deleted): "+ service.path("rest").path("films").accept(MediaType.APPLICATION_XML).get(String.class));

		// Insert a Film
		Form form = new Form();
		String filmTitle = "Kesari";
		form.add("filmId", 0);
		form.add("filmName", filmTitle);
		form.add("filmYear", 2019);
		form.add("filmCredits", "Anurag Singh");
		form.add("filmDuration", "2h 40m");
		form.add("filmReview", "Based on an incredible true story of the Battle of Saragarhi in which an army of 21 Sikhs fought against 10,000 Afghans in 1897.");

		response = service.path("rest").path("films").type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, form);
		System.out.println("\nResponse: \n\n" + response.getEntity(String.class));

		//Get all Films, Film above should be created
		System.out.println("\nFilm Inserted; Film Name (" + filmTitle + "): "+ service.path("rest").path("films").accept(MediaType.APPLICATION_XML).get(String.class));

	}

	private static URI getBaseURI() {

		return UriBuilder.fromUri("http://localhost:8080/EnterpriseProgramming-restful").build();

	}

}
