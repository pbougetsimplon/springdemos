package fr.bouget.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.bouget.jpa.model.Vin;
import fr.bouget.jpa.model.VinPK;

/**
 * @author Philippe
 *
 */
@Repository
public interface VinRepository extends JpaRepository<Vin, VinPK> {

}
