package pt.aor.paj.resources;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.junit.Test;

public class PlaylistResourceTest {
	private static URI uri = UriBuilder.fromUri("http://localhost:8080/playlist-ws/rest/playlists").build();
	
	@Test
	public void getPlaylistNumber() {
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri+"/total").request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, response.getStatusInfo());
		client.close();
	}

	@Test
	public void getPlaylists() {
	Client client = ClientBuilder.newClient();
	Response response = client.target(uri).request(MediaType.APPLICATION_XML).get();
	assertEquals(Response.Status.OK, response.getStatusInfo());
	client.close();
	}

	@Test
	public void getSongsInPlaylist() {
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri+"/26/songs").request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, response.getStatusInfo());
		client.close();
	}
	
	@Test
	public void getUserPlaylistsNotFound() {
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri+"266/songs").request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.NOT_FOUND, response.getStatusInfo());
		client.close();
	}
	
}
