/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.web;

import fr.insalyon.paces.dao.JpaUtil;
import fr.insalyon.paces.web.action.*;
import fr.insalyon.paces.web.serialisation.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zakaria
 */
@WebServlet(name = "ActionServlet", urlPatterns = {"/ActionServlet"})
public class ActionServlet extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        super.init();
        JpaUtil.init();
    }

    @Override
    public void destroy() {
        JpaUtil.destroy();
        super.destroy();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        request.setCharacterEncoding("UTF-8");

        String todo = request.getParameter("todo");

        Action action = null;
        Serialisation serialisation = null;

        if (todo != null) {
            switch (todo) {
                case "connecter":
                    action = new AuthentifierUserAction();
                    serialisation = new ProfilUserSerialisation();
                    break;
                case "afficherProfil":
                    action = new AfficherProfilAction();
                    serialisation = new AfficherProfilSerialisation();
                    break;
                case "checkLogin":
                    action = new CheckLoginAction();
                    serialisation = new AuthentifierUserSerialisation();
                    break;
                case "changerMdp":
                    action = new ChangerMotDePasseAction();
                    serialisation = new ChangerMdpSerialisation();
                    break;
                case "changerVoeux":
                    action = new ChangerVoeuxAction();
                    serialisation = new ChangementSerialisation();
                    break;
                case "afficherResultat":
                    action = new AfficherResultatAction();
                    serialisation = new AfficherResultatSerialisation();
                    break;  
                case "afficherStats":
                    action = new AfficherStatsAction();
                    serialisation = new AfficherResultatSerialisation();
                    break;  
                case "deconnecter":
                    action = new DeconnexionAction();
                    serialisation = new DeconnexionSerialisation();
                    break;  
                case "changerMail":
                    action = new ChangerMailAction();
                    serialisation = new ChangementSerialisation();
                    break;  
                case "envoyerMail":
                    action = new EnvoyerVerificationAction();
                    serialisation = new ChangementSerialisation();
                    break;  
                case "mainProg":
                    action = new MainProgAction();
                    serialisation = new ChangementSerialisation();
                    break;  
            }
        }
        
        if (action != null) {
            action.executer(request);
            serialisation.serialiser(request, response);
        }
        else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erreur dans les paramètres de la requête");
        }

    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
