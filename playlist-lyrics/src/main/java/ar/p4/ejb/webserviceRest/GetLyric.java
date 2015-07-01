
package ar.p4.ejb.webserviceRest;


import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "GetLyric", namespace="http://api.chartlyrics.com/")
public class GetLyric {

    protected int lyricId;
    protected String lyricCheckSum;

    /**
     * Gets the value of the lyricId property.
     * 
     */
    public int getLyricId() {
        return lyricId;
    }

    /**
     * Sets the value of the lyricId property.
     * 
     */
    public void setLyricId(int value) {
        this.lyricId = value;
    }

    /**
     * Gets the value of the lyricCheckSum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLyricCheckSum() {
        return lyricCheckSum;
    }

    /**
     * Sets the value of the lyricCheckSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLyricCheckSum(String value) {
        this.lyricCheckSum = value;
    }

}
