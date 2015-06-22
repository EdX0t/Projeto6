package com.chartlyrics.api;

public class Apiv1SoapProxy implements com.chartlyrics.api.Apiv1Soap {
  private String _endpoint = null;
  private com.chartlyrics.api.Apiv1Soap apiv1Soap = null;
  
  public Apiv1SoapProxy() {
    _initApiv1SoapProxy();
  }
  
  public Apiv1SoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initApiv1SoapProxy();
  }
  
  private void _initApiv1SoapProxy() {
    try {
      apiv1Soap = (new com.chartlyrics.api.Apiv1Locator()).getapiv1Soap();
      if (apiv1Soap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)apiv1Soap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)apiv1Soap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (apiv1Soap != null)
      ((javax.xml.rpc.Stub)apiv1Soap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.chartlyrics.api.Apiv1Soap getApiv1Soap() {
    if (apiv1Soap == null)
      _initApiv1SoapProxy();
    return apiv1Soap;
  }
  
  public com.chartlyrics.api.SearchLyricResult[] searchLyric(java.lang.String artist, java.lang.String song) throws java.rmi.RemoteException{
    if (apiv1Soap == null)
      _initApiv1SoapProxy();
    return apiv1Soap.searchLyric(artist, song);
  }
  
  public com.chartlyrics.api.SearchLyricResult[] searchLyricText(java.lang.String lyricText) throws java.rmi.RemoteException{
    if (apiv1Soap == null)
      _initApiv1SoapProxy();
    return apiv1Soap.searchLyricText(lyricText);
  }
  
  public com.chartlyrics.api.GetLyricResult getLyric(int lyricId, java.lang.String lyricCheckSum) throws java.rmi.RemoteException{
    if (apiv1Soap == null)
      _initApiv1SoapProxy();
    return apiv1Soap.getLyric(lyricId, lyricCheckSum);
  }
  
  public java.lang.String addLyric(int trackId, java.lang.String trackCheckSum, java.lang.String lyric, java.lang.String email) throws java.rmi.RemoteException{
    if (apiv1Soap == null)
      _initApiv1SoapProxy();
    return apiv1Soap.addLyric(trackId, trackCheckSum, lyric, email);
  }
  
  public com.chartlyrics.api.GetLyricResult searchLyricDirect(java.lang.String artist, java.lang.String song) throws java.rmi.RemoteException{
    if (apiv1Soap == null)
      _initApiv1SoapProxy();
    return apiv1Soap.searchLyricDirect(artist, song);
  }
  
  
}