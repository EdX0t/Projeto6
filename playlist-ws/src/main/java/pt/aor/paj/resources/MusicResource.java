package pt.aor.paj.resources;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.aor.paj.model.Song;
import pt.aor.paj.model.Songs;
import pt.aor.paj.model.Total;
import pt.aor.paj.service.ConverterCdiBean;

@Stateless
@Path("/songs")
public class MusicResource {
	@Inject private ConverterCdiBean converterCdiBean;
	private static final Logger log = LoggerFactory.getLogger(MusicResource.class);
	
	@GET
	@Produces({ MediaType.APPLICATION_XML })
	@Path("/total")
	public Total getSongsNumber() {
		log.info("Getting the number of songs in database.");
		Total totalSongs = new Total();
		totalSongs.setTotal(converterCdiBean.getAllSongs().getSong().size());
		return totalSongs;
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Songs getSongs() {
		log.info("Getting the list of songs in database.");
		// return Users
		return converterCdiBean.getAllSongs();
	}

	@GET
	@Path("/{songId}")
	@Produces(MediaType.APPLICATION_XML)
	public Song getSong(@PathParam("songId") int id) {
		log.info("Getting the information for song id: "+id);
		return converterCdiBean.findMusicById(id);
	}
}
