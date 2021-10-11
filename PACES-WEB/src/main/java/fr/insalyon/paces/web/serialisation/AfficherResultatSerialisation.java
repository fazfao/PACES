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
public class AfficherResultatSerialisation extends Serialisation {
    @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        
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
        if(request.getAttribute("admission")!=null) {
            container.addProperty("admission", (String) request.getAttribute("admission"));
        }
        if(request.getAttribute("notes")!=null) {
            container.addProperty("notes", (String) request.getAttribute("notes"));
        }
        if(request.getAttribute("info1")!=null) {
            container.addProperty("info1", (String) request.getAttribute("info1"));
        }
        if(request.getAttribute("info2")!=null) {
            container.addProperty("info2", (String) request.getAttribute("info2"));
        }
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();
    }
}
