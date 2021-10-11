package fr.insalyon.paces.web.action;

import fr.insalyon.paces.metier.service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zakaria
 */
public class ChangerVoeuxAction extends Action {
    
    @Override
    public void executer(HttpServletRequest request) {
        
        HttpSession session = request.getSession(); 
        Service service = new Service();
        
        Long id = (Long) session.getAttribute("idEtudiant");
        String liste = request.getParameter("liste");
        
        boolean resultat = service.changerListeVoeux(id, liste);
        request.setAttribute("result",resultat);
        
    }
}
