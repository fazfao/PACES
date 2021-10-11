/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.metier.modele;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author zihao
 */
@Entity
public class Note implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private Filiere filiere;
    private Double note;
    private Integer rangGlobal;
    private Integer rangParmiLesAdmis;


    protected Note(){}
    
    public Note(Etudiant etudiant, Filiere filiere, Double score) {
        this.etudiant = etudiant;
        this.filiere = filiere;
        note = score;
        rangGlobal = null;
        rangParmiLesAdmis = null;
    }

    public Double getNote() {
        return note;
    }

    public Long getId() {
        return id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public Integer getRangGlobal() {
        return rangGlobal;
    }

    public Integer getRangParmiLesAdmis() {
        return rangParmiLesAdmis;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public void setRangGlobal(Integer rank) {
        this.rangGlobal = rank;
    }

    public void setRangParmiLesAdmis(Integer rangParmiLesAdmis) {
        this.rangParmiLesAdmis = rangParmiLesAdmis;
    }
    
}
