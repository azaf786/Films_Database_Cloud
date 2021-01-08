package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Film;

public class FilmDAO {

	Film film = null;
	String instanceConnectionName = "cloud-enterpriseprogramming:europe-west6:enterpriseprorgramming17001340";
	String databaseName = "filmsdb";
	String IP_of_instance = "34.65.12.243:6306";
	String username = "enterpriseprogramming17001340";
	String password = "Manchester1";
	String url = "jdbc:mysql://34.65.12.243/filmsdb?characterEncoding=latin1&useconfigs=maxperformance";

	Connection connection = null;
	Statement statement = null;
	public FilmDAO() {
		
		// film DAO
	}

	
	//connections used to connect to the database
	private void openConnection() 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
		} catch (SQLException se) {
			System.out.println(se);
		}
	}

	private void closeConnection() {
		
		try 
		{
			connection.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	
	//gets all the films from the database
	public ArrayList<Film> getAllFilms() 
	{
		System.out.println("\nRetrieving all Films ...\n");
		ArrayList<Film> filmsList = new ArrayList<>();
		openConnection();
		String selectFilmNames = "SELECT * FROM Films";
		try {
			ResultSet rs = statement.executeQuery(selectFilmNames);
			System.out.println("selectFilmNames Query - Status = Successful\n");
			while (rs.next()) {
				film = getFilm(rs);
				filmsList.add(film);
			}
			statement.close();
			closeConnection();
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("selectFilmNames Query - Status = Failed");
		}
		return filmsList;
	}

	//used to hold incoming data
	private Film getFilm(ResultSet rs) {
		
		Film filmRs = null;
		try {
			filmRs = new Film(rs.getInt("filmId"), rs.getString("filmName"), rs.getInt("filmYear"),
					rs.getString("filmCredits"), rs.getString("filmDuration"), rs.getString("filmReview"));

		} catch (SQLException se) {
			se.printStackTrace();
			se.getMessage();
			System.out.println("Error occurred. Please check: getFilm.");
		}
		return filmRs;
		
	}
	
	//get film using film name 
	public Film getFilmByName(String filmName) {
		openConnection();
		film = null;
		try {
			String selectFilmByName = "SELECT * FROM Films WHERE filmName = '" +filmName+ "';";
			ResultSet rs = statement.executeQuery(selectFilmByName);
			System.out.println("SelectFilmByName Query - Status = Successful\n");
			while (rs.next()) {
				film = getFilm(rs);
			}
			statement.close();
			closeConnection();
		}
		catch(SQLException se) {
			se.printStackTrace();
			System.out.println("SelectFilmByName Query - Status = Failed\n");
		}
		return film;
	}
	
	//gets film using film id on its own
	public Film getFilmById(int filmId) {
		openConnection();
		film = null;
		String selectFilmByName = "SELECT * FROM Films WHERE filmId = '" +filmId+ "';";
		try {
			ResultSet rs = statement.executeQuery(selectFilmByName);
			System.out.println("getFilmById Query - Status = Successful\n");
			while (rs.next()) {
				film = getFilm(rs);
			}
			statement.close();
			closeConnection();
		}
		catch(SQLException se) {
			se.printStackTrace();
			System.out.println("getFilmById Query - Status = Failed\n");
		}
		return film;
	}
	
	// gets film using any attribute, returns the films list
	public ArrayList<Film> getFilmAttribute(String type, String value) {	
		System.out.println("Getting Film By Name ...\n");
		ArrayList<Film> filmsList = new ArrayList<>();
		openConnection();
		String getFilmAttribute = "SELECT * FROM Films where " + type + " LIKE '" + "%" + value + "%" + "' ;"; 
		try {
			System.out.println(getFilmAttribute);
			ResultSet rs = statement.executeQuery(getFilmAttribute);
			System.out.println("getFilmAttribute Query - Status = Successful\n");
			while (rs.next()) {
				film = getFilm(rs);
				filmsList.add(film);
			}
			statement.close();
			closeConnection();
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("getFilmAttribute Query - Status = Failed");
		}
		return filmsList;
		
	}
	
	//Insert Film, returns true or false
	public boolean insertFilm(Film in) {
		openConnection();
		try {
				String insertFilm = "INSERT INTO Films (filmId,filmName,filmYear,filmCredits,filmDuration,filmReview) VALUES ( 0, '" + in.getFilmName() + "', "+in.getFilmYear()+" ,'"+in.getFilmCredits()+"', '"+in.getFilmDuration()+"', '"+in.getFilmReview()+"')";
				statement.executeUpdate(insertFilm);
				System.out.println("\ninsertFilm Query - Status = Successful\n");
				return true;
		}
		catch(SQLException se) {
			se.printStackTrace();
			System.out.println("\ninsertFilm Query - Status = Failed\n");
		}
		return false;
		
	}
	
	//delete film, returns true or false
	public boolean deleteFilm(int filmId) {
		openConnection();
		try {
				String deleteFilm = "DELETE FROM Films WHERE filmId = '" + filmId +"';";
				statement.executeUpdate(deleteFilm);
				System.out.println("\ndeleteFilm Query - Status = Successful\n");
				return true;
		}
		catch(SQLException se) {
			se.printStackTrace();
			System.out.println("\ndeleteFilm Query - Status = Failed\n");
		}
		return false;
		
	}
	
	//update film, returns true or false
	public boolean updateFilm(Film film) {
		openConnection();
		try {
			String updateFilm = "UPDATE Films SET " + "" 
					+ "filmName = '" +film.getFilmName() +"', " 
					+ "filmYear = "+film.getFilmYear()+ ", "
					+ "filmCredits = '" +film.getFilmCredits() +"', "
					+"filmDuration = "+film.getFilmDuration()+", "
					+ "filmReview = '"+film.getFilmReview()
					+"' WHERE filmId = "+film.getFilmID();
			
			statement.executeUpdate(updateFilm);
				System.out.println("\nupdateFilm Query - Status = Successful\n");
				return true;
		}
		catch(SQLException se) {
			se.printStackTrace();
			System.out.println("updateFilm Query - Status = Failed\n");
		}
		return false;
		
	}



}
