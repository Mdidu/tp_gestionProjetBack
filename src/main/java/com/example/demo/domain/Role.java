package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the "ROLES" database table.
 * 
 */
@Entity
@Table(name="ROLES")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ROLE_SEQ")
    @SequenceGenerator(name = "ROLE_SEQ", sequenceName = "ROLE_SEQ", allocationSize = 1)
	@Column(name = "ID_ROLE", unique = true, nullable = false, precision = 22, scale = 0)
	private long idrole;

	@Enumerated(EnumType.STRING)
	private ERole libelle;

	public Role() {
	}
	
	public Role(ERole libelle) {
		this.libelle = libelle;
	}

	public long getIdrole() {
		return this.idrole;
	}

	public void setIdrole(long idrole) {
		this.idrole = idrole;
	}

	public ERole getLibelle() {
		return this.libelle;
	}

	public void setLibelle(ERole libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Role [idrole=" + idrole + ", libelle=" + libelle + "]";
	}

}