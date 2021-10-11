package fr.insalyon.paces.web.action;

import fr.insalyon.paces.metier.service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zakaria
 */
public class ChangerMailAction extends Action {
    
    @Override
    public void executer(HttpServletRequest request) {
        
        HttpSession session = request.getSession(); 
        Service service = new Service();
        
        boolean resultat = false;
        Long id = (Long) session.getAttribute("idEtudiant");
        String mail = (String) session.getAttribute("mailAModifier");
        String code = request.getParameter("vcode");
        String error = "Jpa erreur";
        if(id!=null){
            if(session.getAttribute("vcode").equals(code)){
                if(System.currentTimeMillis() - (long)(session.getAttribute("timestamp"))<10*60*1000){
                    //vérification réussie
                    resultat = service.changerMail(id, mail);
                } else {
                    //code expiré
                    error = "code expiré";
                }
            } else {
                //mauvais code
                error = "mauvais code";
            }
        }
            
        request.setAttribute("result",resultat);
        if(!resultat) {
            request.setAttribute("error",error); // 0 -> verification echouee; 2 -> non-applicable
        }
    }
}
