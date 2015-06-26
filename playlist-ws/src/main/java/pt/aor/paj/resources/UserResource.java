package pt.aor.paj.resources;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pt.aor.paj.model.Playlists;
import pt.aor.paj.model.Songs;
import pt.aor.paj.model.User;
import pt.aor.paj.model.Users;
import pt.aor.paj.service.ConverterCdiBean;
import ar.p4.entities.UserEntity;

@Stateless
@Path("/users")
public class UserResource {

	@Inject
	private ConverterCdiBean converterCdiBean;

	// numero de users

	@GET
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("/total")
	public String getMessage() {
		String numUsers = String.valueOf(converterCdiBean.getUserList()
				.getUser().size());
		return numUsers;
	}

	// lista de utilizadores
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Users getUtilizadores() {
		// return Users
		return converterCdiBean.getUserList();
	}

	// utilizador por id
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_XML)
	public User getUtilizador(@PathParam("userId") int id) {
		return converterCdiBean.findUserById(id);
	}

	// playlists de um determinado utilizador
	@GET
	@Path("/{userId}/playlists")
	@Produces(MediaType.APPLICATION_XML)
	public Playlists getUserPlaylists(@PathParam("userId") int id) {
		UserEntity temp = new UserEntity();
		temp.setId(id);
		return converterCdiBean.getPlaylists(temp);
	}

	// musicas de um utilizador
	@GET
	@Path("/{userId}/songs")
	@Produces(MediaType.APPLICATION_XML)
	public Songs getUserMusic(@PathParam("userId") int id) {
		UserEntity temp = new UserEntity();
		temp.setId(id);
		return converterCdiBean.getMusic(temp);
	}

	//apagar musica de um utilizador
	@DELETE
	@Path("/{userId}/songs/{songId}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response deleteUserSong(@PathParam("userId") int idUser, @PathParam("songId") int idSong) {
		boolean deleted = converterCdiBean.deleteSongFromUser(idUser, idSong);
		if(deleted)
			return Response.ok().build();
		else
			return Response.notModified().build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addUser(User user) {
		boolean added = converterCdiBean.addUser(user);
		if (added){
			User newUser = converterCdiBean.findUserByEmail(user.getEmail());
			return Response.ok(newUser).build();
			
		} else {
			return Response.notModified().build();
		}
	}

	@DELETE
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response removeUser(@PathParam("userId") int id) {
		boolean removed = converterCdiBean.removeUser(id);
		if(removed)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	
	@PUT
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response changePassword(@PathParam("userId") int id, User user) {
		user.setId(id);
		boolean updated = converterCdiBean.updatePassword(user);
		if(updated)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

}
