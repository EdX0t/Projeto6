package ar.p4.cdibeans;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ar.p4.ejb.beans.LyricInterface;
import ar.p4.entities.LyricEntity;

@Named
@RequestScoped
public class LyricsCDIBean {

	@EJB
	private LyricInterface lyricBean;
	@Inject
	private UserSession user;
	private int musicId;
	private String lyric;
	private boolean editar=false;
	//private LyricEntity lyricOriginal;
	
	
	

	public LyricsCDIBean() {
		
	
	}
	

	public String viewLyric(){
		System.out.println("entrou na função viewLyric--" + this.musicId);
		this.lyric=lyricBean.lyricUserMusic(user.getCurrent().getId(), this.musicId);
		
		if(this.lyric == null){
			this.lyric="Lyric of Music not found!!";
		}
		return this.lyric;
	}


	
	
	public void coisas() {
		System.out.println("asfdj + coisas");
	}












	public int getMusicId() {
		return musicId;
	}





	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}





	public String getLyric() {
		return viewLyric();
	}





	public void setLyric(String lyric) {
		this.lyric = lyric;
	}





	public boolean isEditar() {
		return editar;
	}





	public void setEditar(boolean editar) {
		this.editar = editar;
	}






}
