package fr.bouget.jpa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nom;
	private String prenom;
	// un client peut faire plusieurs réservations
	private Collection<Reservation> reservations;

	public Client() {
		this(null,null);
	}

	public Client(String prenom, String nom) {
		this.nom = nom;
		this.prenom = prenom;
		this.reservations = new ArrayList<>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@ManyToMany(mappedBy = "clients")
	@JsonIgnore //(cascade={CascadeType.ALL},mappedBy = "clients")
	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Client : "+ id + " " + nom + " " + prenom;
	}
}
