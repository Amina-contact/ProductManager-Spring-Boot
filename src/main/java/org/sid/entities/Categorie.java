package org.sid.entities;

import java.util.Collection;
//import java.util.List;

import javax.persistence.Entity;
//import javax.persistence.Access;
//import javax.persistence.AccessType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Categorie {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long idCat;
	
	@NotNull
	@Size(min=5,max=50)
	private String nomCat;
	
	//@Access(AccessType.PROPERTY)
	//@OneToMany(mappedBy = "categorie", fetch=FetchType.LAZY)
	@OneToMany(mappedBy="categorie", fetch=FetchType.LAZY)
	private Collection <Produit> produits;
	//private List<Produit> produits;
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(Long id,String nomCat) {
		super();
		this.idCat = id;
		this.nomCat = nomCat;
	}
	public Long getIdCat() {
		return idCat;
	}
	public void setIdCat(Long id) {
		this.idCat = id;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	public Collection<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}
	
   

	

}
