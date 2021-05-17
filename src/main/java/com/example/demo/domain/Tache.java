package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the TACHES database table.
 * 
 */
@Entity
@Table(name="TACHES")
public class Tache implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idtache;

	private Date datedebut;

	private Date datefinestimee;

	private Date datefinreel;

	private String libelle;

	//bi-directional many-to-one association to Module
	@ManyToOne
	@JoinColumn(name="IDMODULE")
	private Module module;

	public Tache() {
	}

	public long getIdtache() {
		return this.idtache;
	}

	public void setIdtache(long idtache) {
		this.idtache = idtache;
	}

	public Object getDatedebut() {
		return this.datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Object getDatefinestimee() {
		return this.datefinestimee;
	}

	public void setDatefinestimee(Date datefinestimee) {
		this.datefinestimee = datefinestimee;
	}

	public Object getDatefinreel() {
		return this.datefinreel;
	}

	public void setDatefinreel(Date datefinreel) {
		this.datefinreel = datefinreel;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}