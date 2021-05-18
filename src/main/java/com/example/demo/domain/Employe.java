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

	private String prenom;

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

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="IDROLE")
	private Role role;
		
	public Employe() {
	}

	public long getIdemploye() {
		return this.idemploye;
	}

	public void setIdemploye(long idemploye) {
		this.idemploye = idemploye;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}