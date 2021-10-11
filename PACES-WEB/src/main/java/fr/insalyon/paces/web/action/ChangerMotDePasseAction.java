package fr.insalyon.paces.web.action;

import fr.insalyon.paces.metier.service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zakaria
 */
public class ChangerMotDePasseAction extends Action {
    
    @Override
    public void executer(HttpServletRequest request) {
        
        HttpSession session = request.getSession(); 
        Service service = new Service();
        
        Long id = (Long) session.getAttribute("idEtudiant");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        
        int resultat = service.changerMotDePasse(id, oldPassword, newPassword);
        if(resultat != 1) {
            request.setAttribute("result",false);
            request.setAttribute("errorCode",resultat); // 0 -> verification echouee; 2 -> non-applicable
        } else {
            request.setAttribute("result",true);
        }
        
    }
}
