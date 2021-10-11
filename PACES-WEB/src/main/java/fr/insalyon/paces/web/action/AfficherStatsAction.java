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
import fr.insalyon.paces.metier.modele.Filiere;
import fr.insalyon.paces.metier.modele.Note;
import fr.insalyon.paces.metier.service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 *
 * @author zihao
 */
public class AfficherStatsAction extends Action {
    @Override
    
    public void executer(HttpServletRequest request) {
        
        HttpSession session = request.getSession(); 
        Service service = new Service();
        List<Filiere> fs = null;
        String info1 = "";
        String info2 = "[";
        double noteMoyenne;
        
        Gson gson = new Gson();
        
        String userType = (String) session.getAttribute("userType");
        if(!"null".equals(userType)) {
            fs = service.listerFiliere();
        } else {
            request.setAttribute("notLoggedIn", true);
        }
        if(fs!=null) {
            for(Filiere f:fs){
                noteMoyenne = service.obtenirNoteMoyenne(f.getId());
                info2 += "{\"filiere\":\""+f.getNomFiliere()+"\",\"noteMoyenne\":"+noteMoyenne+"},";
            }
            info2 = info2.substring(0, info2.length()-1) + "]";
            request.setAttribute("info2", info2);
       
            info1 = gson.toJson(fs);
            request.setAttribute("info1",info1);
        }
    }
}