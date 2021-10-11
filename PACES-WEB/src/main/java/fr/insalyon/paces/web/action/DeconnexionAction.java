package fr.insalyon.paces.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zakaria
 */
public class DeconnexionAction extends Action {
    
    @Override
    public void executer(HttpServletRequest request) {
        
        // Gestion de la Session: ici, enregistrer l'ID du Client authentifié
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
