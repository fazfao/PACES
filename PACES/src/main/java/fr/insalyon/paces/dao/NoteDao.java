/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.dao;

import fr.insalyon.paces.metier.modele.Note;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
/**
 *
 * @author zihao
 */
public class NoteDao {
    
    public void creer(Note note) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(note);
    }
    
    public void update(Note note) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.merge(note);
    }
    
    public void supprimer(Note note) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.remove(note);
    }
    
    public Note chercherParId(Long id) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Note.class, id);
    }
    
    public List<Note> chercherParFiliereId(Long id) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Note> query = em.createQuery("SELECT e FROM Note e WHERE e.filiere.id = :aId ORDER BY e.note DESC", Note.class);
        query.setParameter("aId", id);
        List<Note> notes = query.getResultList();
        return notes;
    }
    
    public Note chercherParLesDeux(Long id_etudiant, Long id_filiere) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Note> query = em.createQuery("SELECT e FROM Note e WHERE e.etudiant.id = :idEtudiant AND e.filiere.id = :idFiliere", Note.class);
        query.setParameter("idEtudiant", id_etudiant);
        query.setParameter("idFiliere", id_filiere);
        return query.getResultList().get(0);
    }
    
    public List<Note> listerNotes() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Note> query = em.createQuery("SELECT e FROM Note e ORDER BY e.id ASC", Note.class);
        return query.getResultList();
    }
    
    public List<Note> chercherNotesParId(Long id){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Note> query = em.createQuery("SELECT e FROM Note e WHERE e.etudiant.id = :id", Note.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
    
    public double getNoteMoyenneEtudiant(Long idEtudiant){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Note> query = em.createQuery("SELECT e FROM Note e WHERE e.etudiant.id = :id", Note.class);
        query.setParameter("id", idEtudiant);
        List<Note> notes = query.getResultList();
        double result = 0.0;
        for(Note n:notes){
            result += n.getNote();
        }
        result *= (double)(1/notes.size());
        return result;
    }
    
    public double getNoteMoyenne(Long idFiliere){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Note> query = em.createQuery("SELECT e FROM Note e WHERE e.filiere.id = :id AND e.rangParmiLesAdmis <> 0", Note.class);
        query.setParameter("id", idFiliere);
        List<Note> notes = query.getResultList();
        double result = 0.0;
        for(Note n:notes){
            result += n.getNote();
        }
        result = result/((double)(notes.size()));
        result = (int)(result*100)/100.0;
        return result;
    }
    
    public double getRankMoyenne(Long idFiliere){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Note> query = em.createQuery("SELECT e FROM Note e WHERE e.filiere.id = :id AND e.rangParmiLesAdmis <> 0", Note.class);
        query.setParameter("id", idFiliere);
        List<Note> notes = query.getResultList();
        double result = 0.0;
        for(Note n:notes){
            result += n.getRangGlobal();
        }
        result = result/notes.size();
        result = ((int)(result*100))/100.0;
        return result;
    }
}
