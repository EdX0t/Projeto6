package ar.p4.ejb.beans;

import javax.ejb.Local;

import ar.p4.entities.LyricEntity;
import ar.p4.entities.UserEntity;


@Local
public interface LyricInterface {
	public abstract void save(int utiID, int musicID, String lyric);
	public abstract void delete(LyricEntity lyric);
	public abstract String lyricUserIDMusic(int utiID, int musicID);
	public abstract String lyricUserMusic(UserEntity uti, int musicID);
	public abstract String findSave(int musicID, String song, String artista);
	public void saveOrUpdate (UserEntity uti, int musicID, String lyricEdit);
	

}
