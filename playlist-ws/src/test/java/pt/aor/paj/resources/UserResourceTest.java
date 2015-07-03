package pt.aor.paj.resources;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.junit.Test;

public class UserResourceTest {
private static URI uri = UriBuilder.fromUri("http://localhost:8080/playlist-ws/rest/users/").build();
	
	@Test
	public void getUsersNumber() {
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri+"total").request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, response.getStatusInfo());
		client.close();
	}

	@Test
	public void getUsers() {
	Client client = ClientBuilder.newClient();
	Response response = client.target(uri).request(MediaType.APPLICATION_XML).get();
	assertEquals(Response.Status.OK, response.getStatusInfo());
	client.close();
	}

	@Test
	public void getUserInfo() {
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri+"4").request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, response.getStatusInfo());
		client.close();
	}
	@Test
	public void getUserInfoFail() {
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri+"999").request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.NOT_FOUND, response.getStatusInfo());
		client.close();
	}
	
	@Test
	public void getUserMusic() {
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri+"4/songs").request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, response.getStatusInfo());
		client.close();
	}
	@Test
	public void getUserMusicFail() {
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri+"999/songs").request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.NOT_FOUND, response.getStatusInfo());
		client.close();
	}
	
	@Test
	public void getUserPlaylists() {
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri+"4/playlists").request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, response.getStatusInfo());
		client.close();
	}
	@Test
	public void getUserPlaylistsFail() {
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri+"999/playlists").request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.NOT_FOUND, response.getStatusInfo());
		client.close();
	}
}
