/**
 * GetLyricResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.chartlyrics.api;

public class GetLyricResult  implements java.io.Serializable {
    private java.lang.String trackChecksum;

    private int trackId;

    private java.lang.String lyricChecksum;

    private int lyricId;

    private java.lang.String lyricSong;

    private java.lang.String lyricArtist;

    private java.lang.String lyricUrl;

    private java.lang.String lyricCovertArtUrl;

    private int lyricRank;

    private java.lang.String lyricCorrectUrl;

    private java.lang.String lyric;

    public GetLyricResult() {
    }

    public GetLyricResult(
           java.lang.String trackChecksum,
           int trackId,
           java.lang.String lyricChecksum,
           int lyricId,
           java.lang.String lyricSong,
           java.lang.String lyricArtist,
           java.lang.String lyricUrl,
           java.lang.String lyricCovertArtUrl,
           int lyricRank,
           java.lang.String lyricCorrectUrl,
           java.lang.String lyric) {
           this.trackChecksum = trackChecksum;
           this.trackId = trackId;
           this.lyricChecksum = lyricChecksum;
           this.lyricId = lyricId;
           this.lyricSong = lyricSong;
           this.lyricArtist = lyricArtist;
           this.lyricUrl = lyricUrl;
           this.lyricCovertArtUrl = lyricCovertArtUrl;
           this.lyricRank = lyricRank;
           this.lyricCorrectUrl = lyricCorrectUrl;
           this.lyric = lyric;
    }


    /**
     * Gets the trackChecksum value for this GetLyricResult.
     * 
     * @return trackChecksum
     */
    public java.lang.String getTrackChecksum() {
        return trackChecksum;
    }


    /**
     * Sets the trackChecksum value for this GetLyricResult.
     * 
     * @param trackChecksum
     */
    public void setTrackChecksum(java.lang.String trackChecksum) {
        this.trackChecksum = trackChecksum;
    }


    /**
     * Gets the trackId value for this GetLyricResult.
     * 
     * @return trackId
     */
    public int getTrackId() {
        return trackId;
    }


    /**
     * Sets the trackId value for this GetLyricResult.
     * 
     * @param trackId
     */
    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }


    /**
     * Gets the lyricChecksum value for this GetLyricResult.
     * 
     * @return lyricChecksum
     */
    public java.lang.String getLyricChecksum() {
        return lyricChecksum;
    }


    /**
     * Sets the lyricChecksum value for this GetLyricResult.
     * 
     * @param lyricChecksum
     */
    public void setLyricChecksum(java.lang.String lyricChecksum) {
        this.lyricChecksum = lyricChecksum;
    }


    /**
     * Gets the lyricId value for this GetLyricResult.
     * 
     * @return lyricId
     */
    public int getLyricId() {
        return lyricId;
    }


    /**
     * Sets the lyricId value for this GetLyricResult.
     * 
     * @param lyricId
     */
    public void setLyricId(int lyricId) {
        this.lyricId = lyricId;
    }


    /**
     * Gets the lyricSong value for this GetLyricResult.
     * 
     * @return lyricSong
     */
    public java.lang.String getLyricSong() {
        return lyricSong;
    }


    /**
     * Sets the lyricSong value for this GetLyricResult.
     * 
     * @param lyricSong
     */
    public void setLyricSong(java.lang.String lyricSong) {
        this.lyricSong = lyricSong;
    }


    /**
     * Gets the lyricArtist value for this GetLyricResult.
     * 
     * @return lyricArtist
     */
    public java.lang.String getLyricArtist() {
        return lyricArtist;
    }


    /**
     * Sets the lyricArtist value for this GetLyricResult.
     * 
     * @param lyricArtist
     */
    public void setLyricArtist(java.lang.String lyricArtist) {
        this.lyricArtist = lyricArtist;
    }


    /**
     * Gets the lyricUrl value for this GetLyricResult.
     * 
     * @return lyricUrl
     */
    public java.lang.String getLyricUrl() {
        return lyricUrl;
    }


    /**
     * Sets the lyricUrl value for this GetLyricResult.
     * 
     * @param lyricUrl
     */
    public void setLyricUrl(java.lang.String lyricUrl) {
        this.lyricUrl = lyricUrl;
    }


    /**
     * Gets the lyricCovertArtUrl value for this GetLyricResult.
     * 
     * @return lyricCovertArtUrl
     */
    public java.lang.String getLyricCovertArtUrl() {
        return lyricCovertArtUrl;
    }


    /**
     * Sets the lyricCovertArtUrl value for this GetLyricResult.
     * 
     * @param lyricCovertArtUrl
     */
    public void setLyricCovertArtUrl(java.lang.String lyricCovertArtUrl) {
        this.lyricCovertArtUrl = lyricCovertArtUrl;
    }


    /**
     * Gets the lyricRank value for this GetLyricResult.
     * 
     * @return lyricRank
     */
    public int getLyricRank() {
        return lyricRank;
    }


    /**
     * Sets the lyricRank value for this GetLyricResult.
     * 
     * @param lyricRank
     */
    public void setLyricRank(int lyricRank) {
        this.lyricRank = lyricRank;
    }


    /**
     * Gets the lyricCorrectUrl value for this GetLyricResult.
     * 
     * @return lyricCorrectUrl
     */
    public java.lang.String getLyricCorrectUrl() {
        return lyricCorrectUrl;
    }


    /**
     * Sets the lyricCorrectUrl value for this GetLyricResult.
     * 
     * @param lyricCorrectUrl
     */
    public void setLyricCorrectUrl(java.lang.String lyricCorrectUrl) {
        this.lyricCorrectUrl = lyricCorrectUrl;
    }


    /**
     * Gets the lyric value for this GetLyricResult.
     * 
     * @return lyric
     */
    public java.lang.String getLyric() {
        return lyric;
    }


    /**
     * Sets the lyric value for this GetLyricResult.
     * 
     * @param lyric
     */
    public void setLyric(java.lang.String lyric) {
        this.lyric = lyric;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetLyricResult)) return false;
        GetLyricResult other = (GetLyricResult) obj;
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
            ((this.lyricSong==null && other.getLyricSong()==null) || 
             (this.lyricSong!=null &&
              this.lyricSong.equals(other.getLyricSong()))) &&
            ((this.lyricArtist==null && other.getLyricArtist()==null) || 
             (this.lyricArtist!=null &&
              this.lyricArtist.equals(other.getLyricArtist()))) &&
            ((this.lyricUrl==null && other.getLyricUrl()==null) || 
             (this.lyricUrl!=null &&
              this.lyricUrl.equals(other.getLyricUrl()))) &&
            ((this.lyricCovertArtUrl==null && other.getLyricCovertArtUrl()==null) || 
             (this.lyricCovertArtUrl!=null &&
              this.lyricCovertArtUrl.equals(other.getLyricCovertArtUrl()))) &&
            this.lyricRank == other.getLyricRank() &&
            ((this.lyricCorrectUrl==null && other.getLyricCorrectUrl()==null) || 
             (this.lyricCorrectUrl!=null &&
              this.lyricCorrectUrl.equals(other.getLyricCorrectUrl()))) &&
            ((this.lyric==null && other.getLyric()==null) || 
             (this.lyric!=null &&
              this.lyric.equals(other.getLyric())));
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
        if (getLyricSong() != null) {
            _hashCode += getLyricSong().hashCode();
        }
        if (getLyricArtist() != null) {
            _hashCode += getLyricArtist().hashCode();
        }
        if (getLyricUrl() != null) {
            _hashCode += getLyricUrl().hashCode();
        }
        if (getLyricCovertArtUrl() != null) {
            _hashCode += getLyricCovertArtUrl().hashCode();
        }
        _hashCode += getLyricRank();
        if (getLyricCorrectUrl() != null) {
            _hashCode += getLyricCorrectUrl().hashCode();
        }
        if (getLyric() != null) {
            _hashCode += getLyric().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetLyricResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "GetLyricResult"));
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
        elemField.setFieldName("lyricSong");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "LyricSong"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lyricArtist");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "LyricArtist"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lyricUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "LyricUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lyricCovertArtUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "LyricCovertArtUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lyricRank");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "LyricRank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lyricCorrectUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "LyricCorrectUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lyric");
        elemField.setXmlName(new javax.xml.namespace.QName("http://api.chartlyrics.com/", "Lyric"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
