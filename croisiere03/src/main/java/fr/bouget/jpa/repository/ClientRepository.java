package fr.bouget.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bouget.jpa.model.Client;

/**
 * @author Philippe
 *
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
