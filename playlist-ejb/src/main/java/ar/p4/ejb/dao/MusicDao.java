package ar.p4.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.p4.entities.MusicEntity;
import ar.p4.entities.UserEntity;

@Stateless
public class MusicDao extends GenericDao<MusicEntity>{

	private static final Logger log = LoggerFactory.getLogger(MusicDao.class);
	
	public MusicDao() {
		super(MusicEntity.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findlistaArtistas(){
		List<String> listaArtistas;
		listaArtistas = em.createQuery("SELECT DISTINCT d.artista FROM MusicEntity d").getResultList();
		return listaArtistas;
	}


	@SuppressWarnings("unchecked")
	public List<MusicEntity> findMusicaByArtista(String nome) {
		List<MusicEntity> listaMusicas;
		Query q=em.createQuery("SELECT p FROM MusicEntity p WHERE p.artista like :name");
		q.setParameter("name",nome);
		listaMusicas=q.getResultList();
		return listaMusicas;
	}

	@SuppressWarnings("unchecked")
	public List<String> findListaTitulos(){
		List<String> listaTitulos;
		listaTitulos = em.createQuery("SELECT DISTINCT d.titulo FROM MusicEntity d").getResultList();
		return listaTitulos;
	}


	@SuppressWarnings("unchecked")
	public List<MusicEntity> findMusicaByTitulo(String nome) {
		List<MusicEntity> listaMusicas;
		Query q=em.createQuery("SELECT p FROM MusicEntity p WHERE p.titulo like :name");
		q.setParameter("name",nome);
		listaMusicas=q.getResultList();
		return listaMusicas;
	}

	@SuppressWarnings("unchecked")
	public List<String> findListaTitulosArtistas(){
		List<String> listaTitulosArtistas;
		listaTitulosArtistas = em.createQuery("SELECT DISTINCT d.titulo, d.artista FROM MusicEntity d").getResultList();
		return listaTitulosArtistas;
	}

	@SuppressWarnings("unchecked")
	public List<String> findListaTitulosArtista(String artista){
		List<String> listaTitulosArtista;
		Query q = em.createQuery("SELECT DISTINCT d.titulo FROM MusicEntity d WHERE d.artista like :artista");
		q.setParameter("artista",artista);
		listaTitulosArtista=q.getResultList();
		return listaTitulosArtista;
	}
	
	public MusicEntity findMusicaByTituloArtista(String artista, String titulo) {
		MusicEntity musicEntity;
		try{
		Query q=em.createQuery("SELECT p FROM MusicEntity p WHERE p.titulo like :titulo AND p.artista like :artista");
		q.setParameter("titulo",titulo);
		q.setParameter("artista",artista);
		musicEntity=(MusicEntity) q.getSingleResult();
		log.info("Retorna a musica com titulo e artista seleccionado");
		}catch(NoResultException e){
			log.error("Não existe a musica com titulo e artista seleccionado");
			return null;
		}
		return musicEntity;
	}
	
	@SuppressWarnings("unchecked")
	public List<MusicEntity> findAllByUser(UserEntity user) {
		List<MusicEntity> listaMusicas;
		int dono=user.getId();
		Query q=em.createQuery("SELECT p FROM MusicEntity p inner join p.dono s where s.id = :dono");
		q.setParameter("dono",dono);
		listaMusicas=q.getResultList();
		return listaMusicas;
	}

}
