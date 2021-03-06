package ar.p4.util;

import javax.inject.Inject;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import ar.p4.cdibeans.UserSession;
import ar.p4.ejb.util.LoggedUserUtil;
import ar.p4.entities.UserEntity;

public class SessionHelper implements HttpSessionListener {
	@Inject
	private LoggedUserUtil loggedUtil;
	@Inject UserSession userSession;

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		UserEntity user = (UserEntity) event.getSession().getAttribute("user");
		event.getSession().removeAttribute("user");
		loggedUtil.removeUser(user);
	}

}
