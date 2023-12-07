package com.example.demo.categorie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "CATEGORIE")

public class Categorie {
	
	private String idCategorie, label;

	public Categorie(String idCategorie, String label) {
		this.setIdCategorie(idCategorie);
		this.setLabel(label);
	}
	@Id
	@Column(name="CODE")
	public String getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}

	@Column(name="LABEL")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
