package pt.aor.paj.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="songs")
@XmlType(name = "songsType", propOrder = {
    "song"
})
public class Songs {
	private ArrayList<Song> song;
	
	public Songs(){}

	public ArrayList<Song> getSong() {
		if(song==null)
			song= new ArrayList<Song>();
		return song;
	}

	public void setSong(ArrayList<Song> song) {
		this.song = song;
	}

}
