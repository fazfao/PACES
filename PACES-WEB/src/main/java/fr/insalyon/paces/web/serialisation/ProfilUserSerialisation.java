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
 * @author zakaria
 */
public class ProfilUserSerialisation extends Serialisation {
    
     @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession(); 
        String userType = (String) session.getAttribute("userType"); 
        Boolean connexion = false;
        JsonObject container = new JsonObject();
        if(userType!=null) {
            if(userType.equals("etudiant")) {
                Object etudiantId = request.getAttribute("etudiant");
                connexion = (etudiantId != null);
                if (etudiantId != null) {
                    container.addProperty("etudiant", (long) etudiantId);
                }
                container.addProperty("user", userType);
            }
            else if (userType.equals("admin")) {
                connexion = true;
                container.addProperty("user", userType);
            }           
        }
        container.addProperty("connexion", connexion);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();
    }
}
