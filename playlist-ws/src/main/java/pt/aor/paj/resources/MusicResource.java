package pt.aor.paj.resources;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.aor.paj.model.Song;
import pt.aor.paj.model.Songs;
import pt.aor.paj.service.ConverterCdiBean;

@Stateless
@Path("/songs")
public class MusicResource {
	@Inject private ConverterCdiBean converterCdiBean;
	
	
	@GET
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("/total")
	public String getMessage() {
		String numUsers = String.valueOf(converterCdiBean.getAllSongs().getSong().size());
		return numUsers;
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Songs getSongs() {
		// return Users
		return converterCdiBean.getAllSongs();
	}

	@GET
	@Path("/{songId}")
	@Produces(MediaType.APPLICATION_XML)
	public Song getSong(@PathParam("songId") int id) {
		return converterCdiBean.findMusicById(id);
	}
}
