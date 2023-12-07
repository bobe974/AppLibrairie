package com.example.demo.client;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.emprunt.Emprunt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Client {
	
	private String idClient, nom, prenom, travail, email, adresse;
	private LocalDate dateCreation;
	Set<Emprunt> loans = new HashSet<Emprunt>();
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CLIENT")
	public String getIdClient() {
		return idClient;		
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	@Column(name = "NOM")
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Column(name = "PRENOM")
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Column(name = "TRAVAIL")
	public String getTravail() {
		return travail;
	}
	public void setTravail(String travail) {
		this.travail = travail;
	}
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "ADRESSE")
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@Column(name = "DATE_CREATION", nullable = false)
	public LocalDate getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	

	
}
