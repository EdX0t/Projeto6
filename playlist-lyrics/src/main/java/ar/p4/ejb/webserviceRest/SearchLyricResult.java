
package ar.p4.ejb.webserviceRest;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name = "SearchLyricResult", namespace="http://api.chartlyrics.com/")
public class SearchLyricResult {

    @XmlElement(name = "LyricChecksum")
    protected String searchChecksum;
    @XmlElement(name = "LyricId")
    protected int lyricIdSearch;
    @XmlElement(name = "Artist")
    protected String artistSearch;
    @XmlElement(name = "Song")
    protected String songSearch;


 
    /**
     * Gets the value of the lyricChecksum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLyricChecksum() {
        return searchChecksum;
    }

    /**
     * Sets the value of the lyricChecksum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLyricChecksum(String value) {
        this.searchChecksum = value;
    }

    /**
     * Gets the value of the lyricId property.
     * 
     */
    public int getLyricId() {
        return lyricIdSearch;
    }

    /**
     * Sets the value of the lyricId property.
     * 
     */
    public void setLyricId(int value) {
        this.lyricIdSearch = value;
    }


    /**
     * Gets the value of the artist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArtist() {
        return artistSearch;
    }

    /**
     * Sets the value of the artist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArtist(String value) {
        this.artistSearch = value;
    }

    /**
     * Gets the value of the song property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSong() {
        return songSearch;
    }

    /**
     * Sets the value of the song property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSong(String value) {
        this.songSearch = value;
    }

}
