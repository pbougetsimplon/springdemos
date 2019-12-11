package fr.bouget.spring.springpratique01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.bouget.spring.springpratique01.bean.Pilote;



/**
 * @author Philippe
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PiloteController  {
	
	private List<Pilote> liste = new ArrayList<>();
	
	public PiloteController()
	{
		Pilote p = new Pilote(1,"Josselin","Montreuil");
		Pilote p2 = new Pilote(2,"Philippe", "Paris");
		Pilote p3 = new Pilote(3, "Anissa", "Marseille");
		Pilote p4 = new Pilote(4,"Jules","Lille");
		Pilote p5 = new Pilote(5,"Marguerite", "Lyon");
		Pilote p6 = new Pilote(6, "Véronique", "Toulouse");
		// vous pouvez en ajouter autant que vous voulez !
		this.liste.add(p);
		this.liste.add(p2);
		this.liste.add(p3);
		this.liste.add(p4);
		this.liste.add(p5);
		this.liste.add(p6);
	}
	
	@GetMapping("/pilotes")
	public List<Pilote> getAll()
	{
		return this.liste;
		
	}

}
