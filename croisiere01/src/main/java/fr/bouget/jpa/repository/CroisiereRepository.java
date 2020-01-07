package fr.bouget.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bouget.jpa.model.Croisiere;

/**
 * @author Philippe
 *
 */
public interface CroisiereRepository extends JpaRepository<Croisiere, Integer> {
	
	public Croisiere findByNom(String nom);

}
