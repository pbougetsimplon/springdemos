package fr.bouget.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.bouget.jpa.model.Reservation;

/**
 * @author Philippe
 *
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
