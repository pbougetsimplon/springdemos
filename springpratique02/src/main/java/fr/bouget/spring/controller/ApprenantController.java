package fr.bouget.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.bouget.spring.model.Apprenant;
import fr.bouget.spring.repository.ApprenantRepository;

/**
 * 
 * Controller
 *
 */
@RestController
@RequestMapping("/api")
public class ApprenantController {

	@Autowired
	private ApprenantRepository apprenantRepository;
	
	
	/**
	 * ContrÃ´leur
	 */
	public ApprenantController() {}

	/**
	 * MÃ©thode qui retourne tous les apprenants
	 * @return
	 */
	@GetMapping(value = "/apprenants")
	public ResponseEntity<?> getAllApprenants(){
		List<Apprenant> listeApprenants = null;
		try {
			listeApprenants = apprenantRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(listeApprenants);
	}
	
	/**
	 * rechercher
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/apprenant/{id}")
	public ResponseEntity<?> getApprenant(@PathVariable Integer id){
		Optional<Apprenant> apprenant = null;
				
		try {
			apprenant =apprenantRepository.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		if(apprenant.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
		return ResponseEntity.status(HttpStatus.OK).body(apprenant);
	}
	
	/**
	 * ajouter
	 * @param apprenant
	 * @return
	 */
	@PostMapping(value = "/apprenant")
	public ResponseEntity<?> addApprenant(@RequestBody Apprenant apprenant){
		Apprenant resultApprenant = null;
		String prenom = apprenant.getPrenom();
		if((prenom == null) || (prenom.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque le prénom !");
		
		String nom = apprenant.getNom();
		if((nom == null) || (nom.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque le nom !");
		
		try {
			resultApprenant = apprenantRepository.saveAndFlush(apprenant);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(resultApprenant);
	}
	
	/**
	 * Mettre Ã  jour les attributs d'un apprenant
	 * @param apprenant
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PutMapping(value = "/apprenant/{id}")
	public ResponseEntity<?> updateApprenant(@RequestBody Apprenant apprenant, @PathVariable Integer id) throws Exception {
		Apprenant resultApprenant = null;
		String prenom = apprenant.getPrenom();
		if((prenom == null) || (prenom.isEmpty()))
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque le prénom !");
		
		String nom = apprenant.getNom();
		
		if((nom == null) || (nom.isEmpty()))
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque le nom !");
		
		try {
			resultApprenant = apprenantRepository.save(apprenant);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(resultApprenant);
	}
	
	/**
	 * Détruire un apprenant qui existe
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/apprenant/{id}")
	public ResponseEntity<?> deleteApprenant(@PathVariable Integer id){
		try {
			if (apprenantRepository.findById(id)!=null)
				{
					apprenantRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.OK).body("Apprenant(e) effacé(e) !");
				}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Apprenant(e) inexistant(e) !");
			
		}
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
		
	}
	
}
