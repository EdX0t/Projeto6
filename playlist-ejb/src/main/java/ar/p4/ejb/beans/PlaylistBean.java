package ar.p4.ejb.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.p4.ejb.dao.PlaylistDao;
import ar.p4.entities.MusicEntity;
import ar.p4.entities.PlaylistEntity;
import ar.p4.entities.UserEntity;

@Stateless
public class PlaylistBean implements PlaylistInterface {

	private static final Logger log = LoggerFactory
			.getLogger(PlaylistBean.class);

	@Inject
	PlaylistDao playlistDao;

	@Override
	public void save(PlaylistEntity playlistEntity) {
		log.info("A playlist não existe");
		playlistEntity.setData_criacao(new Date());
		playlistDao.save(playlistEntity);

	}

	@Override
	public void update(PlaylistEntity playlistEntity) {
		// fazer verificacoes de negocio
		if (playlistEntity.getNome() != null) {
			log.info("A playlist seleccionada vai ser actualizada");
			playlistEntity.setTamanho(playlistEntity.getMusicas().size());
			playlistDao.update(playlistEntity);
		}

	}

	@Override
	public void delete(PlaylistEntity playlistEntity) {
		log.info("A playlist seleccionada existe na base de dados e vai ser eliminada");
		playlistDao.delete(playlistEntity.getId(), PlaylistEntity.class);

	}

	@Override
	public List<PlaylistEntity> allPlaylists(UserEntity user) {
		log.info("Procura todas as Playlists de um utilizador");
		return playlistDao.findAllByUser(user);
	}

	@Override
	public List<PlaylistEntity> playlistOrdenadoNome(UserEntity user, String ordem) {
		log.info("Procura todas as Playlists ordenadas por nome");
		return playlistDao.playlistsOrdNome(user, ordem);
	}

	@Override
	public List<PlaylistEntity> playlistOrdenadoData(UserEntity user, String ordem) {
		log.info("Procura todas as Playlists ordenadas por data");
		return playlistDao.playlistsOrdData(user, ordem);
	}

	@Override
	public List<PlaylistEntity> playlistOrdenadoTamanho(UserEntity user, String ordem) {
		log.info("Procura todas as Playlists ordenadas por tamanho");
		return playlistDao.playlistsOrdTamanho(user, ordem);
	}

	@Override
	public boolean adicionaMusica(MusicEntity musicEntity, PlaylistEntity playListNome) {
		boolean existe = false;
		for (MusicEntity m : playListNome.getMusicas()) {
			if (m.equals(musicEntity)) {
				log.info("A musica existe na Playlist");
				existe = true;
				break;
			}
		}
		if (!existe) {
			playListNome.addMusica(musicEntity);
			playListNome.setTamanho(playListNome.getMusicas().size());
			playlistDao.update(playListNome);
			log.info("A musica não existe na Playlist e é adicionada");
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void removeMusica(PlaylistEntity playlistEntity, MusicEntity musicaRemover) {
		playlistEntity.getMusicas().remove(musicaRemover);
		playlistEntity.setTamanho(playlistEntity.getMusicas().size());
		playlistDao.update(playlistEntity);
		log.info("A música escolhida é removida da Playlist");
	}

	@Override
	public List<PlaylistEntity> getAllPlaylists() {
		return playlistDao.findAll();
	}

	@Override
	public PlaylistEntity getPlaylistById(int id) {
		return playlistDao.find(id);
	}

}
