package com.example.demo.emprunt;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.demo.client.Client;
import com.example.demo.livre.Livre;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class EmpruntId implements Serializable {

    private static final long serialVersionUID = 3912193101593832821L;

    private Livre livre;
    private Client client;
    private LocalDateTime creationDateTime;

    public EmpruntId() {
		super();
	}

    

    public EmpruntId(Livre livre, Client client) {
        super();
        this.livre = livre;
        this.client = client;
        this.creationDateTime = LocalDateTime.now();
    }

    @ManyToOne
    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Column(name = "CREATION_DATE_TIME")
    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }
    
 

}
