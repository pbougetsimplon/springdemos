package fr.bouget.jpa.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private double montant;
	private Date dateResa;
	private Croisiere croisiere; // une réservation concerne une croisière
	private Set<Client> clients; // une réservation concerne plusieurs clients

	public Reservation(){
		
		this(0, null, null );
	
	}

	public Reservation(double montant, Date dateResa, Croisiere croisiere){
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
	public Date getDateResa() {
		return dateResa;
	}

	public void setDateResa(Date dateResa) {
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

	 // Association plusieurs à plusieurs : plusieurs réservations associées à plusieurs clients
    @ManyToMany(fetch=FetchType.EAGER) //(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinTable(name="RESERVATION_CLIENT",
    			joinColumns={@JoinColumn(name="RESERVATION_ID")},
    			inverseJoinColumns={@JoinColumn(name="CLIENT_ID")})
    @JsonIgnore 
    public Set<Client> getClients() {
        return clients;
    }
    
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
	
	
	@Override
	public String toString(){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return "Réservation : "+id+" montant : "+montant+" date : "+format.format(dateResa)+" "+croisiere+" \n clients : "+clients;
	}
}
