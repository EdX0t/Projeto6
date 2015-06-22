package ar.p4.ejb.dao;
import java.util.ArrayList;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import ar.p4.entities.Musica;
import ar.p4.entities.Playlist;
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
public class PlaylistDaoTest {

	@Mock
	EntityManager em;

	@Mock
	Query mockedQuery;
	@Mock
	NamedQuery mockedNamedQuery;

	@Mock
	Playlist playlist;
	@Mock
	Musica musica;
	@Mock
	Utilizador utilizador;


	@InjectMocks
	PlaylistDao ejb;


	@Test
	public void  findAllByUserTemDevolverTodasAsPlaylistsDeUmUtilizador(){
		List<Playlist> listaPlaylists;
		final String QUERY = "from Playlist p where p.dono.id = :userId";

		when(mockedQuery.getResultList()).thenReturn(new ArrayList<Playlist>());
		when(em.createQuery(QUERY)).thenReturn(mockedQuery);

		when(utilizador.getId()).thenReturn(1);

		listaPlaylists=ejb.findAllByUser(utilizador);
		verify(mockedQuery).setParameter("userId", 1);
		verify(mockedQuery).getResultList();
		verify(em).createQuery(QUERY);

	}

	@Test
	public void  playlistsOrdASCNomeTemDevolverUmaPlaylist(){
		List<Playlist> listaPlaylists;
		final String NQUERYAsc = "PlaylistName.ASC";
		

		when(((Query) mockedQuery).getResultList()).thenReturn(new ArrayList<Playlist>());
		when(em.createNamedQuery(NQUERYAsc)).thenReturn((Query)mockedQuery);

		when(utilizador.getId()).thenReturn(1);

		
		listaPlaylists=ejb.playlistsOrdNome(utilizador,"asc");
		verify((Query) mockedQuery).setParameter("userId", 1);
//		verify((Query)mockedNamedQuery).setParameter("sentido", "asc");
		verify(mockedQuery).getResultList();
		verify(em).createNamedQuery(NQUERYAsc);

	}

	@Test
	public void  playlistsOrdDescNomeTemDevolverUmaPlaylist(){
		List<Playlist> listaPlaylists;
		
		final String NQUERYDesc = "PlaylistName.DESC";

		when(((Query) mockedQuery).getResultList()).thenReturn(new ArrayList<Playlist>());
		when(em.createNamedQuery(NQUERYDesc)).thenReturn((Query)mockedQuery);

		when(utilizador.getId()).thenReturn(1);
		
		listaPlaylists=ejb.playlistsOrdNome(utilizador,"desc");
		verify((Query) mockedQuery).setParameter("userId", 1);
		verify(mockedQuery).getResultList();
		verify(em).createNamedQuery(NQUERYDesc);

	}
	
	@Test
	public void  playlistsOrdDescDataTemDevolverUmaPlaylist(){
		List<Playlist> listaPlaylists;
		
		final String NQUERYDesc = "PlaylistData.DESC";

		when(((Query) mockedQuery).getResultList()).thenReturn(new ArrayList<Playlist>());
		when(em.createNamedQuery(NQUERYDesc)).thenReturn((Query)mockedQuery);

		when(utilizador.getId()).thenReturn(1);
		
		listaPlaylists=ejb.playlistsOrdData(utilizador,"desc");
		verify((Query) mockedQuery).setParameter("userId", 1);
		verify(mockedQuery).getResultList();
		verify(em).createNamedQuery(NQUERYDesc);

	}
	
	@Test
	public void  playlistsOrdAscDataTemDevolverUmaPlaylist(){
		List<Playlist> listaPlaylists;
		
		final String NQUERYAsc = "PlaylistData.ASC";

		when(((Query) mockedQuery).getResultList()).thenReturn(new ArrayList<Playlist>());
		when(em.createNamedQuery(NQUERYAsc)).thenReturn((Query)mockedQuery);

		when(utilizador.getId()).thenReturn(1);
		
		listaPlaylists=ejb.playlistsOrdData(utilizador,"asc");
		verify((Query) mockedQuery).setParameter("userId", 1);
		verify(mockedQuery).getResultList();
		verify(em).createNamedQuery(NQUERYAsc);

	}

	@Test
	public void  playlistsOrdAscTamanhoTemDevolverUmaPlaylist(){
		List<Playlist> listaPlaylists;
		
		final String NQUERYAsc = "PlaylistTamanho.ASC";

		when(((Query) mockedQuery).getResultList()).thenReturn(new ArrayList<Playlist>());
		when(em.createNamedQuery(NQUERYAsc)).thenReturn((Query)mockedQuery);

		when(utilizador.getId()).thenReturn(1);
		
		listaPlaylists=ejb.playlistsOrdTamanho(utilizador,"asc");
		verify((Query) mockedQuery).setParameter("userId", 1);
		verify(mockedQuery).getResultList();
		verify(em).createNamedQuery(NQUERYAsc);

	}

	@Test
	public void  playlistsOrdDescTamanhoTemDevolverUmaPlaylist(){
		List<Playlist> listaPlaylists;
		
		final String NQUERYDesc = "PlaylistTamanho.DESC";

		when(((Query) mockedQuery).getResultList()).thenReturn(new ArrayList<Playlist>());
		when(em.createNamedQuery(NQUERYDesc)).thenReturn((Query)mockedQuery);

		when(utilizador.getId()).thenReturn(1);
		
		listaPlaylists=ejb.playlistsOrdTamanho(utilizador,"desc");
		verify((Query) mockedQuery).setParameter("userId", 1);
		verify(mockedQuery).getResultList();
		verify(em).createNamedQuery(NQUERYDesc);

	}
	
	@Test
	public void  VerificaSeExistePlaylistComNomeDado(){
				
		boolean existe;
		final String QUERY = "select p.nome from Playlist p where p.nome= :nomeParam";
		
		when(mockedQuery.getSingleResult()).thenReturn("nomeParam");
      	when(em.createQuery(QUERY)).thenReturn(mockedQuery);
       
        existe=ejb.checkPlaylist("nomeParam");
        verify(mockedQuery).setParameter("nomeParam", "nomeParam");
        verify(mockedQuery).getSingleResult();
        verify(em).createQuery(QUERY);
        MatcherAssert.assertThat(existe, Matchers.is(Matchers.equalTo(true)));

	}
	
	@Test
	public void  SENomePlaylistNaoExiste(){
				
		boolean existe;
		final String QUERY = "select p.nome from Playlist p where p.nome= :nomeParam";
		
		when(mockedQuery.getSingleResult()).thenReturn("NoResultException");
      	when(em.createQuery(QUERY)).thenReturn(mockedQuery);
       
        existe=ejb.checkPlaylist("alice");
        verify(mockedQuery).setParameter("nomeParam", "alice");
        verify(mockedQuery).getSingleResult();
        verify(em).createQuery(QUERY);
//       
	}
	
	@Test
    public void  VerificaSeExistePlaylistComNomeDadoAtravesExcepcao(){
               
        boolean existe;
        final String QUERY = "select p.nome from Playlist p where p.nome= :nomeParam";
       
        Mockito.doThrow(new NoResultException("Sem resultados")).when(mockedQuery).getSingleResult();
         when(em.createQuery(QUERY)).thenReturn(mockedQuery);
      
        existe=ejb.checkPlaylist("nomeParam");
        verify(mockedQuery).setParameter("nomeParam", "nomeParam");
        verify(mockedQuery).getSingleResult();
        verify(em).createQuery(QUERY);
        MatcherAssert.assertThat(existe, Matchers.is(false));


    }
	
}
