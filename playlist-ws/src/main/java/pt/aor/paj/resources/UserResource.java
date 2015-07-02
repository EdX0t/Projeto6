package pt.aor.paj.resources;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.aor.paj.model.LoggedUsers;
import pt.aor.paj.model.Playlists;
import pt.aor.paj.model.Songs;
import pt.aor.paj.model.User;
import pt.aor.paj.model.Users;
import pt.aor.paj.service.ConverterCdiBean;
import ar.p4.entities.UserEntity;

@Stateless
@Path("/users")
public class UserResource {
	private static final Logger log = LoggerFactory.getLogger(UserResource.class);

	@Inject
	private ConverterCdiBean converterCdiBean;

	// numero de users

	@GET
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("/total")
	public String getMessage() {
		log.info("Getting the number of application users.");
		String numUsers = String.valueOf(converterCdiBean.getUserList()
				.getUser().size());
		return numUsers;
	}

	// lista de utilizadores
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getUtilizadores() {
		log.info("Getting the list of application users.");
		// return Users
		Users listaUsers = converterCdiBean.getUserList();
		return Response.ok(listaUsers).build();
	}

	// utilizador por id
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getUtilizador(@PathParam("userId") int id) {
		log.info("Getting information for user id: "+id);
		User user = converterCdiBean.findUserById(id);
		if(user==null){
			throw new NotFoundException();
		} 
		return Response.ok(user).build();
	}

	// playlists de um determinado utilizador
	@GET
	@Path("/{userId}/playlists")
	@Produces(MediaType.APPLICATION_XML)
	public Response getUserPlaylists(@PathParam("userId") int id) {
		log.info("Getting the playlists for user id: "+id);
		UserEntity temp = new UserEntity();
		temp.setId(id);
		Playlists playlists = converterCdiBean.getPlaylists(temp);
		return Response.ok(playlists).build();
		
	}

	// musicas de um utilizador
	@GET
	@Path("/{userId}/songs")
	@Produces(MediaType.APPLICATION_XML)
	public Songs getUserMusic(@PathParam("userId") int id) {
		log.info("Getting the songs for user id: "+id);
		UserEntity temp = new UserEntity();
		temp.setId(id);
		return converterCdiBean.getMusic(temp);
	}

	//apagar musica de um utilizador
	@DELETE
	@Path("/{userId}/songs/{songId}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response deleteUserSong(@PathParam("userId") int idUser, @PathParam("songId") int idSong) {
		log.info("Getting the song information for user id: "+idUser);
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
		log.info("Adding the new user to the database");
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
		log.info("Removing from the database the user with id: "+id);
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
		log.info("Updating the password of the user with id: "+id);
		user.setId(id);
		boolean updated = converterCdiBean.updatePassword(user);
		if(updated)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	
	//lista de users logados
	@GET
	@Path("/loggedusers")
	@Produces(MediaType.APPLICATION_XML)
	public LoggedUsers getLoggedUsers(){
		log.info("Getting the list of logged users.");
		return converterCdiBean.getLoggedUsers();
	}
	
	//numero de users logados
	@GET
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("loggedusers/total")
	public String getLoggedNumber() {
		log.info("Getting the number of logged users.");
		String numUsers = String.valueOf(converterCdiBean.getLoggedUsers().getUser().size());
		return numUsers;
	}
}
