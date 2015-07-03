package ar.p4.ejb.dao;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ar.p4.entities.MusicEntity;
import ar.p4.entities.UserEntity;



@RunWith(MockitoJUnitRunner.class)
public class MusicaDaoTest {

	@Mock
	EntityManager em;
	
	@Mock
	Query mockedQuery;
	
	@Mock
	UserEntity userEntity;
	
	@InjectMocks
	MusicDao ejb;
	
	@Test
	public void  findlistaArtistasTemDevolverUmaLista(){
		List<String> listaArtistas;
		final String QUERY = "SELECT DISTINCT d.artista FROM MusicEntity d";
		
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<String>());

        when(em.createQuery(QUERY)).thenReturn(mockedQuery);

        listaArtistas=ejb.findlistaArtistas();
           
        verify(mockedQuery).getResultList();
        verify(em).createQuery(QUERY);
	   
		}
	
	@Test
	public void  findlistaMusicasPorArtistasTemDevolverUmaLista(){
		List<MusicEntity> listaMusicas;
		final String QUERY = "SELECT p FROM MusicEntity p WHERE p.artista like :name";
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<MusicEntity>());
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
        listaMusicas=ejb.findMusicaByArtista("nome");
        verify(mockedQuery).setParameter("name", "nome");
        verify(mockedQuery).getResultList();
        verify(em).createQuery(QUERY);
	   
		}
	
	@Test
	public void  findlistaTitulosTemDevolverUmaListaTitulos(){
		List<String> listaTitulos;
		final String QUERY = "SELECT DISTINCT d.titulo FROM MusicEntity d";
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<String>());
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
        listaTitulos=ejb.findListaTitulos();
        verify(mockedQuery).getResultList();
        verify(em).createQuery(QUERY);
	   
		}
	
	@Test
	public void  findMusicaByTituloTemDevolverTodasAsMusicasComTituloDado(){
		List<MusicEntity> listaMusicas;
		final String QUERY = "SELECT p FROM MusicEntity p WHERE p.titulo like :name";
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<MusicEntity>());
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
        listaMusicas=ejb.findMusicaByTitulo("nome");
        verify(mockedQuery).setParameter("name", "nome");
        verify(mockedQuery).getResultList();
        verify(em).createQuery(QUERY);
	   
		}
	
	@Test
	public void  findlistaTitulosTemDevolverUmaListaTitulosEArtistas(){
		List<String> listaTitulosArtistas;
		final String QUERY = "SELECT DISTINCT d.titulo, d.artista FROM MusicEntity d";
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<String>());
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
        listaTitulosArtistas=ejb.findListaTitulosArtistas();
        verify(mockedQuery).getResultList();
        verify(em).createQuery(QUERY);
	   
		}
	
	@Test
	public void  findMusicaByTituloTemDevolverTodasOsTitulosDeUmArtistaIntroduzido(){
		List<String> listaTitulosArtista;
		final String QUERY = "SELECT DISTINCT d.titulo FROM MusicEntity d WHERE d.artista like :artista";
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<String>());
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
        listaTitulosArtista=ejb.findListaTitulosArtista("nome");
        verify(mockedQuery).setParameter("artista", "nome");
        verify(mockedQuery).getResultList();
        verify(em).createQuery(QUERY);
	   
		}
	
	@Test
	public void  findMusicaByTituloArtistaTemDevolverUmaMusica(){
		MusicEntity musicEntity;
		final String QUERY = "SELECT p FROM MusicEntity p WHERE p.titulo like :titulo AND p.artista like :artista";
		when(mockedQuery.getSingleResult()).thenReturn(new MusicEntity());
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
        musicEntity=ejb.findMusicaByTituloArtista("artista","titulo");
        verify(mockedQuery).setParameter("artista", "artista");
        verify(mockedQuery).setParameter("titulo", "titulo");
        verify(mockedQuery).getSingleResult();
        verify(em).createQuery(QUERY);
	   
		}
	
	@Test
	public void  findAllByUserTemDevolverTodasAsMusicasDeUmUtilizador(){
		List<MusicEntity> listaMusicas;
		final String QUERY = "SELECT p FROM MusicEntity p inner join p.dono s where s.id = :dono";
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<MusicEntity>());
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
       
        when(userEntity.getId()).thenReturn(1);
        
        listaMusicas=ejb.findAllByUser(userEntity);
        verify(mockedQuery).setParameter("dono", 1);
        verify(mockedQuery).getResultList();
        verify(em).createQuery(QUERY);
	   
		}
	
}
