package ar.p4.ejb.beans;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.p4.ejb.dao.LyricDao;
import ar.p4.ejb.dao.MusicDao;
import ar.p4.ejb.dao.UserDao;
import ar.p4.entities.LyricEntity;
import ar.p4.entities.MusicEntity;
import ar.p4.entities.UserEntity;

@Stateless
public class UserBean implements UserInterface {
	
	private static final Logger log = LoggerFactory.getLogger(UserBean.class);
	
	@Inject
	private UserDao userDao;
	@Inject
	private MusicDao musicDao;
	@Inject
	private LyricDao lyricDao;
	
	private ArrayList<UserEntity> utilizadores;

	@Override
	public void update(UserEntity user) {
		userDao.update(user);
	}

	@Override
	public void updatePassword(UserEntity user) {
		try {
			log.info("A password introduzida foi " + user.getPassword());
			log.info("A password foi encriptada para: "
					+ encriptarPass(user.getPassword()));
			user.setPassword(encriptarPass(user.getPassword()));
			userDao.update(user);
			log.info("A password é actualizada");
		} catch (NoSuchAlgorithmException e) {
			log.error("Erro na encriptacao da password");
		} catch (UnsupportedEncodingException e) {
			log.error("Erro na encriptacao da password");
		}

	}

	@Override
	public void delete(UserEntity user) {
		
		//lyricas do utilizador
		List <LyricEntity> listLyric= lyricDao.lyricOfUser(user);
		log.info("Vai apagar todas as lyricas associadas ao utilizador");
		for(LyricEntity l: listLyric){
			log.info("A lyric com o ID "+l.getId()+ " vai ser apagada");
			lyricDao.delete(l.getId(), LyricEntity.class);
		}
		
		// definir dono das musicas como servidor
		List<MusicEntity> lista = musicDao.findAllByUser(user);
		log.info("Vai alterar todas as musicas introduzidas pelo utilizador no campo dono ");

		for (MusicEntity m : lista) {
			log.info("A música "+ m.getTitulo()+ "vai ficar com o dono a null");

			m.setDono(null);
			musicDao.update(m);
		}
		userDao.delete(user.getId(), UserEntity.class);
		log.info("Apaga o utilizador");
	}

	@Override
	public UserEntity login(UserEntity user) throws NoResultException {
		UserEntity activo = null;
		try {
			log.info("A password introduzida foi " + user.getPassword());
			log.info("A password foi encriptada para: "
					+ encriptarPass(user.getPassword()));
			user.setPassword(encriptarPass(user.getPassword()));
			activo = userDao.login(user);
		} catch (NoSuchAlgorithmException e) {
			log.error("Erro na encriptacao da password");
		} catch (UnsupportedEncodingException e) {
			log.error("Erro na encriptacao da password");
		}
		return activo;
	}

	public String encriptarPass(String pass) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {

		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(pass.getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();

		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}

		String senha = hexString.toString();
		return senha;

	}

	@Override
	public boolean save(UserEntity user) {
		try {
			String pass = encriptarPass(user.getPassword());
			user.setPassword(pass);
			if (!userDao.checkEmail(user.getMail())) {
				log.info("Verifica se o email introduzido não existe");
				userDao.save(user);
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			log.error("Erro na encriptacao da password");
		} catch (UnsupportedEncodingException e) {
			log.error("Erro na encriptacao da password");
		}
		return false;
	}

	@Override
	public int numUsers() {
		return userDao.findAll().size();
	}

	@Override
	public UserEntity findById(int id) {
		return userDao.find(id);
	}

	public ArrayList<UserEntity> getUtilizadores() {
		utilizadores = (ArrayList<UserEntity>) userDao.findAll();
		return utilizadores;
	}

	@Override
	public UserEntity findByEmail(String email) {
		return userDao.findByEmail(email);
	}

}
