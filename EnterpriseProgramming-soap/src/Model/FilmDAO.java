package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import Model.Film;

public class FilmDAO {

	Film film = null;
	Connection connection = null;
	Statement statement = null;
	String username = "zafara";
	String password = "Querkwon7";
	String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/" + username;

	public FilmDAO() {
		
		// film DAO
	}

	private void openConnection() {
		
		try {
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
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public String getAllFilms(){
		   
		ArrayList<Film> filmsList = new ArrayList<>();
		openConnection();
		
	    // Create select statement and execute it
		try{
		    String selectAllFilms = "select * from films";
		    ResultSet rs = statement.executeQuery(selectAllFilms);
			System.out.println("selectFilmNames Query - Status = Successful\n");
			while (rs.next()) {
				film = getFilm(rs);
				filmsList.add(film);
			}
			statement.close();
		    closeConnection();
		    
		} catch(SQLException se) { System.out.println(se); }
		
		Film[] list  = filmsList.toArray(new Film[filmsList.size()]);
	   return Arrays.toString(list);
   }

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
	
	public Film getFilmByName(String filmName) {
		openConnection();
		film = null;
		try {
			String selectFilmByName = "SELECT * FROM films WHERE filmName = '" +filmName+ "';";
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
	
	public Film getFilmById(int filmId) {
		openConnection();
		film = null;
		try {
			String selectFilmByName = "SELECT * FROM films WHERE filmId = '" +filmId+ "';";
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
	
	public boolean insertFilm(Film in) {
		openConnection();
		try {
				String insertFilm = "INSERT INTO films VALUES (" + 0 + ", '" + in.getFilmName() + "', "+in.getFilmYear()+" ,'"+in.getFilmCredits()+"', '"+in.getFilmDuration()+"', '"+in.getFilmReview()+"')";
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
	
	public boolean deleteFilm(int filmId) {
		openConnection();
		try {
				String deleteFilm = "DELETE FROM films WHERE filmId = '" + filmId +"';";
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
	
	public boolean updateFilm(Film film) {
		openConnection();
		try {
				String updateFilm = "UPDATE films SET filmName = '" +film.getFilmName()+"' , filmYear = "+film.getFilmYear()+" , filmCredits = '" +film.getFilmCredits()+"' , filmDuration = '"+film.getFilmDuration()+"', filmReview = '"+film.getFilmReview()+"'  WHERE filmId = '" + film.getFilmID() +"';";
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
