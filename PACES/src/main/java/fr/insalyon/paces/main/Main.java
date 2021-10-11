/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.paces.main;

import fr.insalyon.paces.dao.JpaUtil;
import fr.insalyon.paces.metier.modele.*;
import fr.insalyon.paces.metier.service.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author zihao
 */
public class Main {
    
    public static void main(String[] args) {
        JpaUtil.init();
        initialiser();
        initialiserAdmin();
        //affecter();
        
    }
    
    public static void initialiser() {
        System.out.println();
        System.out.println("**** initialiserLesEtudiants ****");
        System.out.println();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROJET-PACES");
        EntityManager em = emf.createEntityManager();
        String tab1 = "1,4,2,3,5,6,7,8";
        String tab2 = "2,1,3,4,8,7,6,5";
        String tab3 = "3,7,5,4,2,1,8,6";
        String tab4 = "8,6,3,7,5,1,4,2";
        String tab5 = "5,4,2,7,6,8,3,1";
        Etudiant e1 = new Etudiant("Sun","Pierre",tab1);
        Etudiant e2 = new Etudiant("Sun","Kenny",tab1);
        Etudiant e3 = new Etudiant("Sun","Pascal",tab1);
        Etudiant e4 = new Etudiant("Sun","Darius",tab2);
        Etudiant e5 = new Etudiant("Sun","Stew",tab2);
        Etudiant e6 = new Etudiant("Sun","Daniel",tab2);
        Etudiant e7 = new Etudiant("Sun","Louis",tab3);
        Etudiant e8 = new Etudiant("Sun","Jean",tab4);
        Etudiant e9 = new Etudiant("Sun","Hugo",tab5);
        Etudiant e10 = new Etudiant("Sun","George",tab5);
        Etudiant e11 = new Etudiant("Sun","Andrea",tab4);
        Etudiant e12 = new Etudiant("Sun","Kenny",tab1);
        Etudiant e13 = new Etudiant("Sun","Pascal",tab1);
        Etudiant e14 = new Etudiant("Sun","Darius",tab2);
        Etudiant e15 = new Etudiant("Sun","Stew",tab2);
        Etudiant e16 = new Etudiant("Sun","Daniel",tab2);
        Etudiant e17 = new Etudiant("Sun","Louis",tab3);
        Etudiant e18 = new Etudiant("Sun","Jean",tab4);
        Etudiant e19 = new Etudiant("Sun","Hugo",tab5);
        Etudiant e20 = new Etudiant("Sun","George",tab5);
        Etudiant e21 = new Etudiant("Sun","Andrea",tab4);
        Etudiant e22 = new Etudiant("Sun","Kenny",tab1);
        Etudiant e23 = new Etudiant("Sun","Pascal",tab1);
        Etudiant e24 = new Etudiant("Sun","Darius",tab2);
        Etudiant e25 = new Etudiant("Sun","Stew",tab2);
        Etudiant e26 = new Etudiant("Sun","Daniel",tab2);
        Etudiant e27 = new Etudiant("Sun","Louis",tab3);
        Etudiant e28 = new Etudiant("Sun","Jean",tab4);
        Etudiant e29 = new Etudiant("Sun","Hugo",tab5);
        Etudiant e30 = new Etudiant("Sun","George",tab5);
        Etudiant e31 = new Etudiant("Sun","Andrea",tab4);
        Etudiant e32 = new Etudiant("Sun","Kenny",tab1);
        Etudiant e33 = new Etudiant("Sun","Pascal",tab1);
        Etudiant e34 = new Etudiant("Sun","Darius",tab2);
        Etudiant e35 = new Etudiant("Sun","Stew",tab2);
        Etudiant e36 = new Etudiant("Sun","Daniel",tab2);
        Etudiant e37 = new Etudiant("Sun","Louis",tab3);
        Etudiant e38 = new Etudiant("Sun","Jean",tab4);
        Etudiant e39 = new Etudiant("Sun","Hugo",tab5);
        Etudiant e40 = new Etudiant("Sun","George",tab5);
        Etudiant e41 = new Etudiant("Sun","Andrea",tab4);
        Etudiant e42 = new Etudiant("Sun","Kenny",tab1);
        Etudiant e43 = new Etudiant("Sun","Pascal",tab1);
        Etudiant e44 = new Etudiant("Sun","Darius",tab2);
        Etudiant e45 = new Etudiant("Sun","Stew",tab2);
        Etudiant e46 = new Etudiant("Sun","Daniel",tab2);
        Etudiant e47 = new Etudiant("Sun","Louis",tab3);
        Etudiant e48 = new Etudiant("Sun","Jean",tab4);
        Etudiant e49 = new Etudiant("Sun","Hugo",tab5);
        Etudiant e50 = new Etudiant("Sun","Kenny",tab1);
        Etudiant e51 = new Etudiant("Sun","Andrea",tab4);
        Etudiant e52 = new Etudiant("Sun","Andreaasda",tab4);
        Etudiant e53 = new Etudiant("Sun","Pascal",tab1);
        Etudiant e54 = new Etudiant("Sun","Darius",tab2);
        Etudiant e55 = new Etudiant("Sun","Stew",tab2);
        Etudiant e56 = new Etudiant("Sun","Daniel",tab2);
        Etudiant e57 = new Etudiant("Sun","Louis",tab3);
        Etudiant e58 = new Etudiant("Sun","Jean",tab4);
        Etudiant e59 = new Etudiant("Sun","Hugo",tab5); 
        Etudiant e60 = new Etudiant("Sun","George",tab5);
        Etudiant e61 = new Etudiant("Sun","Andrea",tab4);
        Etudiant e62 = new Etudiant("Sun","Kenny",tab1);
        Etudiant e63 = new Etudiant("Sun","Pascal",tab1);
        Etudiant e64 = new Etudiant("Sun","Darius",tab2);
        Etudiant e65 = new Etudiant("Sun","Stew",tab2);
        Etudiant e66 = new Etudiant("Sun","Daniel",tab2);
        Etudiant e67 = new Etudiant("Sun","Louis",tab3);
        Etudiant e68 = new Etudiant("Sun","Jean",tab4);
        Etudiant e69 = new Etudiant("Sun","Hugo",tab5);
        Etudiant e70 = new Etudiant("Sun","George",tab5);
        Etudiant e71 = new Etudiant("Sun","Andrea",tab4);
        Etudiant e72 = new Etudiant("Sun","Kenny",tab1);
        Etudiant e73 = new Etudiant("Sun","Pascal",tab1);
        Etudiant e74 = new Etudiant("Sun","Darius",tab2);
        Etudiant e75 = new Etudiant("Sun","Stew",tab2);
        Etudiant e76 = new Etudiant("Sun","Daniel",tab2);
        Etudiant e77 = new Etudiant("Sun","Louis",tab3);
        Etudiant e78 = new Etudiant("Sun","Jean",tab4);
        Etudiant e79 = new Etudiant("Sun","Hugo",tab5);
        Etudiant e80 = new Etudiant("Sun","George",tab5);
        Etudiant e81 = new Etudiant("Sun","Andrea",tab4);
        Etudiant e82 = new Etudiant("Sun","Kenny",tab1);
        Etudiant e83 = new Etudiant("Sun","Pascal",tab1);
        Etudiant e84 = new Etudiant("Sun","Darius",tab2);
        Etudiant e85 = new Etudiant("Sun","Stew",tab2);
        Etudiant e86 = new Etudiant("Sun","Daniel",tab2);
        Etudiant e87 = new Etudiant("Sun","Louis",tab3);
        Etudiant e88 = new Etudiant("Sun","Jean",tab4);
        Etudiant e89 = new Etudiant("Sun","Hugo",tab5);
        Etudiant e90 = new Etudiant("Sun","George",tab5);
        Etudiant e91 = new Etudiant("Sun","Andrea",tab4);
        Etudiant e92 = new Etudiant("Sun","Kenny",tab1);
        Etudiant e93 = new Etudiant("Sun","Pascal",tab1);
        Etudiant e94 = new Etudiant("Sun","Darius",tab2);
        Etudiant e95 = new Etudiant("Sun","Stew",tab2);
        Etudiant e96 = new Etudiant("Sun","Daniel",tab2);
        Etudiant e97 = new Etudiant("Sun","Louis",tab3);
        Etudiant e98 = new Etudiant("Sun","Jean",tab4);
        Etudiant e99 = new Etudiant("Sun","Hugo",tab5);
        Etudiant e100 = new Etudiant("Sun","Kenny",tab1);
        Etudiant e101 = new Etudiant("Sun","Andrea",tab4);
        Etudiant e102 = new Etudiant("Sun","Andreaasda",tab4);
        Etudiant e103 = new Etudiant("Sun","Pascal",tab1);
        Etudiant e104 = new Etudiant("Sun","Darius",tab2);
        Etudiant e105 = new Etudiant("Sun","Stew",tab2);
        Etudiant e106 = new Etudiant("Sun","Daniel",tab2);
        Etudiant e107 = new Etudiant("Sun","Louis",tab3);
        Etudiant e108 = new Etudiant("Sun","Jean",tab4);
        Etudiant e109 = new Etudiant("Sun","Hugo",tab5);
        
        
        System.out.println();
        System.out.println("**** initialiserLesFilieres ****");
        System.out.println();
        
        List<Etudiant> l1 = new ArrayList<>();
	List<Filiere> fl = new ArrayList<>();
        
        l1.add(e1);
        l1.add(e2);
        l1.add(e3);
        l1.add(e4);
        l1.add(e5);
        l1.add(e6);
        l1.add(e7);
        l1.add(e8);
        l1.add(e9);
        l1.add(e10);
        l1.add(e11);
        l1.add(e12);
        l1.add(e13);
        l1.add(e14);
        l1.add(e15);
        l1.add(e16);
        l1.add(e17);
        l1.add(e18);
        l1.add(e19);
        l1.add(e20);
        l1.add(e21);
        l1.add(e22);
        l1.add(e23);
        l1.add(e24);
        l1.add(e25);
        l1.add(e26);
        l1.add(e27);
        l1.add(e28);
        l1.add(e29);
        l1.add(e30);
        l1.add(e31);
        l1.add(e32);
        l1.add(e33);
        l1.add(e34);
        l1.add(e35);
        l1.add(e36);
        l1.add(e37);
        l1.add(e38);
        l1.add(e39);
        l1.add(e40);
        l1.add(e41);
        l1.add(e42);
        l1.add(e43);
        l1.add(e44);
        l1.add(e45);
        l1.add(e46);
        l1.add(e47);
        l1.add(e48);
        l1.add(e49);
        l1.add(e50);
        l1.add(e51);
        l1.add(e52);
        l1.add(e53);
        l1.add(e54);
        l1.add(e55);
        l1.add(e56);
        l1.add(e57);
        l1.add(e58);
        l1.add(e59);
        l1.add(e60);
        l1.add(e61);
        l1.add(e62);
        l1.add(e63);
        l1.add(e64);
        l1.add(e65);
        l1.add(e66);
        l1.add(e67);
        l1.add(e68);
        l1.add(e69);
        l1.add(e70);
        l1.add(e71);
        l1.add(e72);
        l1.add(e73);
        l1.add(e74);
        l1.add(e75);
        l1.add(e76);
        l1.add(e77);
        l1.add(e78);
        l1.add(e79);
        l1.add(e80);
        l1.add(e81);
        l1.add(e82);
        l1.add(e83);
        l1.add(e84);
        l1.add(e85);
        l1.add(e86);
        l1.add(e87);
        l1.add(e88);
        l1.add(e89);
        l1.add(e90);
        l1.add(e91);
        l1.add(e92);
        l1.add(e93);
        l1.add(e94);
        l1.add(e95);
        l1.add(e96);
        l1.add(e97);
        l1.add(e98);
        l1.add(e99);
        l1.add(e100);
        l1.add(e101);
        l1.add(e102);
        l1.add(e103);
        l1.add(e104);
        l1.add(e105);
        l1.add(e106);
        l1.add(e107);
        l1.add(e108);
        l1.add(e109);
        //List<Etudiant> l2 = new ArrayList<>(l1);
        //List<Etudiant> l3 = new ArrayList<>(l1);

        /*Collections.shuffle(l1); // Les classements sont mélangés
        Collections.shuffle(l2);
        Collections.shuffle(l3);*/
        
        Filiere f1 = new Filiere("IF",15);
        Filiere f2 = new Filiere("GE",15);
        Filiere f3 = new Filiere("TC",15);
        Filiere f4 = new Filiere("GM",20);
        Filiere f5 = new Filiere("SGM",12);
        Filiere f6 = new Filiere("GCU",10);
        Filiere f7 = new Filiere("BS",10);
        Filiere f8 = new Filiere("GI",10);
        fl.add(f1);
        fl.add(f2);
        fl.add(f3);
        fl.add(f4);
        fl.add(f5);
        fl.add(f6);
        fl.add(f7);
        fl.add(f8);
        try {
            em.getTransaction().begin();
            em.persist(f1);
            em.persist(f2);
            em.persist(f3);
            em.persist(f4);
            em.persist(f5);
            em.persist(f6);
            em.persist(f7);
            em.persist(f8);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            for(Etudiant e:l1){
                for(Filiere f:fl){
                    Note n = new Note(e,f,(int)(Math.random()*120+80)/10.0);
                    em.persist(n);
                }
                double seed = Math.random();
                if(seed<0.5){
                    e.setGenre("H");
                } else {
                    e.setGenre("F");
                }
                
                String mdp ="";
                for(int i=0;i<6;i++){
                    mdp += String.valueOf((int)(Math.random()*10));
                }
                e.setPassword(mdp);
                
                Date date = new Date();
                String str = "1999/01/01";
                try { 
                date = sdf.parse(str);
                } catch (ParseException exc) {  
                    exc.printStackTrace();  
                }  
                Calendar c = Calendar.getInstance();  
                c.setTime(date);  
                c.add(Calendar.DAY_OF_MONTH, (int)(seed*365+1));  
                date = c.getTime();  
                e.setDateNaissance(date);
                em.persist(e);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service", ex);
            try {
                em.getTransaction().rollback();
            }
            catch (IllegalStateException ex2) {
                // Ignorer cette exception...
            }
        } finally {
            em.close();
        }
    }
    
    public static void affecter() {
        Service service = new Service();
        
        System.out.println();
        System.out.println("**** affecterLesEtudiants ****");
        System.out.println();
        
        service.mariage();
    }
    
    public static void initialiserAdmin(){
        System.out.println();
        System.out.println("**** initialiserLeCompteAdministraitif ****");
        System.out.println();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROJET-PACES");
        EntityManager em = emf.createEntityManager();
        Etudiant admin = new Etudiant("admin","admin",true);
        try {
            em.getTransaction().begin();
            em.persist(admin);
            em.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service", ex);
            try {
                em.getTransaction().rollback();
            }
            catch (IllegalStateException ex2) {
                // Ignorer cette exception...
            }
        } finally {
        }
    }
    
}
