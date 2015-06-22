/**
 * Apiv1Soap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.chartlyrics.api;

public interface Apiv1Soap extends java.rmi.Remote {

    /**
     * Search for lyrics and return the lyricId and lyricChecksum
     * for the GetLyric function
     */
    public com.chartlyrics.api.SearchLyricResult[] searchLyric(java.lang.String artist, java.lang.String song) throws java.rmi.RemoteException;

    /**
     * Search for text in lyric and returns the lyricId and lyricChecksum
     * for the GetLyric function
     */
    public com.chartlyrics.api.SearchLyricResult[] searchLyricText(java.lang.String lyricText) throws java.rmi.RemoteException;

    /**
     * Return lyric with lyric text, correction URL, Lyric rankigs
     * and an URL to the album cover if applicable.
     */
    public com.chartlyrics.api.GetLyricResult getLyric(int lyricId, java.lang.String lyricCheckSum) throws java.rmi.RemoteException;

    /**
     * Add lyric with lyric text and email.
     */
    public java.lang.String addLyric(int trackId, java.lang.String trackCheckSum, java.lang.String lyric, java.lang.String email) throws java.rmi.RemoteException;

    /**
     * Search for lyrics by artist and track and directly returns
     * the lyric or lyric add parameters.
     */
    public com.chartlyrics.api.GetLyricResult searchLyricDirect(java.lang.String artist, java.lang.String song) throws java.rmi.RemoteException;
}
