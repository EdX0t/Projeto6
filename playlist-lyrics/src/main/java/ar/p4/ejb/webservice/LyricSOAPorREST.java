package ar.p4.ejb.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.p4.ejb.webserviceRest.ArrayOfSearchLyricResult1;
import ar.p4.ejb.webserviceRest.GetLyricResult1;
import ar.p4.ejb.webserviceRest.SearchLyricResult1;
import ar.p4.ejb.webserviceRestWikia.LyricsResult;

import com.chartlyrics.api.SOAP.Apiv1;
import com.chartlyrics.api.SOAP.Apiv1Soap;
import com.chartlyrics.api.SOAP.ArrayOfSearchLyricResult;
import com.chartlyrics.api.SOAP.GetLyricResult;
import com.chartlyrics.api.SOAP.SearchLyricResult;


@Stateless
public class LyricSOAPorREST {
	
	private static final Logger log = LoggerFactory.getLogger(LyricSOAPorREST.class);

	public  String lyricOfMusic(String artist, String song){
		String lyric;
		try {
			lyric=lyricSOAP(artist,song);
			if(lyric!=null)return lyric;
		}
		catch(Exception e) {
			log.error("Erro no resultado do SOAP---"+e.getMessage());
		}
		
		lyric=lyricRESTApi (artist,song);
		if(lyric!=null) return lyric;

		lyric=lyricRESTWiki (artist,song);
		if(lyric!=null)	return lyric;

		return null;
	}


	private static String lyricSOAP(String artist, String song) {

		Apiv1 api = new Apiv1();
		Apiv1Soap soap = api.getApiv1Soap();
		ArrayOfSearchLyricResult arrayResult = null;
		int contador = 0;
		int maxnum=2;

		while(contador<maxnum){
			try {
				arrayResult = soap.searchLyric(artist, song);
				if(arrayResult.getSearchLyricResult().get(0) == null) {
					return null;
				}
				break;
			} catch (Exception e) {
				log.error("Erro na conexão no searchLyric do SOAP---"+e.getMessage());
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					log.error("Erro na primeira thread do SOAP---"+e1.getMessage());
				}
			}
			contador++;
		}
		if (contador==maxnum){
			return null;
		}

		int idLyric=-1;
		String lyricCheckSum="";

		for(SearchLyricResult result:arrayResult.getSearchLyricResult() ){
			if(result.getSong().equalsIgnoreCase(song)){
				idLyric=result.getLyricId();
				lyricCheckSum=result.getLyricChecksum();
				break;
			}
		}
		contador = 0;
		while(contador<maxnum){
			try{
				GetLyricResult result = soap.getLyric(idLyric, lyricCheckSum);
				
				if(result.getLyric().equalsIgnoreCase("")){
					return null;
				} else{
					return result.getLyric();
				}
			} catch (Exception e){
				log.error("Erro na conexão do getLyric no SOAP---"+e.getMessage());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e2) {
					log.error("Erro na segunda thread do SOAP---"+e2.getMessage());
				}
			}
			contador++;
		}
		return null;
	}

	private static String lyricRESTApi(String artist, String song)  {

		int idLyric=-1;
		String lyricCheckSum="";
		ResteasyClient cliente= new ResteasyClientBuilder().build();
		List <SearchLyricResult1> listResult=null;
		int contador = 0;
		int maxnum=3;

		while(contador<maxnum){
			try{
				ResteasyWebTarget target=cliente.target("http://api.chartlyrics.com/apiv1.asmx/SearchLyric?artist="+artist+"&song="+song);
				Response response= target.request(MediaType.APPLICATION_XML).get();
				listResult= response.readEntity(ArrayOfSearchLyricResult1.class).getSearchLyricResult();
				if(listResult.get(0).getArtist()==null && listResult.get(0).getSong()==null) {
					return null;
				}
				break;
			} catch(Exception e){
				log.error("Erro na conexão com RestApi - SearchLyric: "+e.getMessage());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					log.error("Erro no primeiro thread do RestAPi---"+e1.getMessage());
				}
			}
			contador++;
		}
		
		if (contador==maxnum){
			return null;
		}

		for(SearchLyricResult1 result:listResult ){
			if(result.getSong().equalsIgnoreCase(song)){
				idLyric=result.getLyricId();
				lyricCheckSum=result.getLyricChecksum();
				break;
			}
		}
		if(idLyric == -1){
			return null;
		}

		String lyric="";
		contador = 0;
		while(contador<maxnum){ 
			try{
				ResteasyWebTarget target1=cliente.target("http://api.chartlyrics.com/apiv1.asmx/GetLyric?lyricId="+idLyric+"&lyricCheckSum="+lyricCheckSum);
				Response response1= target1.request(MediaType.APPLICATION_XML).get();
				lyric= response1.readEntity(GetLyricResult1.class).getLyric();
				if(lyric.equalsIgnoreCase("")){
					return null;
				} else{
					return lyric;
				}
			} catch(Exception e){
				log.error("Erro na conexão com RestApi - GetLyric: "+e.getMessage());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e2) {
					log.error("Erro no segundo thread do RestAPi---"+e2.getMessage());
				}
			}
			contador++;
		}

		return null;
	}

	private static String lyricRESTWiki(String artist, String song)  {
		String lyric="";
		ResteasyClient cliente= new ResteasyClientBuilder().build();
		int contador = 0;
		int maxnum=2;

		while(contador<maxnum){
			try{
				ResteasyWebTarget target=cliente.target("http://lyrics.wikia.com/api.php?artist="+artist+"&song="+song+"&fmt=xml");
				Response response= target.request(MediaType.APPLICATION_XML).get();
				lyric= response.readEntity(LyricsResult.class).getLyric();
				
				if(lyric.equalsIgnoreCase("[...]") || lyric.equalsIgnoreCase("Not found")){
					return null;
				} else{
					return lyric;
				}
				

			}catch (Exception e){
				log.error("Erro na conexão com Restwiki: "+e.getMessage());
			}
			contador++;	
		}
		return null;
	}
}