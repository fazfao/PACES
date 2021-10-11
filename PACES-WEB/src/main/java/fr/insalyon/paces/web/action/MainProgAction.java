package fr.insalyon.paces.web.action;

import fr.insalyon.paces.metier.service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zakaria
 */
public class MainProgAction extends Action {
    
    @Override
    public void executer(HttpServletRequest request) {
        
        Service service = new Service();
        
        boolean resultat = service.mariage();
        request.setAttribute("result",resultat);
        
    }
}
