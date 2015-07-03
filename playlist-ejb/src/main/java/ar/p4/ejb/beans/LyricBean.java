package ar.p4.ejb.beans;


import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.p4.ejb.dao.LyricDao;
import ar.p4.ejb.dao.MusicDao;
import ar.p4.ejb.dao.UserDao;
import ar.p4.ejb.webservice.LyricSOAPorREST;
import ar.p4.entities.LyricEntity;
import ar.p4.entities.MusicEntity;
import ar.p4.entities.UserEntity;


@Stateless
public class LyricBean implements LyricInterface {
	
	private static final Logger log = LoggerFactory.getLogger(LyricBean.class);

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
		UserEntity uti=userDao.find(utiID);
		LyricEntity lyricEntity= new LyricEntity(lyric, music, uti);
		log.info("Método salvar a lírica da Musica com ID, "+musicID+", do user com id, "+utiID+".");
		lyricDao.save(lyricEntity);
		
	}
	
	private String lyricOfMusic(String song, String artist){
		log.info("Procura da lyrica da musica, " +song+", do artista, " +artist+".");
		return lyric.lyricOfMusic(artist, song);
		
	}
	
	@Override
	public String findSave (int musicID, String song, String artista){
		MusicEntity music=musicDao.find(musicID);
		String lyric=lyricOfMusic(song,artista);
		if (lyric != null){
			LyricEntity lyricEntity= new LyricEntity(lyric, music, null);
			lyricDao.save(lyricEntity);
		}
		log.info("Método findSave da lírica , "+lyric+", quando o user faz upload da musica com ID, "+musicID+".");
		return lyric;
	}

	
	@Override
	public String lyricUserIDMusic(int utiID, int musicID) {
		MusicEntity music=musicDao.find(musicID);
		if(music==null)return null;
		UserEntity uti=userDao.find(utiID);
		LyricEntity lyricUti=lyricDao.lyricOfMUsic(uti, music);
		if (lyricUti != null) return lyricUti.getLyric();
		LyricEntity lyricNull=lyricDao.lyricOfMUsic(null, music);
		if(lyricNull != null) return lyricNull.getLyric();
		String lyric=findSave(musicID, music.getTitulo(),music.getArtista());
		return lyric;
	}
	
	@Override
	public String lyricUserMusic(UserEntity uti, int musicID) {
		MusicEntity music=musicDao.find(musicID);
		if(music==null)return null;
		LyricEntity lyricNull=lyricDao.lyricOfMUsic(null, music);
		if(lyricNull != null) return lyricNull.getLyric();		
		String lyric=findSave(musicID, music.getTitulo(),music.getArtista());
		return lyric;
	}
	
	@Override
	public void saveOrUpdate (UserEntity uti, int musicID, String lyricEdit){
		MusicEntity music=musicDao.find(musicID);
		LyricEntity lyricUser=lyricDao.lyricOfMUsic(uti, music); 
		log.info("Método saveOrUpdate da lírica , "+lyricEdit+", da musica com ID, "+musicID+" e com user,"+uti.getId()+".");
		if(lyricUser == null){
			LyricEntity lyricEntity= new LyricEntity(lyricEdit, music, uti);
			lyricDao.save(lyricEntity);
			log.info("Método saveOrUpdate da lírica da lirica anterior fez save.");
		}else{
			lyricUser.setLyric(lyricEdit);
			lyricDao.update(lyricUser);
			log.info("Método saveOrUpdate da lírica anterior fez update.");
		}
	}
	


	@Override
	public void delete(LyricEntity lyric) {


	}



}
