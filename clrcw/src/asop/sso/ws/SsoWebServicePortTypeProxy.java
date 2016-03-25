package asop.sso.ws;

public class SsoWebServicePortTypeProxy implements asop.sso.ws.SsoWebServicePortType {
  private String _endpoint = null;
  private asop.sso.ws.SsoWebServicePortType ssoWebServicePortType = null;
  
  public SsoWebServicePortTypeProxy() {
    _initSsoWebServicePortTypeProxy();
  }
  
  public SsoWebServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initSsoWebServicePortTypeProxy();
  }
  
  private void _initSsoWebServicePortTypeProxy() {
    try {
      ssoWebServicePortType = (new asop.sso.ws.SsoWebServiceLocator()).getSsoWebServiceSOAP11port_http();
      if (ssoWebServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)ssoWebServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)ssoWebServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (ssoWebServicePortType != null)
      ((javax.xml.rpc.Stub)ssoWebServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public asop.sso.ws.SsoWebServicePortType getSsoWebServicePortType() {
    if (ssoWebServicePortType == null)
      _initSsoWebServicePortTypeProxy();
    return ssoWebServicePortType;
  }
  
  public java.lang.String registerMapUser(java.lang.String ssoUser, java.lang.String appName, java.lang.String appUser) throws java.rmi.RemoteException{
    if (ssoWebServicePortType == null)
      _initSsoWebServicePortTypeProxy();
    return ssoWebServicePortType.registerMapUser(ssoUser, appName, appUser);
  }
  
  public asop.sso.ws.xsd.UserInfo login(java.lang.String userName, java.lang.String password, java.lang.String appName) throws java.rmi.RemoteException{
    if (ssoWebServicePortType == null)
      _initSsoWebServicePortTypeProxy();
    return ssoWebServicePortType.login(userName, password, appName);
  }
  
  public java.lang.Integer deleteMapUser(java.lang.String appName, java.lang.String appUser) throws java.rmi.RemoteException{
    if (ssoWebServicePortType == null)
      _initSsoWebServicePortTypeProxy();
    return ssoWebServicePortType.deleteMapUser(appName, appUser);
  }
  
  public java.lang.Boolean logout(java.lang.String token, java.lang.String appName) throws java.rmi.RemoteException{
    if (ssoWebServicePortType == null)
      _initSsoWebServicePortTypeProxy();
    return ssoWebServicePortType.logout(token, appName);
  }
  
  public asop.sso.ws.xsd.UserInfo loginByToken(java.lang.String token, java.lang.String appName) throws java.rmi.RemoteException{
    if (ssoWebServicePortType == null)
      _initSsoWebServicePortTypeProxy();
    return ssoWebServicePortType.loginByToken(token, appName);
  }
  
  
}