package ar.p4.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.p4.entities.UserEntity;

@Stateless
public class UserDao extends GenericDao<UserEntity> {

	private static final Logger log = LoggerFactory.getLogger(UserDao.class);

	public UserDao() {
		super(UserEntity.class);
	}


	public UserEntity login(UserEntity u) {
	//recebe user temp e faz query para tentar encontra-lo
		UserEntity user = null;
		try {
		Query q = em.createQuery("select u from UserEntity u where u.mail=:mailparam and u.password =:passparam");
		q.setParameter("mailparam", u.getMail());
		q.setParameter("passparam", u.getPassword());
		user = (UserEntity) q.getSingleResult();
		log.info("O utilizador existe");
		} catch (NoResultException e){
			log.error("O utilizador não existe");
			return null;
		}
		return user;
	}
	public boolean checkEmail(String email) {
	
		Query q = em.createQuery("select u.mail from UserEntity u where u.mail= :mailParam");
		q.setParameter("mailParam", email);
		try {
		String emailTemp = (String) q.getSingleResult();
		log.error("O mail existe");
		return true;
		} catch (NoResultException e){
			log.info("O mail não existe");
			return false;
		}
		
	}

	public UserEntity findByEmail(String email) {
		Query q = em.createQuery("from UserEntity u where u.mail= :mailParam");
		q.setParameter("mailParam", email);
		try {
		UserEntity user = (UserEntity) q.getSingleResult();
		return user;
		} catch (NoResultException e){
			log.info("Não existe nenhum user com este email.");
		}
		return null;
	}
	
	}
