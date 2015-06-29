package ar.p4.ejb.dao;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ar.p4.entities.LyricEntity;
import ar.p4.entities.Musica;
import ar.p4.entities.Utilizador;

public class LyricDao extends GenericDao<LyricEntity> {

	public LyricDao() {
		super(LyricEntity.class);
	}

	public LyricEntity lyricOfMUsic(Utilizador uti, Musica music){
		TypedQuery<LyricEntity> q = em.createNamedQuery(LyricEntity.LYRICS_BY_USER_MUSIC, LyricEntity.class);
		q.setParameter("utilizador",uti);
		q.setParameter("music",music);
		if(q.getResultList().isEmpty()){
			return null;
		} else {
			return q.getResultList().get(0);
		}
	}


}
