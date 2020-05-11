package fr.bouget.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fr.bouget.model.Client;

public class ClientRepositoryCustomImpl implements ClientRepositoryCustom {


	@PersistenceContext
	private EntityManager manager;

	public Client findOneClientByCriteria(String prenom, String nom)
	{

		// on appelle l'objet Builder
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		// on précise sur quelle Entité (table) on souhaite travailler
		CriteriaQuery<Client> requete = builder.createQuery(Client.class);
		// ici,la table client, le type de l'objet qu'on souhaite retourner
		Root<Client> clientRoot = requete.from(Client.class);
		// on précise les éléments de la requête (ici le prénom) :
		//	requete.where(builder.equal(clientRoot.get("prenom"), client.getPrenom()));

		// on pourrait préciser les valeurs avec la syntaxe suivante :
		requete.where(builder.and(
				builder.equal(clientRoot.get("prenom"), prenom),
				builder.equal(clientRoot.get("nom"), nom)
				));

		return manager.createQuery(requete).getSingleResult();
	}

	public List<Client> findAllClientByCriteria()
	{
		// on appelle l'objet Builder
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		// on précise sur quelle Entité (table) on souhaite travailler
		CriteriaQuery<Client> requete = builder.createQuery(Client.class);
		// ici,la table client
		Root<Client> clientRoot = requete.from(Client.class);
		// c'est juste un select de client
		requete.select(clientRoot);
		System.out.println(requete);
		List<Client> liste = manager.createQuery(requete).getResultList();
		return liste;
	}

	public List<Client> findAllClientSansAdresseByCriteria()
	{
		// on appelle l'objet CriteriaBuilder
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		// on précise sur quelle Entité (table) on souhaite travailler :
		CriteriaQuery<Client> cq = cb.createQuery(Client.class);
		// ici,la table client
		Root<Client> client = cq.from(Client.class);
		// qu'affiche t-on ?
		cq.select(client);

		// que veut-on ?
		// 1 - les clients qui n'ont pas d'adresse ou adresse nulle
		cq.where(client.get("adresse").isNull());		
		return  manager.createQuery(cq).getResultList();
	}

	public List<Client> findAllClientParNomByCriteria(String chaine)
	{
		// on appelle l'objet CriteriaBuilder
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		// on précise sur quelles Entités (tables) on souhaite travailler :
		CriteriaQuery<Client> cq = cb.createQuery(Client.class);
		// ici,la table client et adresse
		Root<Client> client = cq.from(Client.class);
		//	Root<Adresse> adresse = cq.from(Adresse.class);
		// qu'affiche t-on ? un objet Client
		cq.select(client);

		// que veut-on ?
		// les clients dont le nom contient la chaîne passée en paramètre
		cq.where(cb.like(client.get("nom"),"%"+chaine+"%"));
		return manager.createQuery(cq).getResultList();
	}


	public List<Client> findClientsByNomAndCa(String nom, Integer ca)
	{
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
		Root<Client> client = criteriaQuery.from(Client.class);

		Predicate nomPredicate = criteriaBuilder.like(client.get("nom"), nom ); // création du premier prédicat
		Predicate caPredicate = criteriaBuilder.ge(client.get("ca"), ca);	 	// création du second prédicat
		criteriaQuery.where(nomPredicate, caPredicate);							 // on combine les 2 prédicats
		TypedQuery<Client> query = manager.createQuery(criteriaQuery);	 		 // on exécute la requête
		return query.getResultList();											 // on retourne la liste
	}
}
