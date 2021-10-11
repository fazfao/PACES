/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.metier.service;

/**
 *
 * @author zihao
 */

import fr.insalyon.paces.dao.*;
import fr.insalyon.paces.metier.modele.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Service {
    protected EtudiantDao etudiantDao = new EtudiantDao();
    protected FiliereDao filiereDao = new FiliereDao();
    protected NoteDao noteDao = new NoteDao();
    
    public Long authentifier(String login, String motDePasse){
        long resultat = -1;
        JpaUtil.creerContextePersistance();
        try {
            if(login.contains("@")){
                resultat = etudiantDao.authentifierParMail(login,motDePasse);
            } else {
                resultat = etudiantDao.authentifier(login, motDePasse);
            }
        } catch (Exception ex) {
            System.out.println("in the catch");
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service authentifier(login,motDePasse)", ex);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        System.out.println("result" + resultat);
        return resultat;
    }
    public Etudiant rechercherEtudiantParId(Long id){
        Etudiant resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = etudiantDao.chercherParId(id);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherEtudiantParId()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public int changerMotDePasse(Long id,String ancien,String nouveau){
        int result = 0;
        Etudiant e = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            e = etudiantDao.chercherParId(id);
            if(ancien.equals(e.getPassword())){
                e.setPassword(nouveau);
                result = 1;
            }
            etudiantDao.update(e);
            JpaUtil.validerTransaction();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherEtudiantParId()", ex);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return result;
    }
    public boolean changerMail(Long id,String mail){
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            Etudiant e = etudiantDao.chercherParId(id);
            e.setMail(mail);
            etudiantDao.update(e);
            JpaUtil.validerTransaction();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherEtudiantParId()", ex);
            return false;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return true;
    }
    public boolean changerListeVoeux(Long id,String liste){
        String res = "";
        boolean resultat = false;
        Etudiant e = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            e = etudiantDao.chercherParId(id);
            if(e.getAdmission()==null){
                String[] listeVoeuxApresSplit = liste.split(",");
                for(int i=0;i<listeVoeuxApresSplit.length;i++){
                    res += filiereDao.convertirEnId(listeVoeuxApresSplit[i]);
                    if(i!=listeVoeuxApresSplit.length-1)
                        res += ",";
                }
                e.setListeVoeux(res);
                etudiantDao.update(e);
                resultat = true;
            }
            JpaUtil.validerTransaction();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherEtudiantParId()", ex);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public List<Note> obtenirBulletin(Long id) {
        List<Note> resultat = null;  
        JpaUtil.creerContextePersistance();
        try {
            resultat = noteDao.chercherNotesParId(id);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherEtudiantParId()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    public String obtenirListeVoeux(Etudiant e){
        String resultat = "";
        
        JpaUtil.creerContextePersistance();
        try {
            String[] listeVoeuxApresSplit = e.getListeVoeux().split(",");
            for(int i=0;i<listeVoeuxApresSplit.length;i++){
                resultat += filiereDao.obtenirDenomination(Long.parseLong(listeVoeuxApresSplit[i]));
                if(i!=listeVoeuxApresSplit.length-1)
                    resultat += ",";
            }
        } catch (NumberFormatException ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service obtenirListeVoeux()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    public String obtenirAdmission(Etudiant e){
        String resultat = "";
        JpaUtil.creerContextePersistance();
        try {
            if(e.getAdmission()!=null){
                resultat = filiereDao.obtenirDenomination(e.getAdmission());
            }
        } catch (NumberFormatException ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service obtenirListeVoeux()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    public double obtenirNoteMoyenne(Long fid){
        double resultat;
        JpaUtil.creerContextePersistance();
        try {
            resultat = noteDao.getNoteMoyenne(fid);
        } catch (NumberFormatException ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service obtenirListeVoeux()", ex);
            resultat = -1.0;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    // <editor-fold defaultstate="collapsed" desc="Main functions. Click on the + sign on the left to edit the code.">
    public List<Etudiant> listerEtudiant() {
        List<Etudiant> resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = etudiantDao.listerEtudiants();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerEtudiant()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    public List<Filiere> listerFiliere() {
        List<Filiere> resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = filiereDao.listerFilieres();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerFilieres()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    public void initialiserFiliere(List<Filiere> filiere){
        List<Note> notes;
        JpaUtil.creerContextePersistance();
        try {
            for(Filiere f : filiere){
                f.setRang(new LinkedList<>());
                List<Etudiant> uneListeRang = new ArrayList<>();
                notes = noteDao.chercherParFiliereId(f.getId());
                for(Note n : notes){
                    double note1 = n.getNote();
                    if(!uneListeRang.isEmpty()){
                        double note2 = noteDao.chercherParLesDeux(uneListeRang.get(uneListeRang.size() - 1).getId(),f.getId()).getNote();
                        if(note1 == note2){
                            double noteMoy1 = noteDao.getNoteMoyenneEtudiant(n.getEtudiant().getId());
                            double noteMoy2 = noteDao.getNoteMoyenneEtudiant(uneListeRang.get(uneListeRang.size() - 1).getId());
                            if(noteMoy1>noteMoy2){
                                uneListeRang.add(uneListeRang.size()-1,n.getEtudiant());
                            } else {
                                uneListeRang.add(n.getEtudiant());
                            }
                        } else {
                            uneListeRang.add(n.getEtudiant());
                        }
                    } else {
                        uneListeRang.add(n.getEtudiant());
                    }
                    n.setRangGlobal(uneListeRang.indexOf(n.getEtudiant())+1);
                    //n.setRangParmiLesAdmis(f.getRang().indexOf(n.getEtudiant())+1);
                    JpaUtil.ouvrirTransaction();
                    noteDao.update(n);
                    JpaUtil.validerTransaction();
                }
                f.setListeRang(uneListeRang);
            }
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service initialiserFiliere()", ex);
            notes = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
    }
    public void initialiserEtudiant(List<Etudiant> etudiant){
        for(Etudiant e:etudiant){
            String[] listeVoeuxApresSplit = e.getListeVoeux().split(",");
            int[][] unTab = new int[2][listeVoeuxApresSplit.length];
            for(int i=0;i<listeVoeuxApresSplit.length;i++){
                unTab[0][i]=Integer.parseInt(listeVoeuxApresSplit[i]);
                unTab[1][i]=1;
            }
            e.setListeVoeuxTab(unTab);
        }
    }
    
    public boolean mariage(){
        boolean result = true;
        List<Etudiant> etudiant = listerEtudiant();
        List<Filiere> filiere = listerFiliere();
        initialiserFiliere(filiere);
        initialiserEtudiant(etudiant);
        Map<Integer, Integer> etud = new HashMap<>(); 			// hashmap représentant la situation d'admission
        Map<Integer, Integer> luvletter = new HashMap<>(); 		// hashmap représentant les demandes des étudiants
        // HashMap <Etudiant.id, Filiere.id>

        //initialiser le hashmap etud
        for (Etudiant e:etudiant) {
            etud.put(e.getId().intValue(),-1);
        }
        while(etud.containsValue(-1)){

            //les étudiants envoient leur demande ("lettre d'amour")
            for (Etudiant e:etudiant) {
                    if (etud.get(e.getId().intValue()) == -1) { 								// tant que cet étudiant n'est pas admis
                            for (int j = 0; j < filiere.size(); j++) {
                                    if (e.getListeVoeuxTab()[1][j] != -1) {
                                            luvletter.put(e.getId().intValue(),e.getListeVoeuxTab()[0][j]);		// il parcourt sa listeVoeux et envoyer la demande à sa filière préférée et disponible
                                            break;
                                    }
                            }
                    }
            }
            if(luvletter.isEmpty()){  											// si le nombre total des étudiants est supérieur à la somme des nbMax 
                    break;															// on saute le boucle
            }	
            System.out.println(luvletter);

            //les filières traitent les demandes recus
            for (Filiere f:filiere) {
                List<Long> rank = new ArrayList<>();
                for(Etudiant une : f.getListeRang()){
                    rank.add(une.getId());
                }
                //System.out.println(f.getNomFiliere()+" ranklist: "+f.getListeRang());
                for (Etudiant e:etudiant) {
                    if (luvletter.get(e.getId().intValue()) != null) {
                        if (luvletter.get(e.getId().intValue()) == f.getId().intValue()) {                              // si e envoie une demande à f			
                            if (f.getNbCurrent()<f.getNbMax()) {                                                        // si f n'est pas pleine, on put une couple 	
                                etud.put(e.getId().intValue(), f.getId().intValue()); 					// dans etud.
                                if(f.getNbCurrent()==0){
                                        f.getRang().add(e);
                                } else {
                                    for(int i = 0; i<f.getNbCurrent(); i++){
                                        if(rank.indexOf(f.getRang().get(i).getId())>rank.indexOf(e.getId())){
                                            f.getRang().add(i,e);					// insertion dans le bon endroit du Filiere.getRang()
                                            break;
                                        }
                                        if(i == f.getNbCurrent()-1){
                                            f.getRang().add(e);
                                        }
                                    }
                                }
                                f.addNbCurrent();								// nbCurrent++
                            } else {												// s'il n'y a plus de place
                                for(int i = 0; i<f.getNbCurrent(); i++){		// on l'insère dans la List Filiere.getRang() en respectant l'ordre
                                    if(rank.indexOf(f.getRang().get(i).getId())>rank.indexOf(e.getId())){
                                        f.getRang().add(i,e);						// si cet étudiant n'est pas à la fin de liste
                                        etud.put(e.getId().intValue(), f.getId().intValue());			// on l'affecte la place
                                                                                                                        // puis élimine le dernier étudiant
                                        for(int j = 0; j<f.getRang().get(f.getNbCurrent()).getListeVoeuxTab()[0].length; j++){
                                            if(f.getRang().get(f.getNbCurrent()).getListeVoeuxTab()[0][j]==f.getId().intValue())
                                                f.getRang().get(f.getNbCurrent()).getListeVoeuxTab()[1][j]=-1;
                                            break;
                                        }

                                        etud.put(f.getRang().get(f.getNbCurrent()).getId().intValue(), -1);
                                        f.getRang().remove(f.getNbCurrent());
                                        break;
                                    }
                                    if(i == f.getNbCurrent()-1){				// si cet étudiant se trouve à la fin de liste
                                        for(int j = 0; j<e.getListeVoeuxTab()[0].length; j++){
                                            if(e.getListeVoeuxTab()[0][j]==f.getId().intValue()){	// il sera refusé
                                                e.getListeVoeuxTab()[1][j]=-1;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }   
                    }
                }
                //System.out.println(f.getNomFiliere()+": "+f.getRang());
            }
            luvletter.clear();													// remise à zéro de demande pour le prochain tour
        }
        
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            for(Etudiant e:etudiant){
                e.setAdmission(new Long(etud.get(e.getId().intValue())));	 // attribuer le résultat final aux étudiants
                
                etudiantDao.update(e);
            }
            Note n;
            for(Filiere f:filiere){
                for(Etudiant e:etudiant){
                    n = noteDao.chercherParLesDeux(e.getId(), f.getId());
                    n.setRangParmiLesAdmis(f.getRang().indexOf(e)+1);
                    noteDao.update(n);
                }
                
                double min = f.getNbCurrent()*(f.getNbCurrent()-1)/2.0;
		double max = (2*f.getListeRang().size()-1-f.getNbCurrent())*f.getNbCurrent()/2.0;
                double moy = noteDao.getRankMoyenne(f.getId());
                System.out.println("moy:"+moy+" max:"+max+" min:"+min);
                double qua = (max-moy*f.getNbCurrent())/(max-min);
                qua = ((int)(qua*1000))/1000.0;
                f.setQuality(qua);
                
                filiereDao.update(f);
                System.out.println(f.getNomFiliere() + ": " + f.getRang()+"; Quality:"+f.getQuality());
            }
            JpaUtil.validerTransaction();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service mariage(List<Etudiant> etudiant, List<Filiere> filiere)", ex);
            result = false;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return result;
    }
    // </editor-fold>
}
