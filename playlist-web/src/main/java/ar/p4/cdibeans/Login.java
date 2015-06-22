package ar.p4.cdibeans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ar.p4.ejb.beans.UserInterface;
import ar.p4.entities.Utilizador;

@Named
@RequestScoped
public class Login {
	@Inject
	private UserInterface ubean;
	@Inject
	private UserSession userSession;
	private Utilizador current;

	public Login() {
		current = new Utilizador();
	}

	public String login() {
			current = ubean.login(current);
			if (current != null) {
				userSession.setCurrent(current);
				userSession.setLogged(true);
				userSession.startSession();
				return "/app/main?faces-redirect=true";
			} else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Login Failed. E-mail or Password incorrect.", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return "";
			}
	}

	public String logout() {
		userSession.endSession();
		return "/index?faces-redirect=true";
	}

	public void register() {
				boolean success = ubean.save(current);
				if(success){
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
							"User registered successfully.", "");
					FacesContext.getCurrentInstance().addMessage(null, message);
				} else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"E-mail already registered", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
				}
			current = new Utilizador();
	}

	public Utilizador getCurrent() {
		return current;
	}

	public void setCurrent(Utilizador current) {
		this.current = current;
	}

}
