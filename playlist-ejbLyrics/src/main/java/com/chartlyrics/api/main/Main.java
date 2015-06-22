package com.chartlyrics.api.main;

import java.rmi.RemoteException;

import com.chartlyrics.api.Apiv1SoapProxy;
import com.chartlyrics.api.GetLyricResult;

public class Main {

	public static void main(String[] args) {
		Apiv1SoapProxy soap = new Apiv1SoapProxy();
		String artist = "eric prydz";
		String song = "call on me";
		GetLyricResult result = null;
		boolean search = false;

		//Ir Buscar a lyric de uma musica por artista e titulo
		while(!search){
			try {
				result = soap.searchLyricDirect(artist, song);
				search = true;

			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				//				e.printStackTrace();
				System.out.println("Connecting...");
			}

		}

		System.out.println("Lyric: \n"+result.getLyric());



	}

}
