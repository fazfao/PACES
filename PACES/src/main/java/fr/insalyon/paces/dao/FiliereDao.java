/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.dao;

import fr.insalyon.paces.metier.modele.Filiere;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author zihao
 */
public class FiliereDao {
    public void creer(Filiere filiere) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(filiere);
    }
    
    public void update(Filiere filiere) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.merge(filiere);
    }
    
    public void supprimer(Filiere filiere) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.remove(filiere);
    }
    
    public Filiere chercherParId(Long id) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Filiere.class, id);
    }
    
    public List<Filiere> listerFilieres() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Filiere> query = em.createQuery("SELECT e FROM Filiere e ORDER BY e.id ASC", Filiere.class);
        return query.getResultList();
    }
    
    public String obtenirDenomination(Long id){
        if(id!=-1){
            EntityManager em = JpaUtil.obtenirContextePersistance();
            return em.find(Filiere.class, id).getNomFiliere();
        } else {
            return "Non-admission";
        }
    }
    
    public String convertirEnId(String denomination){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Filiere> query = em.createQuery("SELECT e FROM Filiere e where e.nomFiliere = :denomination ORDER BY e.id ASC", Filiere.class);
        query.setParameter("denomination", denomination);
        return String.valueOf(query.getResultList().get(0).getId());
    }
}
