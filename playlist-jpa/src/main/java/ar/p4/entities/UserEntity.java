package ar.p4.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "utilizador")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utilizador")
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "mail")
	private String mail;

	@Column(name = "password")
	private String password;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date data_nascimento;

	@OneToMany(mappedBy = "dono", cascade = CascadeType.ALL)
	private List<PlaylistEntity> playlistEntities;
	
	@OneToMany
	private List<MusicEntity> userMusic;
	
	@Column(name="role")
	private String role = "USER";

	public UserEntity() {

	}

	public UserEntity(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	

	public List<MusicEntity> getUserMusic() {
		return userMusic;
	}

	public void setUserMusic(List<MusicEntity> userMusic) {
		this.userMusic = userMusic;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		UserEntity other = (UserEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
