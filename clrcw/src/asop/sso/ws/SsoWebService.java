/**
 * SsoWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package asop.sso.ws;

public interface SsoWebService extends javax.xml.rpc.Service {
    public java.lang.String getSsoWebServiceSOAP11port_httpAddress();

    public asop.sso.ws.SsoWebServicePortType getSsoWebServiceSOAP11port_http() throws javax.xml.rpc.ServiceException;

    public asop.sso.ws.SsoWebServicePortType getSsoWebServiceSOAP11port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getSsoWebServiceSOAP12port_httpAddress();

    public asop.sso.ws.SsoWebServicePortType getSsoWebServiceSOAP12port_http() throws javax.xml.rpc.ServiceException;

    public asop.sso.ws.SsoWebServicePortType getSsoWebServiceSOAP12port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
