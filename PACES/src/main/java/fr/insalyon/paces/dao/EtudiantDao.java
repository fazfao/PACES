/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.dao;

import fr.insalyon.paces.metier.modele.Etudiant;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
/**
 *
 * @author zihao
 */
public class EtudiantDao {
    
    public void creer(Etudiant etudiant) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(etudiant);
    }
    
    public void update(Etudiant etudiant) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.merge(etudiant);
    }
    
    public void supprimer(Etudiant etudiant) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.remove(etudiant);
    }
    
    public Etudiant chercherParId(Long id) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Etudiant.class, id);
    }
    
    public Etudiant chercherParMail(String mail) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Etudiant> query = em.createQuery("SELECT e FROM Etudiant e WHERE e.mail = :login", Etudiant.class);
        query.setParameter("login", mail);
        return query.getResultList().get(0);
    }
    
    public long authentifier(String login, String password) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Etudiant> query = em.createQuery("SELECT e FROM Etudiant e WHERE e.id = :login "
                + "ORDER BY e.id ASC", Etudiant.class);
        query.setParameter("login", Long.parseLong(login));
        Etudiant user = query.getResultList().get(0);
        if(user != null && (user.getPassword() == null ? password == null : user.getPassword().equals(password))){
            if(user.isAdmin()){
                return -2;
            } else {
                return user.getId();
            }
        } else {
            return -1;
        }
    }
        
    public long authentifierParMail(String login, String password) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Etudiant> query = em.createQuery("SELECT e FROM Etudiant e WHERE e.mail = :login "
                + "ORDER BY e.id ASC", Etudiant.class);
        query.setParameter("login", login);
        Etudiant user = query.getResultList().get(0);
        if(user != null && (user.getPassword() == null ? password == null : user.getPassword().equals(password))){
            if(user.isAdmin()){
                return -2;
            } else {
                return user.getId();
            }
        } else {
            return -1;
        }
    }
    
    public List<Etudiant> listerEtudiants() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Etudiant> query = em.createQuery("SELECT e FROM Etudiant e WHERE e.admin = false ORDER BY e.id ASC", Etudiant.class);
        return query.getResultList();
    }
    
    
}
