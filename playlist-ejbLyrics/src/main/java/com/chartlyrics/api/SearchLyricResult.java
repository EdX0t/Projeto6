/**
 * SearchLyricResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.chartlyrics.api;

public class SearchLyricResult  implements java.io.Serializable {
    private java.lang.String trackChecksum;

    private int trackId;

    private java.lang.String lyricChecksum;

    private int lyricId;

    private java.lang.String songUrl;

    private java.lang.String artistUrl;

    private java.lang.String artist;

    private java.lang.String song;

    private int songRank;

    public SearchLyricResult() {
    }

    public SearchLyricResult(
           java.lang.String trackChecksum,
           int trackId,
           java.lang.String lyricChecksum,
           int lyricId,
           java.lang.String songUrl,
           java.lang.String artistUrl,
           java.lang.String artist,
           java.lang.String song,
           int songRank) {
           this.trackChecksum = trackChecksum;
           this.trackId = trackId;
           this.lyricChecksum = lyricChecksum;
           this.lyricId = lyricId;
           this.songUrl = songUrl;
           this.artistUrl = artistUrl;
           this.artist = artist;
           this.song = song;
           this.songRank = songRank;
    }


    /**
     * Gets the trackChecksum value for this SearchLyricResult.
     * 
     * @return trackChecksum
     */
    public java.lang.String getTrackChecksum() {
        return trackChecksum;
    }


    /**
     * Sets the trackChecksum value for this SearchLyricResult.
     * 
     * @param trackChecksum
     */
    public void setTrackChecksum(java.lang.String trackChecksum) {
        this.trackChecksum = trackChecksum;
    }


    /**
     * Gets the trackId value for this SearchLyricResult.
     * 
     * @return trackId
     */
    public int getTrackId() {
        return trackId;
    }


    /**
     * Sets the trackId value for this SearchLyricResult.
     * 
     * @param trackId
     */
    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }


    /**
     * Gets the lyricChecksum value for this SearchLyricResult.
     * 
     * @return lyricChecksum
     */
    public java.lang.String getLyricChecksum() {
        return lyricChecksum;
    }


    /**
     * Sets the lyricChecksum value for this SearchLyricResult.
     * 
     * @param lyricChecksum
     */
    public void setLyricChecksum(java.lang.String lyricChecksum) {
        this.lyricChecksum = lyricChecksum;
    }


    /**
     * Gets the lyricId value for this SearchLyricResult.
     * 
     * @return lyricId
     */
    public int getLyricId() {
        return lyricId;
    }


    /**
     * Sets the lyricId value for this SearchLyricResult.
     * 
     * @param lyricId
     */
    public void setLyricId(int lyricId) {
        this.lyricId = lyricId;
    }


    /**
     * Gets the songUrl value for this SearchLyricResult.
     * 
     * @return songUrl
     */
    public java.lang.String getSongUrl() {
        return songUrl;
    }


    /**
     * Sets the songUrl value for this SearchLyricResult.
     * 
     * @param songUrl
     */
    public void setSongUrl(java.lang.String songUrl) {
        this.songUrl = songUrl;
    }


    /**
     * Gets the artistUrl value for this SearchLyricResult.
     * 
     * @return artistUrl
     */
    public java.lang.String getArtistUrl() {
        return artistUrl;
    }


    /**
     * Sets the artistUrl value for this SearchLyricResult.
     * 
     * @param artistUrl
     */
    public void setArtistUrl(java.lang.String artistUrl) {
        this.artistUrl = artistUrl;
    }


    /**
     * Gets the artist value for this SearchLyricResult.
     * 
     * @return artist
     */
    public java.lang.String getArtist() {
        return artist;
    }


    /**
     * Sets the artist value for this SearchLyricResult.
     * 
     * @param artist
     */
    public void setArtist(java.lang.String artist) {
        this.artist = artist;
    }


    /**
     * Gets the song value for this SearchLyricResult.
     * 
     * @return song
     */
    public java.lang.String getSong() {
        return song;
    }


    /**
     * Sets the song value for this SearchLyricResult.
     * 
     * @param song
     */
    public void setSong(java.lang.String song) {
        this.song = song;
    }


    /**
     * Gets the songRank value for this SearchLyricResult.
     * 
     * @return songRank
     */
    public int getSongRank() {
        return songRank;
    }


    /**
     * Sets the songRank value for this SearchLyricResult.
     * 
     * @param songRank
     */
    public void setSongRank(int songRank) {
        this.songRank = songRank;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchLyricResult)) return false;
        SearchLyricResult other = (SearchLyricResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.trackChecksum==null && other.getTrackChecksum()==null) || 
             (this.trackChecksum!=null &&
              this.trackChecksum.equals(other.getTrackChecksum()))) &&
            this.trackId == other.getTrackId() &&
            ((this.lyricChecksum==null && other.getLyricChecksum()==null) || 
             (this.lyricChecksum!=null &&
              this.lyricChecksum.equals(other.getLyricChecksum()))) &&
            this.lyricId == other.getLyricId() &&
            ((this.songUrl==null && other.getSongUrl()==null) || 
             (this.songUrl!=null &&
              this.songUrl.equals(other.getSongUrl()))) &&
            ((this.artistUrl==null && other.getArtistUrl()==null) || 
             (this.artistUrl!=null &&
              this.artistUrl.equals(other.getArtistUrl()))) &&
            ((this.artist==null && other.getArtist()==null) || 
             (this.artist!=null &&
              this.artist.equals(other.getArtist()))) &&
            ((this.song==null && other.getSong()==null) || 
             (this.song!=null &&
              this.song.equals(other.getSong()))) &&
            this.songRank == other.getSongRank();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getTrackChecksum() != null) {
            _hashCode += getTrackChecksum().hashCode();
        }
        _hashCode += getTrackId();
        if (getLyricChecksum() != null) {
            _hashCode += getLyricChecksum().hashCode();
        }
        _hashCode += getLyricId();
        if (getSongUrl() != null) {
            _hashCode += getSongUrl().hashCode();
        }
        if (getArtistUrl() != null) {
            _hashCode += getArtistUrl().hashCode();
        }
        if (getArtist() != null) {
            _hashCode += getArtist().hashCode();
        }
        if (getSong() != null) {
            _hashCode += getSong().hashCode();
        }
        _hashCode += getSongRank();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchLyricResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "SearchLyricResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trackChecksum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "TrackChecksum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trackId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "TrackId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lyricChecksum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "LyricChecksum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lyricId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "LyricId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("songUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "SongUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("artistUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "ArtistUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("artist");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "Artist"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("song");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "Song"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("songRank");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "SongRank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
