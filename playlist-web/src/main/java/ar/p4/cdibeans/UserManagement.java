package ar.p4.cdibeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import ar.p4.entities.UserEntity;

@ApplicationScoped
@Named
public class UserManagement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<UserEntity> loggedUserList;

	public UserManagement() {
		loggedUserList = new ArrayList<>();
	}

	public ArrayList<UserEntity> getLoggedUserList() {
		return loggedUserList;
	}

	public void setLoggedUserList(ArrayList<UserEntity> loggedUserList) {
		this.loggedUserList = loggedUserList;
	}

}
