package ar.p4.ejb.beans;


import javax.ejb.Stateless;
import javax.inject.Inject;

import ar.p4.ejb.dao.LyricDao;
import ar.p4.ejb.dao.MusicaDao;
import ar.p4.ejb.dao.UserDao;
import ar.p4.ejb.webservice.LyricSOAPorREST;
import ar.p4.entities.LyricEntity;
import ar.p4.entities.Musica;
import ar.p4.entities.Utilizador;

@Stateless
public class LyricBean implements LyricInterface {

	@Inject
	private LyricDao lyricDao;
	@Inject
	private MusicaDao musicDao;
	@Inject
	private UserDao userDao;
	@Inject
	private LyricSOAPorREST lyric;

	@Override
	public void save(int utiID, int musicID, String lyric) {
		Musica music=musicDao.find(musicID);
		Utilizador uti=userDao.find(utiID);
		LyricEntity lyricEntity= new LyricEntity(lyric, music, uti);
		lyricDao.save(lyricEntity);
		
	}
	
	private String lyricOfMusic(String song, String artist){
		return lyric.lyricOfMusic(artist, song);
		
	}
	
	@Override
	public String findSave (int musicID, String song, String artista){
		Musica music=musicDao.find(musicID);
		System.out.println(musicID + "Musica---" + music);
		String lyric=lyricOfMusic(song,artista);
		if (lyric != null){
			LyricEntity lyricEntity= new LyricEntity(lyric, music, null);
			lyricDao.save(lyricEntity);
		}
		
		return lyric;
	}

	
	@Override
	public String lyricUserMusic(int utiID, int musicID) {
		System.out.println("uti "+utiID);
		Musica music=musicDao.find(musicID);
		if(music==null)return null;
		Utilizador uti=userDao.find(utiID);
		LyricEntity lyricUti=lyricDao.lyricOfMUsic(uti, music);
		if (lyricUti != null) return lyricUti.getLyric();
		System.out.println(lyricUti);
		
		LyricEntity lyricNull=lyricDao.lyricOfMUsic(null, music);
		if(lyricNull != null) return lyricNull.getLyric();
		System.out.println(lyricNull);
		
		String lyric=findSave(musicID, music.getTitulo(),music.getArtista());
		
		return lyric;
	
	}
	
	
	@Override
	public void update(LyricEntity lyric) {


	}

	@Override
	public void delete(LyricEntity lyric) {


	}




}
