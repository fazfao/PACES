package fr.insalyon.paces.web.action;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author zakaria
 */
public abstract class Action {
    
    public abstract void executer(HttpServletRequest request);
}
