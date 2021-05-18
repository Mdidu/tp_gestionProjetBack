package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the DEPARTEMENTS database table.
 * 
 */
@Entity
@Table(name="DEPARTEMENTS")
public class Departement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long iddepartement;

	private String libelle;

	//bi-directional many-to-one association to Employe
	@OneToMany(mappedBy="departement")
	@JsonIgnore
	private List<Employe> employes;

	public Departement() {
	}

	public long getIddepartement() {
		return this.iddepartement;
	}

	public void setIddepartement(long iddepartement) {
		this.iddepartement = iddepartement;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Employe> getEmployes() {
		return this.employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public Employe addEmploye(Employe employe) {
		getEmployes().add(employe);
		employe.setDepartement(this);

		return employe;
	}

	public Employe removeEmploye(Employe employe) {
		getEmployes().remove(employe);
		employe.setDepartement(null);

		return employe;
	}

}
