package ar.p4.ejb.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.p4.ejb.dao.MusicDao;
import ar.p4.entities.MusicEntity;
import ar.p4.entities.UserEntity;

@Stateless
public class MusicBean implements MusicInterface{
	
	private static final Logger log = LoggerFactory.getLogger(MusicBean.class);
	
	@Inject
	private MusicDao musicDao;

	@Override
	public void save(MusicEntity musicEntity){
		musicDao.save(musicEntity);
	}

	@Override
	public void update(MusicEntity musicEntity){
		isMusicaComplete(musicEntity);
		log.info("Os dados da música estão completos e vão ser actualizados");
		musicDao.update(musicEntity);
	}

	@Override
	public void delete(MusicEntity musicEntity) {
		musicEntity.setDono(null);
		log.info("Colocou p dono da música a nulo e vai eliminar a música dos registos do utilizador");
		musicDao.update(musicEntity);
	}

	@Override
	public MusicEntity find(int musicaID) {
		return musicDao.find(musicaID);
	}


	@Override
	public List<MusicEntity> findAll() {
		return musicDao.findAll();
	}


	public List<MusicEntity> findAllByUser(UserEntity user) {
		return musicDao.findAllByUser(user);
	}



	private void isMusicaComplete(MusicEntity musicEntity){
		boolean hasError = false;

		if(musicEntity.getTitulo() == null){
			hasError = true;
			log.error("Se o titulo está a nulo dá erro!");
		}

		if (musicEntity.getTitulo() == null || "".equals(musicEntity.getTitulo().trim())){
			hasError = true;
			log.error("Se o titulo está a nulo dá erro!");
		}

		if (hasError){
			throw new IllegalArgumentException("Verificar os elementos introduzidos.");
		}
	}

	//procurar todas as musicas por artista
	public List<MusicEntity> findMusicaByArtista(String nome){
		log.info("Procura as músicas por nome de utilizador");
		return musicDao.findMusicaByArtista(nome);
	}
	//procurar a lista de todos os artistas
	public List<String> findListaArtistas(){
		log.info("Procura a lista com os nomes de todos os artistas ");
		return musicDao.findlistaArtistas();

	}

	//procurar todas as musicas por titulo
	public List<MusicEntity> findMusicaByTitulo(String nome){
		log.info("Procura a lista de musicas com o titulo igual ao introduzido");
		return musicDao.findMusicaByTitulo(nome);
	}
	//procurar a lista de todos os titulos
	public List<String> findListaTitulos(){
		log.info("Procura a lista com os nomes de todos os titulos");
		return musicDao.findListaTitulos();

	}

	//procurar a lista de todos os titulos Por Artista
		public List<String> findListaTitulosPorArtista(String artistaSeleccionado){
			log.info("Procura a lista com os nomes de todos os titulos por determinado artista");
			return musicDao.findListaTitulosArtista(artistaSeleccionado);

		}
	
	
	//procurar todas as musicas por titulo&&artista
	public MusicEntity findMusicaByTituloArtista(String artista,String titulo){
		log.info("Procura a musica com o nomes e o titulo introduzido");
		return musicDao.findMusicaByTituloArtista(artista,titulo);
	}

}
