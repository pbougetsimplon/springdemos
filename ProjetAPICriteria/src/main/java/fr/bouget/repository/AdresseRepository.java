package fr.bouget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bouget.model.Adresse;

/**
 * @author Philippe
 * Remarque : JpaRepository hérite de PagingAndSortingRepository
 */
public interface AdresseRepository extends JpaRepository<Adresse, Integer> {

}

// Autre possibilité d'écriture
//public interface AdresseRepository extends PagingAndSortingRepository<Adresse, Integer> {
//	 
//    List<Adresse> findAllByPays(String pays, Pageable pageable);
//}