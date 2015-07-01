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
	
	private ArrayList<UserEntity> loggedUsersList;

    /**
     * Default constructor. 
     */
    public LoggedUserUtil() {
       
    }

	public ArrayList<UserEntity> getLoggedUsersList() {
		if(loggedUsersList == null)
			loggedUsersList = new ArrayList<UserEntity>();
		
		return loggedUsersList;
	}

	public void setLoggedUsersList(ArrayList<UserEntity> loggedUsersList) {
		this.loggedUsersList = loggedUsersList;
	}
    

}
