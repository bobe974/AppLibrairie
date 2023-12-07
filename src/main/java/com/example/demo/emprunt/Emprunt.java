package com.example.demo.emprunt;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AssociationOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPRUNT")
@AssociationOverrides({
@AssociationOverride(name = "pk.livre", joinColumns = @JoinColumn(name = "ID_LIVRE")),
@AssociationOverride(name = "pk.client", joinColumns = @JoinColumn(name = "ID_CLIENT"))})

public class Emprunt implements Serializable{

    private static final long serialVersionUID = 144293603488149743L;

    private EmpruntId pk = new EmpruntId();
    
    private LocalDate beginDate;
    
    private LocalDate endDate;
    
    private EnpruntStatut status;

    @EmbeddedId
    public EmpruntId getPk() {
        return pk;
    }

    public void setPk(EmpruntId pk) {
        this.pk = pk;
    }

    @Column(name = "DATE_DEBUT", nullable = false)
    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    @Column(name = "DATE_FIN", nullable = false)
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    public EmpruntStatut getStatus() {
        return status;
    }

    public void setStatus(EmpruntStatut status) {
        this.status = status;
    }
}
