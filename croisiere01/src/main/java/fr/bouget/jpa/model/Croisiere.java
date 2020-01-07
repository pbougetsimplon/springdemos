package fr.bouget.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Croisiere implements Serializable {
	public static final long serialVersionUID=987654378L;

	private int id;
	private String nom;
	private int duree;
	// une croisière est relièe à  un et un seul Paquebot
	private Paquebot paquebot;

	public Croisiere(){
		this.id=0;
		this.nom="";
		this.duree=0;
		this.paquebot=null;
	}

	public Croisiere(String nom, int duree)
	{
		this(nom, duree, null);
	}

	public Croisiere(String nom, int duree, Paquebot paquebot){
		this.nom=nom;
		this.duree=duree;
		this.paquebot=paquebot;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	@Column(length = 45)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// Plusieurs croisières sont lièes à un paquebot
	//@ManyToOne(fetch=FetchType.EAGER)
	@ManyToOne
	@JoinColumn(name="PAQUEBOT_ID")
	public Paquebot getPaquebot() {
		return paquebot;
	}

	public void setPaquebot(Paquebot paquebot) {
		this.paquebot = paquebot;
	}


	@Override
	public String toString(){
		return "Croisière : "+id+" "+nom+" "+duree+" (jours) "+paquebot;
	}
}
