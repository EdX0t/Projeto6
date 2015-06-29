package ar.p4.cdibeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import ar.p4.ejb.beans.UserInterface;
import ar.p4.ejb.util.SecurityBean;
import ar.p4.entities.UserEntity;

@Named
@SessionScoped
public class UserSession implements Serializable {

	private static final long serialVersionUID = -537522388020645530L;

	private boolean isLogged;
	private HttpSession session;
	private UserEntity current;
	@Inject
	private UserInterface userInterface;
	private String password;
	@Inject
	Login login;
	@Inject SecurityBean securityBean;

	public UserSession() {
		current = new UserEntity();
		isLogged = false;
	}

	public void init() {
		String mail = securityBean.getPrincipalName();
		if(!mail.isEmpty()){
		current.setMail(mail);
		current = userInterface.findByEmail(mail);
		// current = userInterface.login(current);
		if (current != null) {
			isLogged = true;
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"This mail is not registered.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		} 
	}

	// editar informacao
	public void editar() {
		try {
			userInterface.update(current);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"User info updated successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {

		}
	}

	public void editarPass() {
		try {
			current.setPassword(password);
			userInterface.updatePassword(current);
			password = "";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Password updated successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {

		}
	}

	// apagar conta
	public String deleteAccount() {
		try {
			userInterface.delete(current);
			return login.logout();

		} catch (Exception e) {

		}
		return null;
	}

	// Métodos para filtro da sessao HTTP //
	public void startSession() {
		session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("isLogged", isLogged);

	}

	public void endSession() {
		if (session != null) {
			session.invalidate();
			isLogged = false;
		}
	}

	// **************************************//

	// ***** Getters e Setters ***************//

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public UserEntity getCurrent() {
		return current;
	}

	public void setCurrent(UserEntity current) {
		this.current = current;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
