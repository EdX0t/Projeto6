package ar.p4.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;




@Entity
@Table(name = "Lyrics")
@NamedQuery(name = "LyricByUserANDMusic", query = "SELECT l FROM LyricEntity l WHERE l.utilizador=:utilizador and l.music=:music")
@XmlRootElement
public class LyricEntity {
	
	public static final String LYRICS_BY_USER_MUSIC = "LyricByUserANDMusic";


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "lyric")
	private String lyric;
	@ManyToOne
	private Musica music;
	@ManyToOne
	private Utilizador utilizador;
	

	public LyricEntity() {
		super();
	}
	
	
	public LyricEntity(String lyric, Musica music, Utilizador utilizador) {
		super();
		this.lyric = lyric;
		this.music = music;
		this.utilizador = utilizador;
	}
	public String getLyric() {
		return lyric;
	}
	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	public Musica getMusic() {
		return music;
	}
	public void setMusic(Musica music) {
		this.music = music;
	}
	public Utilizador getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}
	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((lyric == null) ? 0 : lyric.hashCode());
		result = prime * result + ((music == null) ? 0 : music.hashCode());
		result = prime * result
				+ ((utilizador == null) ? 0 : utilizador.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LyricEntity other = (LyricEntity) obj;
		if (id != other.id)
			return false;
		if (lyric == null) {
			if (other.lyric != null)
				return false;
		} else if (!lyric.equals(other.lyric))
			return false;
		if (music == null) {
			if (other.music != null)
				return false;
		} else if (!music.equals(other.music))
			return false;
		if (utilizador == null) {
			if (other.utilizador != null)
				return false;
		} else if (!utilizador.equals(other.utilizador))
			return false;
		return true;
	}
	
}
