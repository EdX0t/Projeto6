package ar.p4.ejb.webserviceSOAP;



import com.chartlyrics.api.SOAP.Apiv1;
import com.chartlyrics.api.SOAP.Apiv1Soap;
import com.chartlyrics.api.SOAP.ArrayOfSearchLyricResult;
import com.chartlyrics.api.SOAP.GetLyricResult;
import com.chartlyrics.api.SOAP.SearchLyricResult;

public class Main {

	public static void main(String[] args) {
		int idLyric=-1;
		String lyricCheckSum="";
		Apiv1 api = new Apiv1();
		Apiv1Soap soap =api.getApiv1Soap();
		String artist = "ola";
		String song = "where the streets have no name";
		ArrayOfSearchLyricResult arrayResult = null;
		boolean search = false;

		//Ir Buscar a lyric de uma musica por artista e titulo
		while(!search){
			try {
				arrayResult = soap.searchLyric(artist, song);
				System.out.println("Lyric1: \n"+arrayResult.getSearchLyricResult());
				if(arrayResult.getSearchLyricResult().get(0) == null) {
					System.out.println("Não encontra!!!");
					return;
				}
				search = true;
			} catch (Exception e) {
				//				e.printStackTrace();
				System.out.println("Connecting...");
			}

		}

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
		while(true){
			try{
				GetLyricResult result = soap.getLyric(idLyric, lyricCheckSum);
				System.out.println("Lyric: \n"+result.getLyric());
				break;
			} catch (Exception e){
				System.out.println("não fizeste nada!!!");
			}
		}
	}

}
