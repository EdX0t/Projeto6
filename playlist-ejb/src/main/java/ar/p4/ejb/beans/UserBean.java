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

import ar.p4.ejb.dao.MusicaDao;
import ar.p4.ejb.dao.UserDao;
import ar.p4.entities.Musica;
import ar.p4.entities.Utilizador;

@Stateless
public class UserBean implements UserInterface {
	private static final Logger log = LoggerFactory
			.getLogger(UserBean.class);
	private static final long serialVersionUID = -4901922974285276339L;
	@Inject
	UserDao userDao;
	@Inject
	MusicaDao musicaDao;
	private ArrayList<Utilizador> utilizadores;

	@Override
	public void update(Utilizador user) {
		userDao.update(user);
	}

	@Override
	public void updatePassword(Utilizador user) {
		try {
			log.info("A password introduzida foi "+user.getPassword());
			log.info("A password foi encriptada para: " + encriptarPass(user.getPassword()));
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
	public void delete(Utilizador user) {

		// definir dono das musicas como servidor
		List<Musica> lista = musicaDao.findAllByUser(user);
		log.info("Vai alterar todas as musicas introduzidas pelo utilizador no campo dono ");
		for (Musica m : lista) {
			log.info("A música "+ m.getTitulo()+ "vai ficar com o dono a null");
			m.setDono(null);
			musicaDao.update(m);
		}
		userDao.delete(user.getId(), Utilizador.class);
		log.info("Apaga o utilizador");
	}

	@Override
	public Utilizador login(Utilizador user) throws NoResultException {
		Utilizador activo = null;
		try {
			log.info("A password introduzida foi "+user.getPassword());
			log.info("A password foi encriptada para: " + encriptarPass(user.getPassword()));
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
	public boolean save(Utilizador user) {
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
	public Utilizador findById(int id) {
		return userDao.find(id);
	}

	public ArrayList<Utilizador> getUtilizadores() {
		utilizadores = (ArrayList<Utilizador>) userDao.findAll();
		return utilizadores;
	}

}
