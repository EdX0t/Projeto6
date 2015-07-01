package pt.aor.paj.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "logged-users")
@XmlType(name = "usersLoggedType", propOrder = {
	    "user"
	})
public class LoggedUsers {

	private ArrayList<User> user;

	public LoggedUsers() {

	}

	public ArrayList<User> getUser() {
		if (user == null)
			user = new ArrayList<User>();
		return user;
	}

	public void setUser(ArrayList<User> user) {
		this.user = user;
	}

}
