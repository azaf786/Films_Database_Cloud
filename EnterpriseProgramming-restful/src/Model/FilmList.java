package Model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "filmList")
@XmlAccessorType (XmlAccessType.FIELD)

public class FilmList {
	@XmlElement(name = "film")
	private List<Film> films;
	public FilmList(List<Film> filmsIn) {
		films = filmsIn;
	}

public FilmList() {
	
}

}
