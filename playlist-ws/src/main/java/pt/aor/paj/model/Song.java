package pt.aor.paj.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Song {

	private Integer id;
	private String title;
	private String artist;
	private String album;
	@XmlElement(name = "release-date")
	private Date releaseDate;
	@XmlElement(name = "file-path")
	private String filePath;

	public Song() {
	}

	public Song(Integer id, String title, String artist, String album,
			Date releaseDate, String filePath) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.releaseDate = releaseDate;
		this.filePath = filePath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
