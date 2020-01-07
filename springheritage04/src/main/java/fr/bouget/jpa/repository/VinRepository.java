package fr.bouget.jpa.repository;

import org.springframework.stereotype.Repository;

import fr.bouget.jpa.model.Vin;

@Repository
public interface VinRepository extends ArticleRepository<Vin, Integer> {

}
