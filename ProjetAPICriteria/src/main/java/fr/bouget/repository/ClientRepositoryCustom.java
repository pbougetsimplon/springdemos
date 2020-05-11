package fr.bouget.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.bouget.model.Client;

/**
 * 
 * @author Philippe
 *
 */
@Repository
public interface ClientRepositoryCustom {
	
	public Client findOneClientByCriteria(String prenom, String nom);
	public List<Client> findAllClientByCriteria();
	public List<Client> findAllClientSansAdresseByCriteria();
	public List<Client> findAllClientParNomByCriteria(String chaine);
	public List<Client> findClientsByNomAndCa(String nom, Integer ca);
	


	
}
