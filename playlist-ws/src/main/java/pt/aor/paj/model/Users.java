package pt.aor.paj.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="users")
@XmlType(name = "usersType", propOrder = {
    "user"
})
public class Users {
	
	private ArrayList<User> user;
	
	public Users(){
		
	}
	
	public ArrayList<User> getUser() {
		if(user == null)
			user = new ArrayList<User>();
		
		return user;
	}

	public void setUser(ArrayList<User> user) {
		this.user = user;
	}


	
}
