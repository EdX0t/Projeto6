package pt.aor.paj.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.aor.paj.resources.model.Users;
import ar.p4.ejb.beans.PlaylistInterface;
import ar.p4.ejb.beans.UserInterface;
import ar.p4.entities.Playlist;
import ar.p4.entities.Utilizador;

@Stateless
@Path("/users")
public class UtilizadorResource {

	@Inject
	private UserInterface userBean;
	@Inject
	private PlaylistInterface playbean;

	// numero de users

	// @GET
	// @Produces({MediaType.TEXT_HTML, MediaType.TEXT_PLAIN})
	// public String getMessage() {
	// String numUsers = String.valueOf(ubean.numUsers());
	// return numUsers;
	// }

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Users getUtilizadores() {
		ArrayList<Utilizador> utilizadores = userBean.getUtilizadores();
		
		// convert UserEntities to Users
		
		// return Users
		return null;
	}

	//
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_XML)
	public Utilizador getUtilizador(@PathParam("userId") int id) {
		return userBean.findById(id);
	}

	//
	// public long numLoggedUsers(){
	// return 0;
	// }
	//
	@GET
	@Path("/{userId}/playlists")
	@Produces(MediaType.APPLICATION_XML)
	public List<Playlist> getUserPlaylists(@PathParam("userId") int id) {
		Utilizador temp = new Utilizador();
		temp.setId(id);
		return playbean.allPlaylists(temp);
	}
	// public List<Musica> getUserMusic(int id){
	// return null;
	// }
	//
	// public void addUser(String nome, String email, String password, String
	// data_nascimento){
	//
	// }
	//
	// public void removeUser(int id){
	//
	// }
	//
	// public void changePassword(int userId, String newPassword){
	//
	// }
	// public void deleteMusica(int userId, Long musicaId){
	//
	// }
}
