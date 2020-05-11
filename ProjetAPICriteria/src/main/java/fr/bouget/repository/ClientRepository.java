package fr.bouget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.bouget.model.Client;

/**
 * @author Philippe
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>, ClientRepositoryCustom {
	
	
}
