package fr.bouget.spring.jdbc.springdemo04.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.bouget.spring.jdbc.springdemo04.model.Pilote;

/**
 * @author Philippe
 *
 */
@Repository
public interface PiloteDao {

	//List<Pilote> findByNom (String nom);
	Pilote findByNom(String nom);
	List<Pilote> findAll();
	int addPilote(Pilote pilote);
	void removePilote(Pilote pilote);
	void updatePilote(Pilote pilote);
	int count();
}
