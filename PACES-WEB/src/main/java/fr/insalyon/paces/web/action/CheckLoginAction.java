/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zihao
 */
public class CheckLoginAction extends Action {
    @Override
    public void executer(HttpServletRequest request) {
        HttpSession session = request.getSession(); 
        String userType = (String) session.getAttribute("userType"); 
        if("null".equals(userType)) {
            request.setAttribute("notLoggedIn", true);
        } else {
            request.setAttribute("notLoggedIn", false);
        }
    }
}
