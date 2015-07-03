package ar.p4.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.p4.entities.LyricEntity;
import ar.p4.entities.MusicEntity;
import ar.p4.entities.UserEntity;


@Stateless
public class LyricDao extends GenericDao<LyricEntity> {
	
	private static final Logger log = LoggerFactory.getLogger(LyricDao.class);
	
	public LyricDao() {
		super(LyricEntity.class);
	}

	public LyricEntity lyricOfMUsic(UserEntity uti, MusicEntity music){
		TypedQuery <LyricEntity> q;
		if (uti == null) {
			q = em.createNamedQuery(LyricEntity.LYRICS_BY_Null_MUSIC, LyricEntity.class);
			q.setParameter("music",music);
			log.info("Procura da musica original com o id - "+music.getId());
		}
		else {
			q = em.createNamedQuery(LyricEntity.LYRICS_BY_USER_MUSIC, LyricEntity.class);
			q.setParameter("music",music);
			q.setParameter("utilizador",uti);
			log.info("Procura da musica com id -  "+music.getId()+ " - do utilizador com id - " +uti.getId());
		}
		if(q.getResultList().isEmpty()){
			log.info("Procura anterior não tem resultados.");
			return null;
		} else {
			return  q.getResultList().get(0);
		}
	}
	
	public List<LyricEntity> lyricOfUser (UserEntity uti){
		TypedQuery <LyricEntity> q = em.createNamedQuery(LyricEntity.LYRICS_BY_USER,LyricEntity.class );
		q.setParameter("utilizador",uti);
		return q.getResultList();
		
	}
	
}
