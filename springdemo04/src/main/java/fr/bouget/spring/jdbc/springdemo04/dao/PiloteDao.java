package fr.bouget.spring.jdbc.springdemo04.dao;

import java.util.List;

import fr.bouget.spring.jdbc.springdemo04.model.Pilote;

/**
 * @author Philippe
 *
 */
public interface PiloteDao {

	public List<Pilote> findByNom (String nom);
	public List<Pilote> findAll();
	public int addPilote(Pilote pilote);
	public void removePilote(Pilote pilote);
	public void updatePilote(Pilote pilote);
}
