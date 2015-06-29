package ar.p4.cdibeans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ar.p4.ejb.beans.UserInterface;
import ar.p4.entities.UserEntity;

@Named
@RequestScoped
public class Login {
	@Inject
	private UserInterface ubean;
	@Inject
	private UserSession userSession;
	private UserEntity newUser;

	public Login() {
		newUser = new UserEntity();
	}

	public void login() {
		System.out.println("Login method called");
//			current = ubean.login(current);
//			if (current != null) {
//				userSession.setCurrent(current);
//				userSession.setLogged(true);
////				userSession.startSession();
//			} else {
//				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
//						"Login Failed. E-mail or Password incorrect.", "");
//				FacesContext.getCurrentInstance().addMessage(null, message);
//			}
	}

	public String logout() {
		userSession.endSession();
		return "/index?faces-redirect=true";
	}

	public void register() {
				boolean success = ubean.save(newUser);
				if(success){
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
							"User registered successfully.", "");
					FacesContext.getCurrentInstance().addMessage(null, message);
				} else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"E-mail already registered", "");
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

}
