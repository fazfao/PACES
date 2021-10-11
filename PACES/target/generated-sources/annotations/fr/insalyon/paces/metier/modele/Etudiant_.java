package fr.insalyon.paces.metier.modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-20T00:59:11")
@StaticMetamodel(Etudiant.class)
public class Etudiant_ { 

    public static volatile SingularAttribute<Etudiant, String> password;
    public static volatile SingularAttribute<Etudiant, String> mail;
    public static volatile SingularAttribute<Etudiant, Date> dateNaissance;
    public static volatile SingularAttribute<Etudiant, String> genre;
    public static volatile SingularAttribute<Etudiant, String> listeVoeux;
    public static volatile SingularAttribute<Etudiant, Boolean> admin;
    public static volatile SingularAttribute<Etudiant, Long> id;
    public static volatile SingularAttribute<Etudiant, Long> admission;
    public static volatile SingularAttribute<Etudiant, String> nom;
    public static volatile SingularAttribute<Etudiant, String> prenom;

}