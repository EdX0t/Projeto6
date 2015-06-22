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
public class UserDaoTest {

	@Mock
	EntityManager em;

	@Mock
	Query mockedQuery;

	@Mock
	Utilizador utilizador;

	@InjectMocks
	UserDao ejb;

	@Test
	public void fazLoginPorUtilizador() {

		final String QUERY = "select u from Utilizador u where u.mail=:mailparam and u.password =:passparam";
		when(mockedQuery.getResultList()).thenReturn(new ArrayList<Musica>());
		when(em.createQuery(QUERY)).thenReturn(mockedQuery);

		when(utilizador.getMail()).thenReturn("mail");
		when(utilizador.getPassword()).thenReturn("pass");

		utilizador = ejb.login(utilizador);
		verify(mockedQuery).setParameter("mailparam", "mail");
		verify(mockedQuery).setParameter("passparam", "pass");
		verify(mockedQuery).getSingleResult();
		verify(em).createQuery(QUERY);

	}

	@Test
	public void VerificaSeExisteUtilizadorComNomeDado() {

		boolean existe;
		final String QUERY = "select u.mail from Utilizador u where u.mail= :mailParam";

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

		final String QUERY = "select u from Utilizador u where u.mail=:mailparam and u.password =:passparam";

		Mockito.doThrow(new NoResultException("Sem resultados"))
				.when(mockedQuery).getSingleResult();

		when(em.createQuery(QUERY)).thenReturn(mockedQuery);

		when(utilizador.getMail()).thenReturn("mail");
		when(utilizador.getPassword()).thenReturn("pass");

		utilizador = ejb.login(utilizador);
		verify(mockedQuery).setParameter("mailparam", "mail");
		verify(mockedQuery).setParameter("passparam", "pass");
		verify(mockedQuery).getSingleResult();
		verify(em).createQuery(QUERY);

	}

}
