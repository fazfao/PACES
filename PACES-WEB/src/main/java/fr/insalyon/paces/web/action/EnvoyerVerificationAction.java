/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.web.action;

import fr.insalyon.paces.metier.modele.Etudiant;
import fr.insalyon.paces.metier.service.Service;
import fr.insalyon.paces.web.MailUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zihao
 */
public class EnvoyerVerificationAction extends Action {
    @Override
    public void executer(HttpServletRequest request) {
        
        final HttpSession session = request.getSession(); 
        Service service = new Service();
        Etudiant etudiant = null;
        String mail;
        Long id = (Long) session.getAttribute("idEtudiant");
        if(id!=null) {
            etudiant = service.rechercherEtudiantParId(id);
            // paramétrer mail
            if(etudiant.getMail() == null){
                mail = request.getParameter("mail");
            } else {
                mail = etudiant.getMail();
            }
            session.setAttribute("mailAModifier", mail);
            // créer code de vérification
            String sRand ="";
            Random random =new Random();
            for (int i = 0;i < 6; i++) {
                String rand = String.valueOf(random.nextInt(10));
                sRand += rand;
            }
            session.setAttribute("vcode", sRand);
            
            // envoyer mail
            MailUtil mailUtil = new MailUtil();
            mailUtil.sendMail(mail, sRand);
            
            // détruire code dans 10 mins
            session.setAttribute("timestamp", System.currentTimeMillis());
            
        } else {
            request.setAttribute("notLoggedIn", true);
        }
        if(etudiant!=null) {
            request.setAttribute("result",true);
        }
    }
}