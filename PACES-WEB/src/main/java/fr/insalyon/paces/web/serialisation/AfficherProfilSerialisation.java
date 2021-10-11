/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.web.serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zihao
 */
public class AfficherProfilSerialisation extends Serialisation {
    @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String userType = null;
        HttpSession session = request.getSession(); 
        //Long id = (Long) session.getAttribute("idEtudiant");
        /*
        if(id!=null) {
            userType = "client";
        }else{
            id = (Long) session.getAttribute("idEmploye");
            if(id!=null) {
                userType = "employe";
            }
        }
        */
        
        JsonObject container = new JsonObject();
        
        if(request.getAttribute("notLoggedIn")!=null) {
            container.addProperty("notLoggedIn", (Boolean) request.getAttribute("notLoggedIn"));
        }
        if(request.getAttribute("nom")!=null) {
            container.addProperty("nom", (String) request.getAttribute("nom"));
        }
        if(request.getAttribute("genre")!=null) {
            container.addProperty("genre", (String) request.getAttribute("genre"));
        }
        if(request.getAttribute("liste")!=null) {
            container.addProperty("liste", (String) request.getAttribute("liste"));
        }
        if(request.getAttribute("mail")!=null) {
            container.addProperty("mail", (String) request.getAttribute("mail"));
        }
        if(request.getAttribute("dateNaissance")!=null) {
            container.addProperty("dateNaissance", (String) request.getAttribute("dateNaissance"));
        }
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();
    }
}
