package fr.bouget.demo.springhibernate.controleur;

import java.text.MessageFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.bouget.demo.springhibernate.SpringHibernateApplication;
import fr.bouget.demo.springhibernate.model.Apprenant;
import fr.bouget.demo.springhibernate.model.Region;
import fr.bouget.demo.springhibernate.repository.ApprenantRepository;
import fr.bouget.demo.springhibernate.repository.RegionRepository;

/**
 * @author Philippe
 *
 */
@RestController
@RequestMapping("/api")
public class Controleur {

	private static final Logger log = LoggerFactory.getLogger(SpringHibernateApplication.class);

	@Autowired
	private ApprenantRepository apprenantRepository;
	@Autowired
	private RegionRepository regionRepository;

	@GetMapping("/apprenants")
	public List<Apprenant> getAllApprenants(){
		List<Apprenant> listeApprenants = null;
		try {
			listeApprenants = apprenantRepository.findAll();
		} catch (Exception e) {

			log.info(MessageFormat.format("Méthode getAllApprenants() => renvoie la liste des apprenants \n {0}:", e.getMessage()));

		}

		return listeApprenants;
	}

	@GetMapping("/regions")
	public List<Region> getAllRegions(){
		List<Region> listeRegions = null;
		try {
			listeRegions = regionRepository.findAll();
		} catch (Exception e) {
			log.info(MessageFormat.format("Méthode getAllRegions() => renvoie la liste des régions \n {0}:", e.getMessage()));

		}

		return listeRegions;
	}

	@GetMapping("/apprenant/{id}")
	public Apprenant getApprenant(@PathVariable("id") Integer id){
		Apprenant apprenant = null;

		try {
			apprenant =apprenantRepository.getOne(id);
		} catch (Exception e) { 
			log.info(MessageFormat.format("Méthode getApprenant() => renvoie un apprenant par son id \n {0}:", e.getMessage()));

		}
		// pour info, il existe une méthode pour chaque attribut comme getApprenantById()
		return apprenant;
	}

}
