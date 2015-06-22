package pt.aor.paj.resources.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "usersType", propOrder = {
    "user"
})
public class Users {

	private ArrayList<User> users;

	public ArrayList<User> getNoticia() {
        if (users == null) {
            users = new ArrayList<User>();
        }
        return this.users;
    }

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
}
