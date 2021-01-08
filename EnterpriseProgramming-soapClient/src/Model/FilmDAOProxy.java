package Model;

public class FilmDAOProxy implements Model.FilmDAO {
  private String _endpoint = null;
  private Model.FilmDAO filmDAO = null;
  
  public FilmDAOProxy() {
    _initFilmDAOProxy();
  }
  
  public FilmDAOProxy(String endpoint) {
    _endpoint = endpoint;
    _initFilmDAOProxy();
  }
  
  private void _initFilmDAOProxy() {
    try {
      filmDAO = (new Model.FilmDAOServiceLocator()).getFilmDAO();
      if (filmDAO != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)filmDAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)filmDAO)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (filmDAO != null)
      ((javax.xml.rpc.Stub)filmDAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public Model.FilmDAO getFilmDAO() {
    if (filmDAO == null)
      _initFilmDAOProxy();
    return filmDAO;
  }
  
  public boolean updateFilm(Model.Film film) throws java.rmi.RemoteException{
    if (filmDAO == null)
      _initFilmDAOProxy();
    return filmDAO.updateFilm(film);
  }
  
  public boolean insertFilm(Model.Film in) throws java.rmi.RemoteException{
    if (filmDAO == null)
      _initFilmDAOProxy();
    return filmDAO.insertFilm(in);
  }
  
  public Model.Film getFilmByName(java.lang.String filmName) throws java.rmi.RemoteException{
    if (filmDAO == null)
      _initFilmDAOProxy();
    return filmDAO.getFilmByName(filmName);
  }
  
  public Model.Film getFilmById(int filmId) throws java.rmi.RemoteException{
    if (filmDAO == null)
      _initFilmDAOProxy();
    return filmDAO.getFilmById(filmId);
  }
  
  public boolean deleteFilm(int filmId) throws java.rmi.RemoteException{
    if (filmDAO == null)
      _initFilmDAOProxy();
    return filmDAO.deleteFilm(filmId);
  }
  
  public java.lang.String getAllFilms() throws java.rmi.RemoteException{
    if (filmDAO == null)
      _initFilmDAOProxy();
    return filmDAO.getAllFilms();
  }
  
  
}