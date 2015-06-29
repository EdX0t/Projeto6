package ar.p4.ejb.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.chartlyrics.api.SOAP.Apiv1;
import com.chartlyrics.api.SOAP.Apiv1Soap;
import com.chartlyrics.api.SOAP.ArrayOfSearchLyricResult;
import com.chartlyrics.api.SOAP.GetLyricResult;
import com.chartlyrics.api.SOAP.SearchLyricResult;


@Stateless
public class LyricSOAPorREST {
	

	public  String lyricOfMusic(String artist, String song){
		String lyric="";
		lyric=lyricSOAP(artist,song);
		
		if(lyric!=null){
			return lyric;
		}else {
			return lyricREST (artist,song);
		}	
	}

	private static String lyricSOAP(String artist, String song) {
		
		Apiv1 api = new Apiv1();
		Apiv1Soap soap =api.getApiv1Soap();
		ArrayOfSearchLyricResult arrayResult = null;
		int contador = 0;
		int maxnum=30;

		while(contador<maxnum){
			try {
				arrayResult = soap.searchLyric(artist, song);
				System.out.println("Lyric1: \n"+arrayResult.getSearchLyricResult());
				if(arrayResult.getSearchLyricResult().get(0) == null) {
					System.out.println("Não encontra!!!");
					return null;
				}
				
			} catch (Exception e) {
				//				e.printStackTrace();
				System.out.println("Connecting...");
			}
			contador++;
		}
		if (contador==maxnum){
			return null;
		}
		
		int idLyric=-1;
		String lyricCheckSum="";
		try{
			for(SearchLyricResult result:arrayResult.getSearchLyricResult() ){
				System.out.println(result.getSong());
				if(result.getSong().equalsIgnoreCase(song)){
					idLyric=result.getLyricId();
					lyricCheckSum=result.getLyricChecksum();
					System.out.println("ID DA LIRICA"+idLyric);
					break;
				}
			}
		} catch (Exception e1){

		}
		contador = 0;
		while(contador<maxnum){
			try{
				GetLyricResult result = soap.getLyric(idLyric, lyricCheckSum);
				System.out.println("Lyric: \n"+result.getLyric());
				return result.getLyric();
			} catch (Exception e){
				System.out.println("não fizeste nada!!!");
			}
		}
		return null;
		
	}

	private static String lyricREST(String artist, String song)  {

		int idLyric=-1;
		String lyricCheckSum="";
		ResteasyClient cliente= new ResteasyClientBuilder().build();
		List <SearchLyricResult> listResult=null;
		int contador = 0;
		int maxnum=30;

		while(contador<maxnum){
			try{
				ResteasyWebTarget target=cliente.target("http://api.chartlyrics.com/apiv1.asmx/SearchLyric?artist="+artist+"&song="+song);
				Response response= target.request(MediaType.APPLICATION_XML).get();
				listResult= response.readEntity(ArrayOfSearchLyricResult.class).getSearchLyricResult();
				if(listResult.get(0).getArtist()==null && listResult.get(0).getSong()==null) {
					System.out.println("Não encontra!!!");
					return null;
				}
				break;
			} catch(Exception e){
				//System.out.println("mensagem" + e.getMessage());
				System.out.println(1);
			}
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
				return null;
			}
		} catch (Exception e1){
			System.out.println(2);
		}

		String lyric="";
		contador = 0;
		while(contador<maxnum){ 
			try{
				ResteasyWebTarget target1=cliente.target("http://api.chartlyrics.com/apiv1.asmx/GetLyric?lyricId="+idLyric+"&lyricCheckSum="+lyricCheckSum);
				Response response1= target1.request(MediaType.APPLICATION_XML).get();
				lyric= response1.readEntity(GetLyricResult.class).getLyric();
				return lyric;
			} catch(Exception e){
				//e.printStackTrace();
				System.out.println(3);
			}
		}

		return null;
	}

}
