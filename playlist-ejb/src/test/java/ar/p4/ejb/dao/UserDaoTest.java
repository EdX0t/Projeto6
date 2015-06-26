package ar.p4.ejb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
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

import ar.p4.entities.MusicEntity;
import ar.p4.entities.UserEntity;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.anyString;
import static org.hamcrest.Matchers.nullValue;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

	@Mock
	EntityManager em;

	@Mock
	Query mockedQuery;

	@Mock
	UserEntity userEntity;

	@InjectMocks
	UserDao ejb;

	@Test
	public void fazLoginPorUtilizador() {

		final String QUERY = "select u from UserEntity u where u.mail=:mailparam and u.password =:passparam";
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<MusicEntity>());
		when(em.createQuery(QUERY)).thenReturn(mockedQuery);

		when(userEntity.getMail()).thenReturn("mail");
		when(userEntity.getPassword()).thenReturn("pass");

		userEntity = ejb.login(userEntity);
		verify(mockedQuery).setParameter("mailparam", "mail");
		verify(mockedQuery).setParameter("passparam", "pass");
		verify(mockedQuery).getSingleResult();
		verify(em).createQuery(QUERY);

	}

	@Test
	public void VerificaSeExisteUtilizadorComNomeDado() {

		boolean existe;
		final String QUERY = "select u.mail from UserEntity u where u.mail= :mailParam";

		when(mockedQuery.getSingleResult()).thenReturn("emailTemp");
		when(em.createQuery(QUERY)).thenReturn(mockedQuery);

		existe = ejb.checkEmail("emailTemp");
		verify(mockedQuery).setParameter("mailParam", "emailTemp");
		verify(mockedQuery).getSingleResult();
		verify(em).createQuery(QUERY);
		MatcherAssert.assertThat(existe, Matchers.is(Matchers.equalTo(true)));

	}

	@Test
	public void fazLoginPorUtilizadorComExcepcao() {

		final String QUERY = "select u from UserEntity u where u.mail=:mailparam and u.password =:passparam";

		Mockito.doThrow(new NoResultException("Sem resultados"))
				.when(mockedQuery).getSingleResult();

		when(em.createQuery(QUERY)).thenReturn(mockedQuery);

		when(userEntity.getMail()).thenReturn("mail");
		when(userEntity.getPassword()).thenReturn("pass");

		userEntity = ejb.login(userEntity);
		verify(mockedQuery).setParameter("mailparam", "mail");
		verify(mockedQuery).setParameter("passparam", "pass");
		verify(mockedQuery).getSingleResult();
		verify(em).createQuery(QUERY);

	}

}
