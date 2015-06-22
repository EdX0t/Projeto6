/**
 * Apiv1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.chartlyrics.api;

public interface Apiv1 extends javax.xml.rpc.Service {

/**
 * Chartlyrics API version 1.2
 */
    public java.lang.String getapiv1SoapAddress();

    public com.chartlyrics.api.Apiv1Soap getapiv1Soap() throws javax.xml.rpc.ServiceException;

    public com.chartlyrics.api.Apiv1Soap getapiv1Soap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
