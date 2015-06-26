package ar.p4.cdibeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import ar.p4.ejb.beans.PlaylistInterface;
import ar.p4.entities.MusicEntity;
import ar.p4.entities.PlaylistEntity;
import ar.p4.util.PageHandler;

@Named
@SessionScoped
public class PlaylistCDIBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	UserSession user;
	@Inject
	private PlaylistInterface playBean;
	private PlaylistEntity playlistEntity;
	private ArrayList<PlaylistEntity> playlistEntities;
	private PlaylistEntity selectedPlaylist;
	private String direccao;
	private String sortedBy;
	@Inject
	PageHandler pageHandler;
	@Inject
	PesquisaAuxiliar pesqAux;
	private MusicEntity musicaRemover;
	private MusicEntity musicaPlay;
	private String url;
	private String tempName;
	private String nomeInicial;

	public PlaylistCDIBean() {
		playlistEntity = new PlaylistEntity();
		direccao = null;
		sortedBy = null;
	}

	public void init() {
		if (user.isLogged())
			getData();
	}

	public void getData() {
		if (sortedBy == null || direccao == null) {
			playlistEntities = (ArrayList<PlaylistEntity>) playBean.allPlaylists(user
					.getCurrent());
		} else if (sortedBy.equals("name")) {
			sortName(direccao);
		} else if (sortedBy.equals("date")) {
			sortDate(direccao);
		} else if (sortedBy.equals("size")) {
			sortDate(direccao);
		} else {
			playlistEntities = (ArrayList<PlaylistEntity>) playBean.allPlaylists(user
					.getCurrent());
		}
	}

	public void sortName(String dir) {
		direccao = dir;
		playlistEntities = (ArrayList<PlaylistEntity>) playBean.playlistOrdenadoNome(
				user.getCurrent(), direccao);
		sortedBy = "name";
	}

	public void sortDate(String dir) {
		direccao = dir;
		playlistEntities = (ArrayList<PlaylistEntity>) playBean.playlistOrdenadoData(
				user.getCurrent(), direccao);
		sortedBy = "date";
	}

	public void sortSize(String dir) {
		direccao = dir;
		playlistEntities = (ArrayList<PlaylistEntity>) playBean.playlistOrdenadoTamanho(
				user.getCurrent(), direccao);
		sortedBy = "size";
	}

	public void save() {
		if (!checkPlaylistName(tempName)) {
			try {
				playlistEntity.setDono(user.getCurrent());
				playlistEntity.setNome(tempName);
				playBean.save(playlistEntity);
				getData();
				playlistEntity = new PlaylistEntity();
				tempName="";
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Playlist created successfully.", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
				// fazer novo get no pesquisa auxiliar
				pesqAux.getListanomesPlaylists();
			} catch (Exception e) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Error creating playlist.", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Playlist with same name already exists.", "");
			tempName="";
			RequestContext.getCurrentInstance().update(
					Arrays.asList("form-edit-playlist"));
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void edit() {
		playBean.update(selectedPlaylist);
		getData();
		selectedPlaylist = null;
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Playlist updated successfully.", "");
		FacesContext.getCurrentInstance().addMessage(null, message);
		// fazer novo get no pesquisa auxiliar
		pesqAux.getListanomesPlaylists();
	}

	public void onRowSelect(SelectEvent event) {
		nomeInicial = selectedPlaylist.getNome();
		pageHandler.setPage("musicas_playlist");
		RequestContext.getCurrentInstance().update(
				Arrays.asList("right-panel", "form-nav:toolbar-nav"));
	}

	public void excluir() {
		playBean.delete(selectedPlaylist);
		getData();
		selectedPlaylist = null;
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Playlist deleted successfully.", "");
		FacesContext.getCurrentInstance().addMessage(null, message);
		// fazer novo get no pesquisa auxiliar
		pesqAux.getListanomesPlaylists();
	}

	public void removeDaPlaylist() {
		playBean.removeMusica(selectedPlaylist, musicaRemover);
		getData();
		musicaRemover = null;
	}

	public void play() {
		url = "http://localhost:8080";
		url += musicaPlay.getFilePath();
	}

	public void updateName() {
		boolean existe = checkPlaylistName(nomeInicial);
		if (!existe) {
			selectedPlaylist.setNome(nomeInicial);
			edit();
		} else {
			nomeInicial = selectedPlaylist.getNome();
			RequestContext.getCurrentInstance().update(
					Arrays.asList("form-edit-playlist"));
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"A Playlist with the same name already exists.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
	}

	public boolean checkPlaylistName(String nome) {
		for (PlaylistEntity p : playlistEntities) {
			if (p.getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}
	
	// ************** Getters & Setters *********************//

	public ArrayList<PlaylistEntity> getPlaylists() {
		return playlistEntities;
	}

	public PlaylistEntity getPlaylist() {
		return playlistEntity;
	}

	public void setPlaylist(PlaylistEntity playlistEntity) {
		this.playlistEntity = playlistEntity;
	}

	public PlaylistEntity getSelectedPlaylist() {
		return selectedPlaylist;
	}

	public void setSelectedPlaylist(PlaylistEntity selectedPlaylist) {
		this.selectedPlaylist = selectedPlaylist;
	}

	public String getDireccao() {
		return direccao;
	}

	public void setDireccao(String direccao) {
		this.direccao = direccao;
	}

	public MusicEntity getMusicaRemover() {
		return musicaRemover;
	}

	public void setMusicaRemover(MusicEntity musicaRemover) {
		this.musicaRemover = musicaRemover;
	}

	public MusicEntity getMusicaPlay() {
		return musicaPlay;
	}

	public void setMusicaPlay(MusicEntity musicaPlay) {
		this.musicaPlay = musicaPlay;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}

	public String getNomeInicial() {
		return nomeInicial;
	}

	public void setNomeInicial(String nomeInicial) {
		this.nomeInicial = nomeInicial;
	}

}
