package ar.p4.ejb.beans;

import java.util.List;

import javax.ejb.Local;

import ar.p4.entities.MusicEntity;
import ar.p4.entities.PlaylistEntity;
import ar.p4.entities.UserEntity;

@Local
public interface PlaylistInterface {
	
	public abstract void save(PlaylistEntity playlistEntity);
	public abstract void update(PlaylistEntity playlistEntity);
	public abstract void delete(PlaylistEntity playlistEntity);
	public abstract List<PlaylistEntity> allPlaylists(UserEntity user);
	public abstract List<PlaylistEntity> playlistOrdenadoNome(UserEntity user, String ordem);
	public abstract List<PlaylistEntity> playlistOrdenadoData(UserEntity user, String ordem);
	public abstract List<PlaylistEntity> playlistOrdenadoTamanho(UserEntity user, String ordem);
	public abstract boolean adicionaMusica(MusicEntity musicEntity,PlaylistEntity playListNome);
	public abstract void removeMusica(PlaylistEntity playlistEntity, MusicEntity musicaRemover);
	public abstract List<PlaylistEntity> getAllPlaylists();
	public abstract PlaylistEntity getPlaylistById(int id);
}
