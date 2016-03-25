/**
 * SsoWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package asop.sso.ws;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SsoWebServiceLocator extends org.apache.axis.client.Service implements asop.sso.ws.SsoWebService {

    public SsoWebServiceLocator() {
    	//SsoWebServiceSOAP11port_http_address = "http://172.17.1.99:9191/asop-ua-ws/services/SsoWebService";
    	//SsoWebServiceSOAP12port_http_address = "http://172.17.1.99:9191/asop-ua-ws/services/SsoWebService";
    	//读取配置文件
    	Properties prop = new Properties(); 
    	InputStream in =
    	this.getClass().getResourceAsStream("/config/webservice.properties");
    	try {
    		prop.load(in);
    		StringBuffer buffer = new StringBuffer();
    		String param1 = prop.getProperty("web.service.http.address").trim();
    		String param2 = prop.getProperty("web.service.http.port").trim();
    		String param3 = prop.getProperty("web.service.url.name").trim();
    		prop.getProperty("web.service.url.name").trim();
        	buffer.append("http://");
        	buffer.append(param1+":");
        	buffer.append(param2);
        	buffer.append(param3);
        	SsoWebServiceSOAP11port_http_address = buffer.toString();
        	SsoWebServiceSOAP12port_http_address = buffer.toString();
    	} catch (IOException e) {
            e.printStackTrace();
        } 
    	
    	
    	
    }


    public SsoWebServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SsoWebServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }
    
    // Use to get a proxy class for SsoWebServiceSOAP11port_http
    private java.lang.String SsoWebServiceSOAP11port_http_address = null;

    public java.lang.String getSsoWebServiceSOAP11port_httpAddress() {
        return SsoWebServiceSOAP11port_http_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SsoWebServiceSOAP11port_httpWSDDServiceName = "SsoWebServiceSOAP11port_http";

    public java.lang.String getSsoWebServiceSOAP11port_httpWSDDServiceName() {
        return SsoWebServiceSOAP11port_httpWSDDServiceName;
    }

    public void setSsoWebServiceSOAP11port_httpWSDDServiceName(java.lang.String name) {
        SsoWebServiceSOAP11port_httpWSDDServiceName = name;
    }

    public asop.sso.ws.SsoWebServicePortType getSsoWebServiceSOAP11port_http() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SsoWebServiceSOAP11port_http_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSsoWebServiceSOAP11port_http(endpoint);
    }

    public asop.sso.ws.SsoWebServicePortType getSsoWebServiceSOAP11port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            asop.sso.ws.SsoWebServiceSOAP11BindingStub _stub = new asop.sso.ws.SsoWebServiceSOAP11BindingStub(portAddress, this);
            _stub.setPortName(getSsoWebServiceSOAP11port_httpWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSsoWebServiceSOAP11port_httpEndpointAddress(java.lang.String address) {
        SsoWebServiceSOAP11port_http_address = address;
    }


    // Use to get a proxy class for SsoWebServiceSOAP12port_http
    private java.lang.String SsoWebServiceSOAP12port_http_address = null;

    public java.lang.String getSsoWebServiceSOAP12port_httpAddress() {
        return SsoWebServiceSOAP12port_http_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SsoWebServiceSOAP12port_httpWSDDServiceName = "SsoWebServiceSOAP12port_http";

    public java.lang.String getSsoWebServiceSOAP12port_httpWSDDServiceName() {
        return SsoWebServiceSOAP12port_httpWSDDServiceName;
    }

    public void setSsoWebServiceSOAP12port_httpWSDDServiceName(java.lang.String name) {
        SsoWebServiceSOAP12port_httpWSDDServiceName = name;
    }

    public asop.sso.ws.SsoWebServicePortType getSsoWebServiceSOAP12port_http() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SsoWebServiceSOAP12port_http_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSsoWebServiceSOAP12port_http(endpoint);
    }

    public asop.sso.ws.SsoWebServicePortType getSsoWebServiceSOAP12port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            asop.sso.ws.SsoWebServiceSOAP12BindingStub _stub = new asop.sso.ws.SsoWebServiceSOAP12BindingStub(portAddress, this);
            _stub.setPortName(getSsoWebServiceSOAP12port_httpWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSsoWebServiceSOAP12port_httpEndpointAddress(java.lang.String address) {
        SsoWebServiceSOAP12port_http_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (asop.sso.ws.SsoWebServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                asop.sso.ws.SsoWebServiceSOAP11BindingStub _stub = new asop.sso.ws.SsoWebServiceSOAP11BindingStub(new java.net.URL(SsoWebServiceSOAP11port_http_address), this);
                _stub.setPortName(getSsoWebServiceSOAP11port_httpWSDDServiceName());
                return _stub;
            }
            if (asop.sso.ws.SsoWebServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                asop.sso.ws.SsoWebServiceSOAP12BindingStub _stub = new asop.sso.ws.SsoWebServiceSOAP12BindingStub(new java.net.URL(SsoWebServiceSOAP12port_http_address), this);
                _stub.setPortName(getSsoWebServiceSOAP12port_httpWSDDServiceName());
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
        if ("SsoWebServiceSOAP11port_http".equals(inputPortName)) {
            return getSsoWebServiceSOAP11port_http();
        }
        else if ("SsoWebServiceSOAP12port_http".equals(inputPortName)) {
            return getSsoWebServiceSOAP12port_http();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.sso.asop", "SsoWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.sso.asop", "SsoWebServiceSOAP11port_http"));
            ports.add(new javax.xml.namespace.QName("http://ws.sso.asop", "SsoWebServiceSOAP12port_http"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SsoWebServiceSOAP11port_http".equals(portName)) {
            setSsoWebServiceSOAP11port_httpEndpointAddress(address);
        }
        else 
if ("SsoWebServiceSOAP12port_http".equals(portName)) {
            setSsoWebServiceSOAP12port_httpEndpointAddress(address);
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
