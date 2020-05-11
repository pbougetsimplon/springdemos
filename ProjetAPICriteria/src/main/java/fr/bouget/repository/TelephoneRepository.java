package fr.bouget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.bouget.model.Telephone;

/**
 * @author Philippe
 *
 */
@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Integer> {

}

