package ar.p4.ejb.webserviceRest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class LyricsREST {

	public static void main(String[] args) {

		while(true){
			try{
				String song="when the streets have no name";
				String artist="U2";
				ResteasyClient cliente= new ResteasyClientBuilder().build();
				ResteasyWebTarget target=cliente.target("http://api.chartlyrics.com/apiv1.asmx/SearchLyricDirect?artist="+artist+"&song="+song);
				Response response= target.request(MediaType.APPLICATION_XML).get();
				String lyrics= response.readEntity(GetLyricResult.class).getLyric();
				System.out.println(lyrics);
				return;
			} catch(Exception e){

			}
		}
	}


}
