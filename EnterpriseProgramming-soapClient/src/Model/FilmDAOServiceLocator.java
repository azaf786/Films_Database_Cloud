/**
 * FilmDAOServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Model;

public class FilmDAOServiceLocator extends org.apache.axis.client.Service implements Model.FilmDAOService {

    public FilmDAOServiceLocator() {
    }


    public FilmDAOServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FilmDAOServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FilmDAO
    private java.lang.String FilmDAO_address = "http://localhost:8080/EnterpriseProgramming-soap/services/FilmDAO";

    public java.lang.String getFilmDAOAddress() {
        return FilmDAO_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FilmDAOWSDDServiceName = "FilmDAO";

    public java.lang.String getFilmDAOWSDDServiceName() {
        return FilmDAOWSDDServiceName;
    }

    public void setFilmDAOWSDDServiceName(java.lang.String name) {
        FilmDAOWSDDServiceName = name;
    }

    public Model.FilmDAO getFilmDAO() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FilmDAO_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFilmDAO(endpoint);
    }

    public Model.FilmDAO getFilmDAO(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            Model.FilmDAOSoapBindingStub _stub = new Model.FilmDAOSoapBindingStub(portAddress, this);
            _stub.setPortName(getFilmDAOWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFilmDAOEndpointAddress(java.lang.String address) {
        FilmDAO_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (Model.FilmDAO.class.isAssignableFrom(serviceEndpointInterface)) {
                Model.FilmDAOSoapBindingStub _stub = new Model.FilmDAOSoapBindingStub(new java.net.URL(FilmDAO_address), this);
                _stub.setPortName(getFilmDAOWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FilmDAO".equals(inputPortName)) {
            return getFilmDAO();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://Model", "FilmDAOService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://Model", "FilmDAO"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FilmDAO".equals(portName)) {
            setFilmDAOEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
