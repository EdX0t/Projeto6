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

import pt.aor.paj.model.Playlists;
import pt.aor.paj.model.Song;
import pt.aor.paj.model.Songs;
import pt.aor.paj.service.ConverterCdiBean;
import ar.p4.entities.PlaylistEntity;

@Stateless
@Path("/playlists")
public class PlaylistResource {
	@Inject
	private ConverterCdiBean converterCdiBean;

	// numero de playlists
	@GET
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("/total")
	public String getMessage() {
		String numUsers = String.valueOf(converterCdiBean.getAllPlaylists()
				.getPlaylist().size());
		return numUsers;
	}

	// lista de todas as playlists
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Playlists getPlaylists() {
		// return Playlists
		return converterCdiBean.getAllPlaylists();
	}

	// lista de musicas numa playlist

	@GET
	@Path("/{playlistId}/songs")
	@Produces(MediaType.APPLICATION_XML)
	public Songs getUserPlaylists(@PathParam("playlistId") int id) {
		PlaylistEntity temp = new PlaylistEntity();
		temp.setId(id);
		return converterCdiBean.getSongsInPlaylist(temp);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/{playlistId}/songs/{songId}")
	public Response removeSong(@PathParam("songId") int songId,
			@PathParam("playlistId") int id) {
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
		boolean removed = converterCdiBean.addSongToPlaylist(song, id);
		if (removed)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
}
