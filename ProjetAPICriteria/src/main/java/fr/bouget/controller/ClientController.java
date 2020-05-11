package fr.bouget.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.bouget.model.Client;
import fr.bouget.repository.ClientRepository;

/**
 * @author Philippe
 * sources : https://issart.com/blog/how-to-use-criteria-api-with-spring-boot/
 *
 */
@CrossOrigin("*")
@RestController
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/")
	@ResponseBody
	public String home()
	{

		StringBuilder sb = new StringBuilder();
		sb.append("<h1>Regardez dans votre console et dans votre base de données MySQL <strong>criteria</strong></h1>");
		sb.append("<a href='http://localhost:8080/clients'>Voir la liste des clients enregistrés</a>");
		return  sb.toString();

	}

	@GetMapping(value = "/clients")
	@ResponseBody
	public ResponseEntity<?> getAllClients()
	{
		List<Client> liste = null;
		try
		{
			liste = clientRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(liste);
	}


	@GetMapping(value = "/client/{prenom}/{nom}")
	@ResponseBody
	public ResponseEntity<Client> findOneClientByCriteria(@PathVariable String prenom,  @PathVariable String nom)
	{

		Client clientTrouve= null;
		try
		{
			clientTrouve = clientRepository.findOneClientByCriteria(prenom, nom);
		}
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(clientTrouve);
	}

	@GetMapping(value = "/clients/criteria")
	@ResponseBody
	public ResponseEntity<?> findAllClientByCriteria()
	{
		List<Client> liste = null;
		try
		{
			liste = clientRepository.findAllClientByCriteria();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(liste);
	}

	@GetMapping(value = "/clients/sansadresse")
	@ResponseBody
	public ResponseEntity<?> findAllClientSansAdresseByCriteria()
	{
		List<Client> liste = null;
		try
		{
			liste = clientRepository.findAllClientSansAdresseByCriteria();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("rien trouvé !");
		}

		return ResponseEntity.status(HttpStatus.OK).body(liste);
	}

	@GetMapping(value = "/clients/{chaine}")
	@ResponseBody
	public ResponseEntity<?> findAllClientParNomByCriteria(@PathVariable String chaine)
	{
		List<Client> liste = null;
		try
		{
			liste = clientRepository.findAllClientParNomByCriteria(chaine);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(liste);
	}


	@GetMapping(value = "/clients/{nom}/{ca}")
	@ResponseBody
	public ResponseEntity<?> findClientsByNomAndCa(@PathVariable String nom, @PathVariable Integer ca)
	{
		List<Client> liste = null;
		try
		{
			liste = clientRepository.findClientsByNomAndCa(nom, ca);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(liste);
	}

	// http://localhost:8080/clients/page/0 puis 1 puis 2
	@GetMapping(value = "/clients/page/{numeroPage}")
	@ResponseBody
	public Page<Client> getAllClientParCACroissant(@PathVariable int numeroPage)
	{
		/* détail de la méthode PageRequest :
		   PageRequest(int page, int size, Sort sort)
		   page - zero-based page index, must not be negative.
		   size - the size of the page to be returned, must be greater than 0.
		   sort - must not be null, use Sort.unsorted() instead.
		*/
		Pageable pagination = PageRequest.of(Math.abs(numeroPage), 2, Sort.by("ca").ascending());
		return  clientRepository.findAll(pagination);

	}
	

}
