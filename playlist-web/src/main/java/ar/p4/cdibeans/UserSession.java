package ar.p4.cdibeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import ar.p4.ejb.beans.UserInterface;
import ar.p4.ejb.util.LoggedUserUtil;
import ar.p4.ejb.util.SecurityBean;
import ar.p4.entities.UserEntity;

@Named
@SessionScoped
public class UserSession implements Serializable {

	private static final long serialVersionUID = -537522388020645530L;

	private boolean isLogged;
	private UserEntity current;
	private UserEntity newUser;
	@Inject
	private UserInterface userInterface;
	private String password;
	@Inject
	private SecurityBean securityBean;
	@Inject
	private LoggedUserUtil loggedUtil;

	public UserSession() {
		current = new UserEntity();
		newUser = new UserEntity();
		isLogged = false;
	}

	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String mail = securityBean.getPrincipalName();
		if (!mail.isEmpty()) {
			current.setMail(mail);
			current = userInterface.findByEmail(mail);
			if (current != null) {
				isLogged = true;
				loggedUtil.addUser(current);
				request.getSession().setAttribute("user", current);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO,
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
			return endSession();

		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Could not delete user account", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}

	public String endSession() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();

		try {
			isLogged = false;
			loggedUtil.removeUser(current);
			request.logout();
			request.getSession().invalidate();
		} catch (ServletException e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Logout Failed", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "/app/main.xhtml?faces-redirect=true";

	}

	public void register() {
		boolean success = userInterface.save(newUser);
		if (success) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"User registered successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "E-mail already registered",
					"");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		newUser = new UserEntity();
	}

	public UserEntity getNewUser() {
		return newUser;
	}

	public void setNewUser(UserEntity newUser) {
		this.newUser = newUser;
	}

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
