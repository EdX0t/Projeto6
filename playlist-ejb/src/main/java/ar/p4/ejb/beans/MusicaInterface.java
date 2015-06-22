package ar.p4.ejb.beans;


import java.util.List;

import javax.ejb.Local;

import ar.p4.entities.Musica;
import ar.p4.entities.Utilizador;

@Local
public interface MusicaInterface{
	
	public abstract void save(Musica musica);
	public abstract void update(Musica musica);
	public abstract void delete(Musica musica);
	public abstract Musica find(int musicaID);
	public abstract List<Musica> findAll();
	public abstract List<String> findListaArtistas();
	public abstract List<Musica> findMusicaByArtista(String nome);
	public abstract List<String> findListaTitulos();
	public abstract List<Musica> findMusicaByTitulo(String nome);
	public abstract List<Musica> findAllByUser(Utilizador user);
	public abstract List<String> findListaTitulosPorArtista(String artistaSeleccionado);
	public abstract Musica findMusicaByTituloArtista(String artista, String titulo);
	
}