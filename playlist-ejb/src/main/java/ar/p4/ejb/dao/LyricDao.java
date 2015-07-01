package ar.p4.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import ar.p4.entities.LyricEntity;
import ar.p4.entities.Musica;
import ar.p4.entities.Utilizador;

@Stateless
public class LyricDao extends GenericDao<LyricEntity> {

	public LyricDao() {
		super(LyricEntity.class);
	}

	public LyricEntity lyricOfMUsic(Utilizador uti, Musica music){
		TypedQuery <LyricEntity> q;
		if (uti == null) {
			q = em.createNamedQuery(LyricEntity.LYRICS_BY_Null_MUSIC, LyricEntity.class);
			q.setParameter("music",music);
		}
		else {
			q = em.createNamedQuery(LyricEntity.LYRICS_BY_USER_MUSIC, LyricEntity.class);
			q.setParameter("music",music);
			q.setParameter("utilizador",uti);
		}
		if(q.getResultList().isEmpty()){
			return null;
		} else {
			return  q.getResultList().get(0);
		}
	}
	
	
	
	


}
