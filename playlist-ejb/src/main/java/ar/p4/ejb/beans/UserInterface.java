package ar.p4.ejb.beans;

import java.util.ArrayList;

import javax.ejb.Local;

import ar.p4.entities.UserEntity;

@Local
public interface UserInterface {
	
	public abstract boolean save(UserEntity user);

	public abstract void update(UserEntity user);
	
	public abstract void updatePassword(UserEntity user);

	public abstract void delete(UserEntity user);

	public abstract UserEntity login(UserEntity user);
	
	public int numUsers();
	
	public ArrayList<UserEntity> getUtilizadores();
	public UserEntity findById(int id);
	
	public UserEntity findByEmail(String email);
	
}
