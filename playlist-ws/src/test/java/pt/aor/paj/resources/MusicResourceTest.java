package pt.aor.paj.resources;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBException;

import org.junit.Test;

public class MusicResourceTest {

	private static URI uri = UriBuilder.fromUri("http://localhost:8080/playlist-ws/rest/songs").build();
	
	@Test
	public void getSongsNumber() throws JAXBException{
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri+"/total").request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, response.getStatusInfo());
		client.close();
		
	}
	@Test
	public void getSongs() throws JAXBException{
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri).request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, response.getStatusInfo());
		client.close();
	}
	
	@Test
	public void getSong() throws JAXBException{
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri+"/999").request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, response.getStatusInfo());
		client.close();
	}
	
	@Test
	public void getSongFail() throws JAXBException{
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri+"/989898").request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.NOT_FOUND, response.getStatusInfo());
		client.close();
	}
}
