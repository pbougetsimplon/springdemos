package fr.bouget.jpa.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private double montant;
	private Calendar dateResa;
	private Croisiere croisiere; // une réservation concerne une croisière

	public Reservation(){
		
		this(0, new GregorianCalendar(),null );
	
	}

	public Reservation(double montant, Calendar dateResa, Croisiere croisiere){
		this.montant=montant;
		this.dateResa=dateResa;
		this.croisiere=croisiere;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Temporal(value=TemporalType.DATE)
	public Calendar getDateResa() {
		return dateResa;
	}

	public void setDateResa(Calendar dateResa) {
		this.dateResa = dateResa;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	//Entité qui détient l'association
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="CROISIERE_ID")
	@JsonIgnore
	public Croisiere getCroisiere() {
		return croisiere;
	}

	public void setCroisiere(Croisiere croisiere) {
		this.croisiere = croisiere;
	}

	@Override
	public String toString(){
		return "Réservation : "+id+" montant : "+montant+" date : "+dateResa.get(Calendar.YEAR)+"/"+dateResa.get(Calendar.MONTH)+" "+croisiere;
	}
}
