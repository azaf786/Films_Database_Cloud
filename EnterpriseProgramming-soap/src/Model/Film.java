package Model;

import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "filmList")
@XmlAccessorType (XmlAccessType.FIELD)
public class Film 
{
	@XmlElement(name = "film") 
	private int 	filmID;
	private String 	filmName;
	private int 	filmYear;
	private String 	filmCredits;
	private String  filmDuration;
	private String  filmReview;
	
	public Film(int filmID, String filmName, int filmYear, String filmCredits, String filmDuration, String filmReview) {
		super();
		this.filmID = filmID;
		this.filmName = filmName;
		this.filmYear = filmYear;
		this.filmCredits = filmCredits;
		this.filmDuration = filmDuration;
		this.filmReview = filmReview;
	}
	
	public Film()
	{
		
	}

	public int getFilmID() {
		return filmID;
	}

	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public int getFilmYear() {
		return filmYear;
	}

	public void setFilmYear(int filmYear) {
		this.filmYear = filmYear;
	}

	public String getFilmCredits() {
		return filmCredits;
	}

	public void setFilmCredits(String filmCredits) {
		this.filmCredits = filmCredits;
	}

	public String getFilmDuration() {
		return filmDuration;
	}

	public void setFilmDuration(String filmDuration) {
		this.filmDuration = filmDuration;
	}

	public String getFilmReview() {
		return filmReview;
	}

	public void setFilmReview(String filmReview) {
		this.filmReview = filmReview;
	}

	@Override
	public String toString() {
		return "Film [Film Id=" + filmID + ", Film Name=" + filmName + ", Film Year=" + filmYear + ", Film Credits="
				+ filmCredits + ", Film Duration=" + filmDuration + ", Film ÍReview=" + filmReview + "]";
	}

}