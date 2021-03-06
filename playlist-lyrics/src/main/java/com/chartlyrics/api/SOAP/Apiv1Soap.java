
package com.chartlyrics.api.SOAP;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "apiv1Soap", targetNamespace = "http://api.chartlyrics.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Apiv1Soap {


    /**
     * Search for lyrics and return the lyricId and lyricChecksum for the GetLyric function
     * 
     * @param song
     * @param artist
     * @return
     *     returns com.chartlyrics.api.ArrayOfSearchLyricResult
     */
    @WebMethod(operationName = "SearchLyric", action = "http://api.chartlyrics.com/SearchLyric")
    @WebResult(name = "SearchLyricResult", targetNamespace = "http://api.chartlyrics.com/")
    @RequestWrapper(localName = "SearchLyric", targetNamespace = "http://api.chartlyrics.com/", className = "com.chartlyrics.api.SearchLyric")
    @ResponseWrapper(localName = "SearchLyricResponse", targetNamespace = "http://api.chartlyrics.com/", className = "com.chartlyrics.api.SearchLyricResponse")
    public ArrayOfSearchLyricResult searchLyric(
        @WebParam(name = "artist", targetNamespace = "http://api.chartlyrics.com/")
        String artist,
        @WebParam(name = "song", targetNamespace = "http://api.chartlyrics.com/")
        String song);

    /**
     * Search for text in lyric and returns the lyricId and lyricChecksum for the GetLyric function
     * 
     * @param lyricText
     * @return
     *     returns com.chartlyrics.api.ArrayOfSearchLyricResult
     */
    @WebMethod(operationName = "SearchLyricText", action = "http://api.chartlyrics.com/SearchLyricText")
    @WebResult(name = "SearchLyricTextResult", targetNamespace = "http://api.chartlyrics.com/")
    @RequestWrapper(localName = "SearchLyricText", targetNamespace = "http://api.chartlyrics.com/", className = "com.chartlyrics.api.SearchLyricText")
    @ResponseWrapper(localName = "SearchLyricTextResponse", targetNamespace = "http://api.chartlyrics.com/", className = "com.chartlyrics.api.SearchLyricTextResponse")
    public ArrayOfSearchLyricResult searchLyricText(
        @WebParam(name = "lyricText", targetNamespace = "http://api.chartlyrics.com/")
        String lyricText);

    /**
     * Return lyric with lyric text, correction URL, Lyric rankigs and an URL to the album cover if applicable.
     * 
     * @param lyricCheckSum
     * @param lyricId
     * @return
     *     returns com.chartlyrics.api.GetLyricResult
     */
    @WebMethod(operationName = "GetLyric", action = "http://api.chartlyrics.com/GetLyric")
    @WebResult(name = "GetLyricResult", targetNamespace = "http://api.chartlyrics.com/")
    @RequestWrapper(localName = "GetLyric", targetNamespace = "http://api.chartlyrics.com/", className = "com.chartlyrics.api.GetLyric")
    @ResponseWrapper(localName = "GetLyricResponse", targetNamespace = "http://api.chartlyrics.com/", className = "com.chartlyrics.api.GetLyricResponse")
    public GetLyricResult getLyric(
        @WebParam(name = "lyricId", targetNamespace = "http://api.chartlyrics.com/")
        int lyricId,
        @WebParam(name = "lyricCheckSum", targetNamespace = "http://api.chartlyrics.com/")
        String lyricCheckSum);

    /**
     * Add lyric with lyric text and email.
     * 
     * @param lyric
     * @param trackId
     * @param trackCheckSum
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "AddLyric", action = "http://api.chartlyrics.com/AddLyric")
    @WebResult(name = "AddLyricResult", targetNamespace = "http://api.chartlyrics.com/")
    @RequestWrapper(localName = "AddLyric", targetNamespace = "http://api.chartlyrics.com/", className = "com.chartlyrics.api.AddLyric")
    @ResponseWrapper(localName = "AddLyricResponse", targetNamespace = "http://api.chartlyrics.com/", className = "com.chartlyrics.api.AddLyricResponse")
    public String addLyric(
        @WebParam(name = "trackId", targetNamespace = "http://api.chartlyrics.com/")
        int trackId,
        @WebParam(name = "trackCheckSum", targetNamespace = "http://api.chartlyrics.com/")
        String trackCheckSum,
        @WebParam(name = "lyric", targetNamespace = "http://api.chartlyrics.com/")
        String lyric,
        @WebParam(name = "email", targetNamespace = "http://api.chartlyrics.com/")
        String email);

    /**
     * Search for lyrics by artist and track and directly returns the lyric or lyric add parameters.
     * 
     * @param song
     * @param artist
     * @return
     *     returns com.chartlyrics.api.GetLyricResult
     */
    @WebMethod(operationName = "SearchLyricDirect", action = "http://api.chartlyrics.com/SearchLyricDirect")
    @WebResult(name = "SearchLyricDirectResult", targetNamespace = "http://api.chartlyrics.com/")
    @RequestWrapper(localName = "SearchLyricDirect", targetNamespace = "http://api.chartlyrics.com/", className = "com.chartlyrics.api.SearchLyricDirect")
    @ResponseWrapper(localName = "SearchLyricDirectResponse", targetNamespace = "http://api.chartlyrics.com/", className = "com.chartlyrics.api.SearchLyricDirectResponse")
    public GetLyricResult searchLyricDirect(
        @WebParam(name = "artist", targetNamespace = "http://api.chartlyrics.com/")
        String artist,
        @WebParam(name = "song", targetNamespace = "http://api.chartlyrics.com/")
        String song);

}
