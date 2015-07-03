package ar.p4.ejb.beans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ar.p4.ejb.dao.LyricDao;
import ar.p4.ejb.dao.MusicDao;
import ar.p4.entities.LyricEntity;
import ar.p4.entities.MusicEntity;
import ar.p4.entities.UserEntity;

@RunWith(MockitoJUnitRunner.class)
public class LyricBeanTest {
	
	@Mock
	private LyricDao lyricDao;
	@Mock
	private MusicDao mDao;
	@InjectMocks
	private LyricBean lyricBean;
	
	@Test
	public void testOfSaveOrUpdate(){
		UserEntity user=new UserEntity();
		MusicEntity mEN=new MusicEntity();
		Mockito.when(lyricDao.lyricOfMUsic(user, mEN)).thenReturn(null);
		Mockito.when(mDao.find(3)).thenReturn(mEN);
		lyricBean.saveOrUpdate(user, 3, "lirica da musica");
		LyricEntity l=new LyricEntity("lirica da musica",mEN,user);
		Mockito.verify(lyricDao).save(l);
		
	}
	

}
