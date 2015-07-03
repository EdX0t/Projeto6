package ar.p4.ejb.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ar.p4.entities.LyricEntity;
import ar.p4.entities.MusicEntity;
import ar.p4.entities.UserEntity;

@RunWith(MockitoJUnitRunner.class)
public class LyricDaoTest {

	@Mock
	private TypedQuery <LyricEntity> mockedQuery;
	@Mock
	private EntityManager em;
	
	@InjectMocks
	private LyricDao lyricDao;
	
	
	
	@Test
	public void testOfLyricOFMusicWithNullUeser(){
		Mockito.when(em.createNamedQuery(LyricEntity.LYRICS_BY_Null_MUSIC, LyricEntity.class)).thenReturn(mockedQuery);
		lyricDao.lyricOfMUsic(null, new MusicEntity());
		Mockito.verify(mockedQuery, Mockito.never()).setParameter(Mockito.eq("utilizador"), Mockito.any(UserEntity.class));
		Mockito.verify(mockedQuery).setParameter(Mockito.eq("music"),  Mockito.any(MusicEntity.class));
		
	}
	
	
	@Test
	public void testOfLyricOFMusicWithUser(){
		UserEntity uti=new UserEntity("qq coisa","qualquer coisa");
		Mockito.when(em.createNamedQuery(LyricEntity.LYRICS_BY_USER_MUSIC, LyricEntity.class)).thenReturn(mockedQuery);
		lyricDao.lyricOfMUsic(uti, new MusicEntity());
		Mockito.verify(mockedQuery).setParameter(Mockito.eq("utilizador"), Mockito.any(UserEntity.class));
		Mockito.verify(mockedQuery).setParameter(Mockito.eq("music"),  Mockito.any(MusicEntity.class));
	}
	
	@Test
	public void testOflyricOfUser(){
		UserEntity uti=new UserEntity("qq coisa","qualquer coisa");
		Mockito.when(em.createNamedQuery(LyricEntity.LYRICS_BY_USER, LyricEntity.class)).thenReturn(mockedQuery);
		lyricDao.lyricOfUser(uti);
		Mockito.verify(mockedQuery).setParameter(Mockito.eq("utilizador"), Mockito.any(UserEntity.class));
		Mockito.verify(mockedQuery).getResultList();
	}
	
	@Test
	public void testOflyricDelete(){
		lyricDao.delete(1, LyricEntity.class);
		Mockito.verify(em).getReference(LyricEntity.class, 1);
		Mockito.verify(em).remove(Mockito.any(LyricEntity.class));	
	}
	
	@Test
	public void testOfupdate(){
		LyricEntity l = new LyricEntity("lyrica da musica", new MusicEntity(),new UserEntity());
		lyricDao.update(l);
		Mockito.verify(em).merge(l);
	}
	
	@Test
	public void testOfSave(){
		LyricEntity l = new LyricEntity("lyrica da musica", new MusicEntity(),new UserEntity());
		lyricDao.save(l);
		Mockito.verify(em).persist(l);
	}
}
