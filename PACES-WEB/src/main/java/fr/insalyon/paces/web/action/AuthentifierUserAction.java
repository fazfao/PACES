package fr.insalyon.paces.web.action;

import fr.insalyon.paces.metier.service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zakaria
 */
public class AuthentifierUserAction extends Action {
    
    @Override
    public void executer(HttpServletRequest request) {
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        Service service = new Service();
        String userType;
        long id = service.authentifier(login, password);
        System.out.println(id);
        if(id != -1) {
            if(id != -2) {
            request.setAttribute("etudiant", id); 
            userType = "etudiant";
            } else {
                userType = "admin";
            }
        } else {
            userType = "null";
        }
        
        // Gestion de la Session: ici, enregistrer l'ID du Client authentifié
        HttpSession session = request.getSession();
        if (id >= 0) {
            session.setAttribute("idEtudiant", id);
        }
        session.setAttribute("userType", userType);
    }
}
