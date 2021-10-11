/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.web.action;

import fr.insalyon.paces.metier.modele.Etudiant;
import fr.insalyon.paces.metier.service.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 *
 * @author zihao
 */
public class AfficherProfilAction extends Action {
    @Override
    public void executer(HttpServletRequest request) {
        
        HttpSession session = request.getSession(); 
        Service service = new Service();
        Etudiant etudiant = null;
        String nom;
        String genre;
        String email;
        Date date;
        String liste;
        
        Long id = (Long) session.getAttribute("idEtudiant");
        if(id!=null) {
            etudiant = service.rechercherEtudiantParId(id);
        } else {
            request.setAttribute("notLoggedIn", true);
        }
        if(etudiant!=null) {
            nom = etudiant.getNom() + " " + etudiant.getPrenom();
            genre = etudiant.getGenre();
            email = etudiant.getMail();
            date = etudiant.getDateNaissance();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(date);
            liste = service.obtenirListeVoeux(etudiant);
            request.setAttribute("nom", nom);
            request.setAttribute("genre", genre);
            request.setAttribute("dateNaissance", dateString);
            request.setAttribute("liste", liste);
            request.setAttribute("mail", email);
        }
    }
}