package com.example.demo.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    
    @NotBlank
    @Size(max = 50)
    private String nom;
    
    @NotBlank
    @Size(max = 50)
    private String prenom;
    
    @NotBlank
    @Size(max = 50)
    @Email
    private String mail;
    
    private long role;
    
    private long departement;
    
    private long projet;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String pwd;
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
    
    public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public long getRole() {
      return this.role;
    }
    
    public void setRole(long role) {
      this.role = role;
    }

	public long getDepartement() {
		return departement;
	}

	public void setDepartement(long departement) {
		this.departement = departement;
	}

	public long getProjet() {
		return projet;
	}

	public void setProjet(long projet) {
		this.projet = projet;
	}

	@Override
	public String toString() {
		return "SignupRequest [username=" + username + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail
				+ ", role=" + role + ", departement=" + departement + ", projet=" + projet + ", pwd=" + pwd + "]";
	}

	
}