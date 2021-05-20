package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;


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

	private String libelle;

	public Role() {
	}

	public long getIdrole() {
		return this.idrole;
	}

	public void setIdrole(long idrole) {
		this.idrole = idrole;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Role [idrole=" + idrole + ", libelle=" + libelle + "]";
	}

}