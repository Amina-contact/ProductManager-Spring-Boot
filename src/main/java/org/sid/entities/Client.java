package org.sid.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Client {
	//pour dire que id est le cle primaire
	@Id 
	//pour l'auto_incrementation
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long idClient;
	
	private String nom;
	
	private String prenom;
	
	private String adresse;

	private String photo;
	
	private String mail;
	
	private String tele;


	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(Long idClient, String nom, String prenom, String adresse, String photo, String mail,String tele) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.photo = photo;
		this.mail = mail;
		this.tele = tele;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}
	

}
