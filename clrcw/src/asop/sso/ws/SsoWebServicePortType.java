/**
 * SsoWebServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package asop.sso.ws;

public interface SsoWebServicePortType extends java.rmi.Remote {
    public java.lang.String registerMapUser(java.lang.String ssoUser, java.lang.String appName, java.lang.String appUser) throws java.rmi.RemoteException;
    public asop.sso.ws.xsd.UserInfo login(java.lang.String userName, java.lang.String password, java.lang.String appName) throws java.rmi.RemoteException;
    public java.lang.Integer deleteMapUser(java.lang.String appName, java.lang.String appUser) throws java.rmi.RemoteException;
    public java.lang.Boolean logout(java.lang.String token, java.lang.String appName) throws java.rmi.RemoteException;
    public asop.sso.ws.xsd.UserInfo loginByToken(java.lang.String token, java.lang.String appName) throws java.rmi.RemoteException;
}
