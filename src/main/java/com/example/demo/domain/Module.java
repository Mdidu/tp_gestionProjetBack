package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MODULES database table.
 * 
 */
@Entity
@Table(name="MODULES")
public class Module implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idmodule;

	private Date datedebut;

	private Date datefinestimee;

	private Date datefinreel;

	private String nom;

	//bi-directional many-to-one association to Projet
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="IDPROJET")
	private Projet projet;

	//bi-directional many-to-one association to Tach
	@OneToMany(mappedBy="module")
	@JsonIgnore
	private List<Tache> taches;

	public Module() {
	}

	public long getIdmodule() {
		return this.idmodule;
	}

	public void setIdmodule(long idmodule) {
		this.idmodule = idmodule;
	}

	public Date getDatedebut() {
		return this.datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefinestimee() {
		return this.datefinestimee;
	}

	public void setDatefinestimee(Date datefinestimee) {
		this.datefinestimee = datefinestimee;
	}

	public Date getDatefinreel() {
		return this.datefinreel;
	}

	public void setDatefinreel(Date datefinreel) {
		this.datefinreel = datefinreel;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<Tache> getTaches() {
		return this.taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public Tache addTach(Tache tach) {
		getTaches().add(tach);
		tach.setModule(this);

		return tach;
	}

	public Tache removeTach(Tache tach) {
		getTaches().remove(tach);
		tach.setModule(null);

		return tach;
	}

}