/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.web.action;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.insalyon.paces.metier.modele.Etudiant;
import fr.insalyon.paces.metier.modele.Note;
import fr.insalyon.paces.metier.service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 *
 * @author zihao
 */
public class AfficherResultatAction extends Action {
    @Override
    
    public void executer(HttpServletRequest request) {
        
        HttpSession session = request.getSession(); 
        Service service = new Service();
        Etudiant etudiant = null;
        List<Note> notes = null;
        String nom;
        String genre;
        String liste;
        String note;
        String admission;
        Gson gson = new Gson();
        
        Long id = (Long) session.getAttribute("idEtudiant");
        if(id!=null) {
            etudiant = service.rechercherEtudiantParId(id);
            notes = service.obtenirBulletin(id);
        } else {
            request.setAttribute("notLoggedIn", true);
        }
        if(etudiant!=null) {
            nom = etudiant.getNom() + " " + etudiant.getPrenom();
            genre = etudiant.getGenre();
            liste = service.obtenirListeVoeux(etudiant);
            admission = service.obtenirAdmission(etudiant);
            request.setAttribute("nom", nom);
            request.setAttribute("genre", genre);
            request.setAttribute("liste", liste);
            request.setAttribute("admission", admission);
        }
        if(notes!=null) {
            note = gson.toJson(notes);
            int begin;
            int end = 0;
            int lastend;
            while(note.contains("\"etudiant\"")){
                begin = note.indexOf("\"etudiant\"");
                lastend = end;
                end = note.indexOf("\"filiere\"",lastend+1);
                note = note.substring(0,begin) + note.substring(end);
            }
            
            
            //JsonObject jsonObject = (JsonObject) new JsonParser().parse(note); 
            //System.out.println(jsonObject);
            //jsonObject.remove("etudiant");
            //System.out.println(jsonObject);
            //note = jsonObject.getAsString();
            //System.out.println(note);
            request.setAttribute("notes",note);
        }
            
    }
}