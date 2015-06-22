package ar.p4.ejb.dao;
import java.util.ArrayList;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ar.p4.entities.Musica;
import ar.p4.entities.Utilizador;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.anyString;
import static org.hamcrest.Matchers.nullValue;



@RunWith(MockitoJUnitRunner.class)
public class MusicaDaoTest {

	@Mock
	EntityManager em;
	
	@Mock
	Query mockedQuery;
	
	@Mock
	Utilizador utilizador;
	
	@InjectMocks
	MusicaDao ejb;
	
	@Test
	public void  findlistaArtistasTemDevolverUmaLista(){
		List<String> listaArtistas;
		final String QUERY = "SELECT DISTINCT d.artista FROM Musica d";
		
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<String>());

        when(em.createQuery(QUERY)).thenReturn(mockedQuery);

        listaArtistas=ejb.findlistaArtistas();
           
        verify(mockedQuery).getResultList();
        verify(em).createQuery(QUERY);
	   
		}
	
	@Test
	public void  findlistaMusicasPorArtistasTemDevolverUmaLista(){
		List<Musica> listaMusicas;
		final String QUERY = "SELECT p FROM Musica p WHERE p.artista like :name";
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<Musica>());
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
        listaMusicas=ejb.findMusicaByArtista("nome");
        verify(mockedQuery).setParameter("name", "nome");
        verify(mockedQuery).getResultList();
        verify(em).createQuery(QUERY);
	   
		}
	
	@Test
	public void  findlistaTitulosTemDevolverUmaListaTitulos(){
		List<String> listaTitulos;
		final String QUERY = "SELECT DISTINCT d.titulo FROM Musica d";
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<String>());
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
        listaTitulos=ejb.findListaTitulos();
        verify(mockedQuery).getResultList();
        verify(em).createQuery(QUERY);
	   
		}
	
	@Test
	public void  findMusicaByTituloTemDevolverTodasAsMusicasComTituloDado(){
		List<Musica> listaMusicas;
		final String QUERY = "SELECT p FROM Musica p WHERE p.titulo like :name";
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<Musica>());
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
        listaMusicas=ejb.findMusicaByTitulo("nome");
        verify(mockedQuery).setParameter("name", "nome");
        verify(mockedQuery).getResultList();
        verify(em).createQuery(QUERY);
	   
		}
	
	@Test
	public void  findlistaTitulosTemDevolverUmaListaTitulosEArtistas(){
		List<String> listaTitulosArtistas;
		final String QUERY = "SELECT DISTINCT d.titulo, d.artista FROM Musica d";
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<String>());
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
        listaTitulosArtistas=ejb.findListaTitulosArtistas();
        verify(mockedQuery).getResultList();
        verify(em).createQuery(QUERY);
	   
		}
	
	@Test
	public void  findMusicaByTituloTemDevolverTodasOsTitulosDeUmArtistaIntroduzido(){
		List<String> listaTitulosArtista;
		final String QUERY = "SELECT DISTINCT d.titulo FROM Musica d WHERE d.artista like :artista";
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<String>());
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
        listaTitulosArtista=ejb.findListaTitulosArtista("nome");
        verify(mockedQuery).setParameter("artista", "nome");
        verify(mockedQuery).getResultList();
        verify(em).createQuery(QUERY);
	   
		}
	
	@Test
	public void  findMusicaByTituloArtistaTemDevolverUmaMusica(){
		Musica musica;
		final String QUERY = "SELECT p FROM Musica p WHERE p.titulo like :titulo AND p.artista like :artista";
		when(mockedQuery.getSingleResult()).thenReturn(new Musica());
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
        musica=ejb.findMusicaByTituloArtista("artista","titulo");
        verify(mockedQuery).setParameter("artista", "artista");
        verify(mockedQuery).setParameter("titulo", "titulo");
        verify(mockedQuery).getSingleResult();
        verify(em).createQuery(QUERY);
	   
		}
	
	@Test
	public void  findAllByUserTemDevolverTodasAsMusicasDeUmUtilizador(){
		List<Musica> listaMusicas;
		final String QUERY = "SELECT p FROM Musica p inner join p.dono s where s.id = :dono";
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<Musica>());
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
       
        when(utilizador.getId()).thenReturn(1);
        
        listaMusicas=ejb.findAllByUser(utilizador);
        verify(mockedQuery).setParameter("dono", 1);
        verify(mockedQuery).getResultList();
        verify(em).createQuery(QUERY);
	   
		}
	
}
