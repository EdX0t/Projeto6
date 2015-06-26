package ar.p4.ejb.webserviceRest;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;


public class LyricsREST {

	public static void main(String[] args) {
		
		String song="where the streets have no name";
		String artist="ola";
		int idLyric=-1;
		String lyricCheckSum="";
		ResteasyClient cliente= new ResteasyClientBuilder().build();
		List <SearchLyricResult> listResult=null;
		
		while(true){
			try{
				ResteasyWebTarget target=cliente.target("http://api.chartlyrics.com/apiv1.asmx/SearchLyric?artist="+artist+"&song="+song);
				Response response= target.request(MediaType.APPLICATION_XML).get();
				listResult= response.readEntity(ArrayOfSearchLyricResult.class).getSearchLyricResult();
				break;
			} catch(Exception e){
				//System.out.println("mensagem" + e.getMessage());
				System.out.println(1);
			}
		}
		
		if(listResult.get(0).getArtist()==null && listResult.get(0).getSong()==null) {
			System.out.println("Não encontra!!!");
			return;
		}
		try{
			for(SearchLyricResult result:listResult ){
				if(result.getSong().equalsIgnoreCase(song)){
					idLyric=result.getLyricId();
					lyricCheckSum=result.getLyricChecksum();
					System.out.println(idLyric);
					break;
				}
			}
			if(idLyric == -1){
				return;
			}
		} catch (Exception e1){
			System.out.println(2);
		}
		
		String lyric="";
		while(true){ 
			try{
				ResteasyWebTarget target1=cliente.target("http://api.chartlyrics.com/apiv1.asmx/GetLyric?lyricId="+idLyric+"&lyricCheckSum="+lyricCheckSum);
				Response response1= target1.request(MediaType.APPLICATION_XML).get();
				lyric= response1.readEntity(GetLyricResult.class).getLyric();
				break;
			} catch(Exception e){
				//e.printStackTrace();
				System.out.println(3);
			}
		}
		
		System.out.println(lyric);
	}


}
