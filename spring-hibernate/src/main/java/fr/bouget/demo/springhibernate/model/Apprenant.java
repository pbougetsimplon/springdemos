package fr.bouget.demo.springhibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Apprenant implements Serializable {

	private static final long serialVersionUID = 1L;


	private Integer id;
	private String nom;
	private String prenom;
	private Region region;

	/**
	 * Constructeur sans arguments
	 */
	public Apprenant() {}

	public Apprenant(String nom, String prenom, Region region) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.region = region;
	}

	@Id
	@Column(name="id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 50, nullable = false)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(length = 50, nullable = false)
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return this.nom +" "+ this.prenom + " "+this.region;
	}



}