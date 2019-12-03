package fr.bouget.demo.springhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.bouget.demo.springhibernate.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer>{

	// Rien à faire le crud est implémenté

}
