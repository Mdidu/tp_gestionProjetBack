package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PROJETS database table.
 * 
 */
@Entity
@Table(name="PROJETS")
public class Projet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idprojet;

	private String client;

	private BigDecimal code;

	private String column1;

	private String column2;

	private Date datedebut;

	private Date datefinestimee;

	private Date datefinreel;

	private String description;

	//bi-directional many-to-one association to Employe
	@OneToMany(mappedBy="projet")
	private List<Employe> employes;

	//bi-directional many-to-one association to Module
	@OneToMany(mappedBy="projet")
	private List<Module> modules;

	public Projet() {
	}

	public long getIdprojet() {
		return this.idprojet;
	}

	public void setIdprojet(long idprojet) {
		this.idprojet = idprojet;
	}

	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public BigDecimal getCode() {
		return this.code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
	}

	public String getColumn1() {
		return this.column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public String getColumn2() {
		return this.column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employe> getEmployes() {
		return this.employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public Employe addEmploye(Employe employe) {
		getEmployes().add(employe);
		employe.setProjet(this);

		return employe;
	}

	public Employe removeEmploye(Employe employe) {
		getEmployes().remove(employe);
		employe.setProjet(null);

		return employe;
	}

	public List<Module> getModules() {
		return this.modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public Module addModule(Module module) {
		getModules().add(module);
		module.setProjet(this);

		return module;
	}

	public Module removeModule(Module module) {
		getModules().remove(module);
		module.setProjet(null);

		return module;
	}

}