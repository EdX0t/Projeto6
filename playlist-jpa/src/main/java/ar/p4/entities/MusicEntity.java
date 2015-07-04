package ar.p4.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"titulo", "artista", "album"}))
@NamedQuery(name = "findMusicByAtributeUnique", query = "SELECT m FROM MusicEntity m WHERE m.titulo like :titulo and m.artista like :artista and m.album like :album ")
public class MusicEntity implements Serializable {

	private static final long serialVersionUID = 9008393849875735770L;
	public static final String FIND_MUSIC_BY_ATRIBUTE_UNIQUE = "findMusicByAtributeUnique";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;

	
	@NotEmpty
	@Column(name = "titulo", nullable = false, length = 40)
	private String titulo;

	@NotEmpty
	@Column(name = "artista", nullable = false, length = 40)
	private String artista;

	@NotEmpty
	@Column(name="album", nullable = false, length = 30)
	private String album;

	
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "ano_lancamento")
	private Date anoLancamento;

	
	@Column(name="Path")
	private String filePath;

	@ManyToOne
	private UserEntity dono;
	
	@ManyToMany(mappedBy = "musicEntities")
	private List<PlaylistEntity> playlistEntities;
	
	

	
	public MusicEntity() {
		super();
	}
	
	

	public MusicEntity(String titulo, String artista, String album,
			Date anoLancamento, String filePath, UserEntity dono,
			List<PlaylistEntity> playlistEntities) {
		super();
		this.titulo = titulo;
		this.artista = artista;
		this.album = album;
		this.anoLancamento = anoLancamento;
		
	}



	public UserEntity getDono() {
		return dono;
	}
	
	public List<PlaylistEntity> getPlaylists() {
		return playlistEntities;
	}


	public void setPlaylists(List<PlaylistEntity> playlistEntity) {
		this.playlistEntities = playlistEntity;
	}


	public void setDono(UserEntity dono) {
		this.dono = dono;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Date getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Date anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result
				+ ((anoLancamento == null) ? 0 : anoLancamento.hashCode());
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		MusicEntity other = (MusicEntity) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (anoLancamento == null) {
			if (other.anoLancamento != null)
				return false;
		} else if (!anoLancamento.equals(other.anoLancamento))
			return false;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}


}

