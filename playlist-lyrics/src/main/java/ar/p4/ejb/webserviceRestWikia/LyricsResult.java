package ar.p4.ejb.webserviceRestWikia;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name="LyricsResult")
public class LyricsResult {

	@XmlElement(name="lyrics", required=true)
	private String lyricsWiki;
	
	
	public LyricsResult() {
			
	}


	public String getLyric() {
		return lyricsWiki;
	}


	public void setLyric(String lyrics) {
		this.lyricsWiki = lyrics;
	}

}
