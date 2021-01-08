/**
 * FilmDAO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Model;

public interface FilmDAO extends java.rmi.Remote {
    public boolean updateFilm(Model.Film film) throws java.rmi.RemoteException;
    public boolean insertFilm(Model.Film in) throws java.rmi.RemoteException;
    public Model.Film getFilmByName(java.lang.String filmName) throws java.rmi.RemoteException;
    public Model.Film getFilmById(int filmId) throws java.rmi.RemoteException;
    public boolean deleteFilm(int filmId) throws java.rmi.RemoteException;
    public java.lang.String getAllFilms() throws java.rmi.RemoteException;
}
