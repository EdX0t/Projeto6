package ar.p4.ejb.beans;


import java.util.List;

import javax.ejb.Local;

import ar.p4.entities.MusicEntity;
import ar.p4.entities.UserEntity;

@Local
public interface MusicInterface{
	
	public abstract boolean save(MusicEntity musicEntity);
	public abstract void update(MusicEntity musicEntity);
	public abstract void delete(MusicEntity musicEntity);
	public abstract MusicEntity find(int musicaID);
	public abstract List<MusicEntity> findAll();
	public abstract List<String> findListaArtistas();
	public abstract List<MusicEntity> findMusicaByArtista(String nome);
	public abstract List<String> findListaTitulos();
	public abstract List<MusicEntity> findMusicaByTitulo(String nome);
	public abstract List<MusicEntity> findAllByUser(UserEntity user);
	public abstract List<String> findListaTitulosPorArtista(String artistaSeleccionado);
	public abstract MusicEntity findMusicaByTituloArtista(String artista, String titulo);
	
}