package pt.aor.paj.resources;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.aor.paj.model.Playlists;
import pt.aor.paj.model.Song;
import pt.aor.paj.model.Songs;
import pt.aor.paj.model.Total;
import pt.aor.paj.service.ConverterCdiBean;
import ar.p4.entities.PlaylistEntity;

@Stateless
@Path("/playlists")
public class PlaylistResource {
	@Inject
	private ConverterCdiBean converterCdiBean;
	private static final Logger log = LoggerFactory.getLogger(PlaylistResource.class);

	// numero de playlists
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/total")
	public Total getPlaylistNumber() {
		log.info("Getting the number of playlists in database.");
		Total totalPlaylists = new Total();
		totalPlaylists.setTotal(converterCdiBean.getAllPlaylists()
				.getPlaylist().size());
		return totalPlaylists;
	}

	// lista de todas as playlists
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Playlists getPlaylists() {
		log.info("Getting the list of playlists in database.");
		// return Playlists
		return converterCdiBean.getAllPlaylists();
	}

	// lista de musicas numa playlist

	@GET
	@Path("/{playlistId}/songs")
	@Produces(MediaType.APPLICATION_XML)
	public Songs getSongsInPlaylist(@PathParam("playlistId") int id) {
		log.info("Getting the songs in playlist with id: "+id);
		PlaylistEntity temp = new PlaylistEntity();
		temp.setId(id);
		return converterCdiBean.getSongsInPlaylist(temp);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/{playlistId}/songs/{songId}")
	public Response removeSong(@PathParam("songId") int songId,
			@PathParam("playlistId") int id) {
		log.info("Removing the song with id: "+songId+"from playlist with id: "+id);
		boolean removed = converterCdiBean.removeSongFromPlaylist(songId, id);
		if (removed)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/{playlistId}/songs/")
	public Response addSong(Song song, @PathParam("playlistId") int id) {
		log.info("Adding song to playlist with id: "+id);
		boolean removed = converterCdiBean.addSongToPlaylist(song, id);
		if (removed)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
}

