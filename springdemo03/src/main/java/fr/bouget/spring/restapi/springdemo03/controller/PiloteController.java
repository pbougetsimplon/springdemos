/**
 * 
 */
package fr.bouget.spring.restapi.springdemo03.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.bouget.spring.restapi.springdemo03.bean.Pilote;

/**
 * @author Philippe
 *
 */
@RestController
@RequestMapping("/demo3")
public class PiloteController  {
	
	private List<Pilote> liste = new ArrayList<>();
	
	public PiloteController()
	{
		Pilote p = new Pilote(1,"Josselin","Montreuil");
		Pilote p2 = new Pilote(2,"Philippe", "Paris");
		Pilote p3 = new Pilote(3, "Anissa", "Marseille");
		this.liste.add(p);
		this.liste.add(p2);
		this.liste.add(p3);
	}
	
	@GetMapping("/pilotes")
	public List<Pilote> getAll()
	{
		return this.liste;
		
	}

}
