/**
 * Apiv1Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.chartlyrics.api;

public class Apiv1Locator extends org.apache.axis.client.Service implements com.chartlyrics.api.Apiv1 {

/**
 * Chartlyrics API version 1.2
 */

    public Apiv1Locator() {
    }


    public Apiv1Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Apiv1Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for apiv1Soap
    private java.lang.String apiv1Soap_address = "http://api.chartlyrics.com/apiv1.asmx";

    public java.lang.String getapiv1SoapAddress() {
        return apiv1Soap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String apiv1SoapWSDDServiceName = "apiv1Soap";

    public java.lang.String getapiv1SoapWSDDServiceName() {
        return apiv1SoapWSDDServiceName;
    }

    public void setapiv1SoapWSDDServiceName(java.lang.String name) {
        apiv1SoapWSDDServiceName = name;
    }

    public com.chartlyrics.api.Apiv1Soap getapiv1Soap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(apiv1Soap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getapiv1Soap(endpoint);
    }

    public com.chartlyrics.api.Apiv1Soap getapiv1Soap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.chartlyrics.api.Apiv1SoapStub _stub = new com.chartlyrics.api.Apiv1SoapStub(portAddress, this);
            _stub.setPortName(getapiv1SoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setapiv1SoapEndpointAddress(java.lang.String address) {
        apiv1Soap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.chartlyrics.api.Apiv1Soap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.chartlyrics.api.Apiv1SoapStub _stub = new com.chartlyrics.api.Apiv1SoapStub(new java.net.URL(apiv1Soap_address), this);
                _stub.setPortName(getapiv1SoapWSDDServiceName());
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
        if ("apiv1Soap".equals(inputPortName)) {
            return getapiv1Soap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://api.chartlyrics.com/", "apiv1");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "apiv1Soap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("apiv1Soap".equals(portName)) {
            setapiv1SoapEndpointAddress(address);
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
