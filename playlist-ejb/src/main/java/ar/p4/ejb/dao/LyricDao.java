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
		TypedQuery<LyricEntity> q;
		
		if (uti == null) {
			q = em.createQuery("from LyricEntity l where l.utilizador is NUll and "
					+ "l.music = :music", LyricEntity.class);
			q.setParameter("music",music);
		}
		else {
			q = em.createQuery("from LyricEntity l where l.utilizador = :utilizador and "
					+ "l.music = :music", LyricEntity.class);
			q.setParameter("music",music);
			q.setParameter("utilizador",uti);
		}
		if(q.getResultList().isEmpty()){
			return null;
		} else {
			return q.getResultList().get(0);
		}
	}


}
