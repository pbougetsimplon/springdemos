package fr.bouget.spring.jdbc.springdemo04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import fr.bouget.spring.jdbc.springdemo04.dao.PiloteDao;
import fr.bouget.spring.jdbc.springdemo04.model.Pilote;

@SpringBootApplication
@ComponentScan(basePackages = { "fr.bouget.spring.jdbc.springdemo04" })
public class Demo04Application implements CommandLineRunner {

	@Autowired(required=true)
	private PiloteDao piloteDao;

	/**
	 * méthode main()
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Demo04Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// on suppose que la table Pilote existe et qu'elle contient des enregistrements.
		// petit test
		List<Pilote> pilotes = piloteDao.findAll();
		for (Pilote pilote : pilotes) {
			System.out.println(pilote);
		}

		// on recherche élodie
		List<Pilote> elodies = piloteDao.findByNom("ELODIE");
		for (Pilote pilote : elodies) {
			System.out.println(pilote);
		}
		
		// ajouter pilote
		Pilote p= new Pilote();
		p.setNom("Philippe");
		p.setSite("Paris");
		p.setId(piloteDao.addPilote(p));
		System.out.println("Ajout de Philippe -  Paris : "+p);
		
		// modifieer le site du pilote p avec Avignon au lieu de Paris
		System.out.println("Modification du Pilote "+p.getNom()+" pour le nouveau site Avignon");
		p.setSite("Avignon");
		piloteDao.updatePilote(p);
		
		// ajouter un pilote puis le détruire
		Pilote toto= new Pilote();
		toto.setNom("Toto");
		toto.setSite("Lisbonne");
		toto.setId(piloteDao.addPilote(toto));
		System.out.println("Ajout de Toto - Lisbonne : "+toto);
		
		// détruire le pilote dans la base !
		piloteDao.removePilote(toto);

	}
}
