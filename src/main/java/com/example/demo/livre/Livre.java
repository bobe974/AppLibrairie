package com.example.demo.livre;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.categorie.Categorie;
import com.example.demo.emprunt.Emprunt;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIVRE")
public class Livre {

	private Integer id;

    private String titre;
    
    private String isbn;
    
    private LocalDate dateDeSortie;
    
    private LocalDate dateEnregistrement;
    
    private Integer nbExemplaire;
    
    private String auteur;
    
    private Categorie category;
    
    Set<Emprunt> loans = new HashSet<Emprunt>();
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_LIVRE")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "TITRE", nullable = false)
    public String getTitle() {
        return titre;
    }

    public void setTitle(String title) {
        this.titre = title;
    }

    @Column(name = "ISBN", nullable = false, unique = true)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "DATE_DE_SORTIE", nullable = false)
    public LocalDate getReleaseDate() {
        return dateDeSortie;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.dateDeSortie = releaseDate;
    }
    
    @Column(name = "DATE_ENREGISTREMENT", nullable = false)
    public LocalDate getRegisterDate() {
        return dateEnregistrement;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.dateEnregistrement = registerDate;
    }

    @Column(name = "NB_EXEMPLAIRE")
    public Integer getTotalExamplaries() {
        return nbExemplaire;
    }

    public void setTotalExamplaries(Integer totalExamplaries) {
        this.nbExemplaire = totalExamplaries;
    }

    @Column(name = "AUTEUR")
    public String getAuthor() {
        return auteur;
    }

    public void setAuthor(String author) {
        this.auteur = author;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "CAT_CODE", referencedColumnName = "CODE")
    public Categorie getCategory() {
        return category;
    }

    public void setCategory(Categorie category) {
        this.category = category;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.book", cascade = CascadeType.ALL)
    public Set<Emprunt> getLoans() {
        return loans;
    }

    public void setLoans(Set<Emprunt> loans) {
        this.loans = loans;
    }
}
