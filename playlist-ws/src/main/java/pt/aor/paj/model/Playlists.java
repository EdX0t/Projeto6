package pt.aor.paj.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "playlists")
@XmlType(name = "playlistsType", propOrder = { "playlist" })
public class Playlists {
	private ArrayList<Playlist> playlist;

	public Playlists() {
	}

	public ArrayList<Playlist> getPlaylist() {
		if (playlist == null) {
			playlist = new ArrayList<Playlist>();
		}

		return playlist;
	}

	public void setPlaylist(ArrayList<Playlist> playlist) {
		this.playlist = playlist;
	}

}
