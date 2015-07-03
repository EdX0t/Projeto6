package ar.p4.util;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ar.p4.cdibeans.LyricsCDIBean;
import ar.p4.cdibeans.PlaylistCDIBean;

@Named
@SessionScoped
public class PageHandler implements Serializable{
	
	@Inject 
	private PlaylistCDIBean playlists;
	private static final long serialVersionUID = -3667136585355133619L;
	private String page;
	@Inject
	private LyricsCDIBean lyricBean;
	
	public PageHandler(){
		
	}
	@PostConstruct
	public void defPage() {
        this.page = "musicas";
    }
	

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		if(!page.equals("musicas_playlist")){
			playlists.setSelectedPlaylist(null);
				
		}
		lyricBean.setMusic(null);
		this.page = page;
	}

}
