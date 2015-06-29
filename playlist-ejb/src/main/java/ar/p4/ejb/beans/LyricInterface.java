package ar.p4.ejb.beans;

import javax.ejb.Local;

import ar.p4.entities.LyricEntity;


@Local
public interface LyricInterface {
	public abstract void save(int utiID, int musicID, String lyric);
	public abstract void update(LyricEntity lyric);
	public abstract void delete(LyricEntity lyric);
	public abstract String lyricUserMusic(int utiID, long musicID);
	public void findSave(int musicID, String song, String artista);

}
