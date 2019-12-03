package fr.bouget.demo.springhibernate.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String libelle;
	private List<Apprenant> apprenants;

	public Region() { this(0);}

	public Region(Integer id) {
		this.id = id;
		this.apprenants = new ArrayList<>();
	}

	@Id
	@Column(name="id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 50)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@OneToMany(targetEntity=Apprenant.class, mappedBy="region", fetch = FetchType.EAGER)
	@JsonIgnore
	public List<Apprenant> getApprenants() {
		return this.apprenants;
	}

	public void setApprenants(List<Apprenant> apprenants) {
		this.apprenants = apprenants;
	}

	//	public Apprenant addApprenant(Apprenant apprenant) {
	//		getApprenants().add(apprenant);
	//		apprenant.setRegion(this);
	//
	//		return apprenant;
	//	}
	//
	//	public Apprenant removeApprenant(Apprenant apprenant) {
	//		getApprenants().remove(apprenant);
	//		apprenant.setRegion(null);
	//
	//		return apprenant;
	//	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.libelle;
	}



}