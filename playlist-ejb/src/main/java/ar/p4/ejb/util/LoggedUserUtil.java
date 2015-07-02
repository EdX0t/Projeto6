package ar.p4.ejb.util;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import ar.p4.entities.UserEntity;

/**
 * Session Bean implementation class LoggedUserUtil
 */
@Singleton
@LocalBean
public class LoggedUserUtil {
	
	private ArrayList<UserEntity> loggedUsersList = new ArrayList<UserEntity>(); ;

    /**
     * Default constructor. 
     */
    public LoggedUserUtil() {
       
    }

	public ArrayList<UserEntity> getLoggedUsersList() {
		return loggedUsersList;
	}

	public void setLoggedUsersList(ArrayList<UserEntity> loggedUsersList) {
		this.loggedUsersList = loggedUsersList;
	}
	public void addUser(UserEntity user){
		if(!loggedUsersList.contains(user)){
			loggedUsersList.add(user);
		}
	}
	public void removeUser(UserEntity user){
		if(loggedUsersList.contains(user)){
			loggedUsersList.remove(user);
		}
	}
    

}
