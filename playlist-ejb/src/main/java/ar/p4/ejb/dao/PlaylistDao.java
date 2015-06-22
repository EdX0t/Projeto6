package ar.p4.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.p4.entities.Playlist;
import ar.p4.entities.Utilizador;

@Stateless
public class PlaylistDao extends GenericDao<Playlist> {
	
	private static final Logger log = LoggerFactory.getLogger(PlaylistDao.class);

	public PlaylistDao() {
		super(Playlist.class);
	}

	@SuppressWarnings("unchecked")
	public List<Playlist> findAllByUser(Utilizador user) {
		Query q = em.createQuery("from Playlist p where p.dono.id = :userId");
		q.setParameter("userId", new Integer(user.getId()));
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Playlist> playlistsOrdNome(Utilizador user, String sentido) {
		Query q = null;
		if (sentido.equalsIgnoreCase("asc")) {
			log.info("Ordena lista por ordem ascendente de nome");
			q = em.createNamedQuery("PlaylistName.ASC");
		} else if (sentido.equalsIgnoreCase("desc")) {
			log.info("Ordena lista por ordem descendente de nome");
			q = em.createNamedQuery("PlaylistName.DESC");
		}
		q.setParameter("userId", new Integer(user.getId()));
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Playlist> playlistsOrdData(Utilizador user, String sentido) {
		Query q = null;
		if (sentido.equalsIgnoreCase("asc")) {
			log.info("Ordena lista por ordem ascendente de data");
			q = em.createNamedQuery("PlaylistData.ASC");
		} else if (sentido.equalsIgnoreCase("desc")) {
			q = em.createNamedQuery("PlaylistData.DESC");
			log.info("Ordena lista por ordem descendente de data");
		}
		q.setParameter("userId", new Integer(user.getId()));
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Playlist> playlistsOrdTamanho(Utilizador user, String sentido) {
		Query q = null;
		if (sentido.equalsIgnoreCase("asc")) {
			log.info("Ordena lista por ordem ascendente de tamanho");
			q = em.createNamedQuery("PlaylistTamanho.ASC");
		} else if (sentido.equalsIgnoreCase("desc")) {
			log.info("Ordena lista por ordem descendente de tamanho");
			q = em.createNamedQuery("PlaylistTamanho.DESC");
		}
		q.setParameter("userId", new Integer(user.getId()));
		return q.getResultList();
	}
	
	public boolean checkPlaylist(String nomePlaylist){
		Query q = em.createQuery("select p.nome from Playlist p where p.nome= :nomeParam");
		q.setParameter("nomeParam", nomePlaylist);
		try {
		String nomeTemp = (String) q.getSingleResult();
		log.info("Existe playlist com o nome introduzido");
		return true;
		} catch (NoResultException e){
			log.error("Não existe playlist com o nome introduzido");
			return false;
		}
	}
}
