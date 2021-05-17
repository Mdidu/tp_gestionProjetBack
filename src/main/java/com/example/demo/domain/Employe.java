package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMPLOYES database table.
 * 
 */
@Entity
@Table(name="EMPLOYES")
public class Employe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idemploye;

	private String column1;

	private java.math.BigDecimal idrole;

	private String mail;

	private String nom;

	private String pwd;

	//bi-directional many-to-one association to Departement
	@ManyToOne
	@JoinColumn(name="IDDEPARTEMENT")
	private Departement departement;

	//bi-directional many-to-one association to Projet
	@ManyToOne
	@JoinColumn(name="IDPROJET")
	private Projet projet;

	public Employe() {
	}

	public long getIdemploye() {
		return this.idemploye;
	}

	public void setIdemploye(long idemploye) {
		this.idemploye = idemploye;
	}

	public String getColumn1() {
		return this.column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public java.math.BigDecimal getIdrole() {
		return this.idrole;
	}

	public void setIdrole(java.math.BigDecimal idrole) {
		this.idrole = idrole;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Departement getDepartement() {
		return this.departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

}