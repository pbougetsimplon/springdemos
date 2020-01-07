package fr.bouget.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fr.bouget.jpa.model.Barrique;
import fr.bouget.jpa.model.Bouteille;
import fr.bouget.jpa.model.Vin;
import fr.bouget.jpa.repository.BarriqueRepository;
import fr.bouget.jpa.repository.BouteilleRepository;
import fr.bouget.jpa.repository.VinRepository;

/**
 * @author Philippe
 *
 */
@Service
public class ArticleService {
	

	@Autowired
	private VinRepository vinRepo;
	
	@Autowired
	private BouteilleRepository bouteilleRepo;
	
	@Autowired
	private BarriqueRepository barriqueRepo;
	

	public ResponseEntity<?> getAllBarriques(){
		List<Barrique> liste = null;
		try
		{
			liste = barriqueRepo.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(liste);
	}


	public ResponseEntity<?> getAllBouteilles(){
		List<Bouteille> liste = null;
		try
		{
			liste = bouteilleRepo.findAll();
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(liste);
	}

	

	public ResponseEntity<?> getAllVins(){
		List<Vin> liste = null;
		try
		{
			liste = vinRepo.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(liste);
	}
	
	public Vin save(Vin v)
	{
		
		return vinRepo.save(v);
	}
	
	public Bouteille save(Bouteille b)
	{
		return bouteilleRepo.save(b);
	}
	
	public Barrique save(Barrique b)
	{
		return  barriqueRepo.save(b);
	}

}
