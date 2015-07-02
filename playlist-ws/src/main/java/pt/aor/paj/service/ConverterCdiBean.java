package pt.aor.paj.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.NotFoundException;

import pt.aor.paj.model.LoggedUsers;
import pt.aor.paj.model.Playlist;
import pt.aor.paj.model.Playlists;
import pt.aor.paj.model.Song;
import pt.aor.paj.model.Songs;
import pt.aor.paj.model.User;
import pt.aor.paj.model.Users;
import ar.p4.ejb.beans.MusicInterface;
import ar.p4.ejb.beans.PlaylistInterface;
import ar.p4.ejb.beans.UserInterface;
import ar.p4.ejb.util.LoggedUserUtil;
import ar.p4.entities.MusicEntity;
import ar.p4.entities.PlaylistEntity;
import ar.p4.entities.UserEntity;

@Named
@RequestScoped
public class ConverterCdiBean {

	@Inject
	private UserInterface userInterface;
	@Inject
	private PlaylistInterface playlistInterface;
	@Inject
	MusicInterface musicInterface;
	@Inject private LoggedUserUtil loggedUtil;
	private LoggedUsers loggedUsers;
	private Users users;

	public ConverterCdiBean() {

	}

	public Users getUserList() {
		ArrayList<UserEntity> entitiesList = userInterface.getUtilizadores();
		users = new Users();
		// fazer conversao
		for (UserEntity entity : entitiesList) {
			users.getUser().add(convertUser(entity));
		}
		// devolver objecto com coleccao como atributo
		return users;
	}

	public User findUserById(int id) {
		UserEntity user = userInterface.findById(id);
		checkUser(user);
		return convertUser(user);
	}
	
	public User findUserByEmail(String email) {
		UserEntity user = userInterface.findByEmail(email);
		checkUser(user);
		return convertUser(user);
	}

	public Playlists getPlaylists(UserEntity user) {
		checkUser(user);
		List<PlaylistEntity> entitiesList = playlistInterface
				.allPlaylists(user);
		Playlists playlists = new Playlists();
		for (PlaylistEntity entity : entitiesList) {
			playlists.getPlaylist().add(convertPlaylist(entity));
		}
		return playlists;
	}

	public Songs getMusic(UserEntity temp) {
		checkUser(temp);
		List<MusicEntity> musicList = musicInterface.findAllByUser(temp);
		Songs songs = new Songs();
		for (MusicEntity entity : musicList) {
			songs.getSong().add(convertMusic(entity));
		}

		return songs;
	}
	public void checkUser(UserEntity user){
		UserEntity userEntity = userInterface.findById(user.getId());
		if(userEntity == null){
			throw new NotFoundException();
		}
	}

	// playlists
	public Playlists getAllPlaylists() {
		List<PlaylistEntity> entitiesList = playlistInterface.getAllPlaylists();
		Playlists playlists = new Playlists();
		for (PlaylistEntity entity : entitiesList) {
			playlists.getPlaylist().add(convertPlaylist(entity));
		}
		return playlists;
	}

	// lista de musicas numa playlist
	public Songs getSongsInPlaylist(PlaylistEntity playlist) {
		List<MusicEntity> musicList = playlistInterface.getPlaylistById(
				playlist.getId()).getMusicas();
		Songs songList = new Songs();
		for (MusicEntity m : musicList) {
			songList.getSong().add(convertMusic(m));
		}
		return songList;
	}

	// todas as musicas na aplicacao
	public Songs getAllSongs() {
		List<MusicEntity> musicList = musicInterface.findAll();
		Songs songList = new Songs();
		for (MusicEntity m : musicList) {
			songList.getSong().add(convertMusic(m));
		}
		return songList;
	}

	// encontrar musica por id
	public Song findMusicById(int id) {
		return convertMusic(musicInterface.find(id));
	}

	private User convertUser(UserEntity entity) {
		User user = new User();
		user.setId(entity.getId());
		user.setEmail(entity.getMail());
		user.setName(entity.getNome());
		user.setPassword(entity.getPassword());
		return user;
	}

	private Playlist convertPlaylist(PlaylistEntity entity) {
		Playlist playlist = new Playlist(entity.getId(), entity.getNome(),
				entity.getData_criacao(), entity.getTamanho());
		return playlist;
	}

	private Song convertMusic(MusicEntity entity) {
		Song song = new Song(entity.getId(), entity.getTitulo(),
				entity.getAlbum(), entity.getArtista(),
				entity.getAnoLancamento(), entity.getFilePath());
		return song;
	}
	private UserEntity convertToUserEntity(User user){
		UserEntity userEntity = new UserEntity();
		userEntity.setMail(user.getEmail());
		userEntity.setNome(user.getName());
		userEntity.setPassword(user.getPassword());
		userEntity.setId(user.getId());
		return userEntity;
	}

	public boolean addUser(User user) {
		boolean success = userInterface.save(convertToUserEntity(user));
		if(success)
			return true;
		else
		return false;
	}

	public boolean removeUser(int id) {
		if(id>0){
		userInterface.delete(userInterface.findById(id));
		return true;
		}
		return false;
	}

	public boolean updatePassword(User user) {
		if(user.getPassword() != null && user.getId()>0){
		UserEntity entity = userInterface.findById(user.getId());
		entity.setPassword(user.getPassword());
		userInterface.updatePassword(entity);
		return true;
		}
		return false;
	}

	public boolean removeSongFromPlaylist(int songId, int playlistId) {
		if(songId>0 && playlistId>0){
			MusicEntity musicEntity = musicInterface.find(songId);
			PlaylistEntity playlistEntity = playlistInterface.getPlaylistById(playlistId);
			playlistInterface.removeMusica(playlistEntity, musicEntity);
			return true;
		}
		return false;
	}

	public boolean addSongToPlaylist(Song song, int id) {
		boolean added=false;
		if(song.getId()>0 && id>0){
			MusicEntity musicEntity = musicInterface.find(song.getId());
			PlaylistEntity playlistEntity = playlistInterface.getPlaylistById(id);
			added = playlistInterface.adicionaMusica(musicEntity, playlistEntity);
			return added;
		}
		return added;
	}
	
	public boolean deleteSongFromUser(int idUser, int idSong){
		UserEntity user =userInterface.findById(idUser);
		if(user == null){
			throw new NotFoundException();
		} else if(idUser>0 && idSong>0){
		MusicEntity musicEntity = musicInterface.find(idSong);
		musicInterface.delete(musicEntity);
		return true;
		}
		return false;
	}
	public LoggedUsers getLoggedUsers(){
		ArrayList<UserEntity> entitiesList = loggedUtil.getLoggedUsersList();
		loggedUsers = new LoggedUsers();
		// fazer conversao
		for (UserEntity entity : entitiesList) {
			loggedUsers.getUser().add(convertUser(entity));
		}
		// devolver objecto com coleccao como atributo
		return loggedUsers;
	}

}
