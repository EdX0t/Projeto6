package ar.p4.ejb.beans;

import java.util.ArrayList;

import javax.ejb.Local;

import ar.p4.entities.Utilizador;

@Local
public interface UserInterface {
	
	public abstract boolean save(Utilizador user);

	public abstract void update(Utilizador user);
	
	public abstract void updatePassword(Utilizador user);

	public abstract void delete(Utilizador user);

	public abstract Utilizador login(Utilizador user);
	
	public int numUsers();
	
	public ArrayList<Utilizador> getUtilizadores();
	public Utilizador findById(int id);
	
}
