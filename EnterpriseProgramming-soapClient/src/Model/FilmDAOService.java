/**
 * FilmDAOService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Model;

public interface FilmDAOService extends javax.xml.rpc.Service {
    public java.lang.String getFilmDAOAddress();

    public Model.FilmDAO getFilmDAO() throws javax.xml.rpc.ServiceException;

    public Model.FilmDAO getFilmDAO(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
