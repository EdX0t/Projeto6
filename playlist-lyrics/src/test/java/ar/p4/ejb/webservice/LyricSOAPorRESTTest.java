package ar.p4.ejb.webservice;


import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ar.p4.ejb.webserviceRest.SearchLyricResult1;

@RunWith(MockitoJUnitRunner.class)
public class LyricSOAPorRESTTest {
	@Mock
	SearchLyricResult1 result;
	
	@InjectMocks
	private LyricSOAPorREST lyric;
	
	
	@Test
	public void test(){
		Mockito.when(result.getSong()).thenReturn("ola");
		String lyricResult=lyric.lyricOfMusic("Ola", "Ola");
		Assert.assertThat(lyricResult, is(equalTo(null)));
	}
	
	
	@Test
	public void test2(){
		Mockito.when(result.getSong()).thenReturn("One");
		String lyricResult=lyric.lyricOfMusic("U2", "One");
		Assert.assertThat(lyricResult.length(), is(greaterThan(10)));	
	}
	

}
