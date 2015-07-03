package ar.p4.cdibeans;

import java.io.Serializable;
import java.util.Arrays;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import ar.p4.ejb.beans.LyricInterface;
import ar.p4.entities.MusicEntity;

@Named
@SessionScoped
public class LyricsCDIBean implements Serializable {


	private static final long serialVersionUID = 1L;
	@EJB
	private LyricInterface lyricBean;
	@Inject
	private UserSession user;
	private int musicId;
	private MusicEntity music;
	private String lyric;
	private boolean editing = false;


	public LyricsCDIBean() {

	}


	public void newSearchOfMusic(){

		String lyricSearch=lyricBean.lyricUserMusic(null, music.getId() );

		System.out.println("lirica do user---"+lyric);
		FacesMessage msg;

		if(lyricSearch == null || lyricSearch.equalsIgnoreCase("Lyric of Music not found!!")){
			msg= new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Lyric of Music not found!!", null);
		}else{
			System.out.println("lyric original-----"+ lyric);
			msg = new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Lyric original!", null);
		}
		this.lyric=lyricSearch;
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:lyricMusic"));
		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("lyric apos mensagem "+ lyric);
		editing = true;
	}

	public String viewLyric(){

		if(catchMusic()=="Musica Selecionada" && !editing){
			System.out.println("Musica id"+music.getId());
			this.lyric=lyricBean.lyricUserIDMusic(user.getCurrent().getId(), music.getId());
			System.out.println("view  "+lyric);
		}

		if(this.lyric == null){
			this.lyric="Lyric of Music not found!!";
		}
		editing = false;

		return this.lyric;
	}

	public void editLyric(){

		lyricBean.saveOrUpdate(user.getCurrent(), music.getId(), lyric);



		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:musiclyric"));
		FacesMessage msg = new FacesMessage(
				FacesMessage.SEVERITY_INFO,
				"Lyric edited successfully!", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);

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



	public String catchMusic() {
		if (this.music == null) return "Musica não selecionada";
		return "Musica Selecionada";
	}

	public MusicEntity getMusic(){
		return music;

	}


	public void setMusic(MusicEntity music) {
		this.music = music;
	}



}
