package ar.p4.ejb.beans;


import javax.ejb.Stateless;
import javax.inject.Inject;

import ar.p4.ejb.dao.LyricDao;
import ar.p4.ejb.dao.MusicDao;
import ar.p4.ejb.dao.UserDao;
import ar.p4.ejb.webservice.LyricSOAPorREST;
import ar.p4.entities.LyricEntity;
import ar.p4.entities.MusicEntity;
import ar.p4.entities.UserEntity;


@Stateless
public class LyricBean implements LyricInterface {

	@Inject
	private LyricDao lyricDao;
	@Inject
	private MusicDao musicDao;
	@Inject
	private UserDao userDao;
	@Inject
	private LyricSOAPorREST lyric;

	@Override
	public void save(int utiID, int musicID, String lyric) {
		MusicEntity music=musicDao.find(musicID);
		System.out.println("Id da Musica"+musicID);
		UserEntity uti=userDao.find(utiID);
		System.out.println("Id do user"+utiID);
		LyricEntity lyricEntity= new LyricEntity(lyric, music, uti);
		lyricDao.save(lyricEntity);
		
	}
	
	private String lyricOfMusic(String song, String artist){
		return lyric.lyricOfMusic(artist, song);
		
	}
	
	@Override
	public String findSave (int musicID, String song, String artista){
		MusicEntity music=musicDao.find(musicID);
		System.out.println(musicID + "Musica---" + music);
		String lyric=lyricOfMusic(song,artista);
		if (lyric != null){
			LyricEntity lyricEntity= new LyricEntity(lyric, music, null);
			lyricDao.save(lyricEntity);
		}
		
		return lyric;
	}

	
	@Override
	public String lyricUserIDMusic(int utiID, int musicID) {
		System.out.println("uti "+utiID);
		MusicEntity music=musicDao.find(musicID);
		if(music==null)return null;
		UserEntity uti=userDao.find(utiID);
		LyricEntity lyricUti=lyricDao.lyricOfMUsic(uti, music);
		if (lyricUti != null) return lyricUti.getLyric();
		System.out.println(lyricUti);
		
		LyricEntity lyricNull=lyricDao.lyricOfMUsic(null, music);
		if(lyricNull != null) return lyricNull.getLyric();
		System.out.println(lyricNull);
		
		String lyric=findSave(musicID, music.getTitulo(),music.getArtista());
		
		return lyric;
	
	}
	
	public String lyricUserMusic(UserEntity uti, int musicID) {
	
		MusicEntity music=musicDao.find(musicID);
		if(music==null)return null;
		
		LyricEntity lyricNull=lyricDao.lyricOfMUsic(null, music);
		if(lyricNull != null) return lyricNull.getLyric();
		System.out.println("bean"+lyricNull);
		
		String lyric=findSave(musicID, music.getTitulo(),music.getArtista());
		
		return lyric;
	
	}
	
	public void saveOrUpdate (UserEntity uti, int musicID, String lyricEdit){
		MusicEntity music=musicDao.find(musicID);
		LyricEntity lyricUser=lyricDao.lyricOfMUsic(uti, music); 
		
		if(lyricUser == null){
			LyricEntity lyricEntity= new LyricEntity(lyricEdit, music, uti);
			System.out.println("lyricUser está null vai salvar");
			lyricDao.save(lyricEntity);
		}else{
			System.out.println("lyricUser nao está vazio vai update");
			lyricUser.setLyric(lyricEdit);
			lyricDao.update(lyricUser);
		}
	}
	
	


	@Override
	public void delete(LyricEntity lyric) {


	}




}
