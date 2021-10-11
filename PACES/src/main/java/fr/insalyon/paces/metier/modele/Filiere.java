/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.metier.modele;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

/**
 *
 * @author zihao
 */
@Entity
public class Filiere implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomFiliere;
    @Transient
    private List<Etudiant> listeRang;
    private Integer nbMax;
    private Integer nbCurrent;
    @Transient
    private List<Etudiant> rang;
    private Double quality; //attribut représentant le rang moyen des etudiants admis

    protected Filiere() {
    }

    public Filiere(String unNom,int nbm){
        nomFiliere = unNom;
        listeRang = new ArrayList<>();
        nbMax = nbm;
        nbCurrent = 0;
        rang = new LinkedList<>();
        quality = -1.0;
    }

    public Long getId(){
        return this.id;
    }
    
    
    public String getNomFiliere(){
        return this.nomFiliere;
    }

    public List<Etudiant> getListeRang() {
        return listeRang;
    }

    public int getNbMax(){
        return this.nbMax;
    }

    public int getNbCurrent(){
        return this.nbCurrent;
    }

    /*public String getRang(){
        String res ="";
        res = rang.stream().map(e -> e.getId()+" ").reduce(res, String::concat);
        return res;
    }*/

    public List<Etudiant> getRang(){
        return this.rang;
    }

    public double getQuality() {
        /*double moyenne = 0.0;
        for(Etudiant e : rang){
        moyenne += listeRang.indexOf(e.getId());
        }
        double min = nbCurrent*(nbCurrent-1)/2.0;
        double max = (2*listeRang.size()-1-nbCurrent)*nbCurrent/2.0;
        //System.out.println("moy:"+moyenne+" max:"+max+" min:"+min);
        quality = (max-moyenne)/(max-min);*/
        return quality;
    }

    public void addNbCurrent(){
        this.nbCurrent++;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    public void setListeRang(List<Etudiant> listeRang) {
        this.listeRang = listeRang;
    }

    public void setNbMax(int nbMax) {
        this.nbMax = nbMax;
    }

    public void setNbCurrent(int nbCurrent) {
        this.nbCurrent = nbCurrent;
    }

    public void setRang(List<Etudiant> rang) {
        this.rang = rang;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }
    
    @Override
    public String toString() {
        return "Filiere{id=" + id + ", denomination=" + nomFiliere + ", Rank=" + listeRang + ", max=" + nbMax + ", reçu=" + nbCurrent + ", quality=" + quality + "}";
    }
}
