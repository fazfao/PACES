/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.metier.modele;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author zihao
 */
@Entity
public class Etudiant implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String mail; 
    private String password;
    private String genre;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String listeVoeux;
    @Transient
    private int[][] listeVoeuxTab;
    private Long admission;
    private boolean admin;

    protected Etudiant(){
    }
    
    public Etudiant(String unNom, String unPrenom, String uneListe){
        mail = null;
        password = "123456";
        nom = unNom;
        prenom = unPrenom;
        listeVoeuxTab = null;
        listeVoeux = uneListe;
        admission = null;
        admin = false;
    }
    
    public Etudiant(String unNom, String unPrenom, boolean admin){
        mail = "@admin";
        password = "admin";
        nom = unNom;
        prenom = unPrenom;
        listeVoeuxTab = null;
        listeVoeux = null;
        admission = null;
        this.admin = admin;
    }
    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getGenre() {
        return genre;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getListeVoeux() {
        return listeVoeux;
    }

    public Long getId(){
            return this.id;
    }

    public Long getAdmission(){
            return this.admission;
    }

    public String getListe(){
            return this.listeVoeux;
    }

    public int[][] getListeVoeuxTab() {
        return listeVoeuxTab;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setListeVoeux(String uneListe) {
        this.listeVoeux = uneListe;
    }

    public void setAdmission(Long ad){
            this.admission = ad;
    }

    public void setListeVoeuxTab(int[][] listeVoeuxTab) {
        this.listeVoeuxTab = listeVoeuxTab;
    }
    
    @Override
    public String toString() {
        return "Etudiant{id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", voeux=" + listeVoeux + ", admission=" + admission;
    }
}
