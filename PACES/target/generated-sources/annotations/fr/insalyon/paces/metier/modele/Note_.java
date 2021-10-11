package fr.insalyon.paces.metier.modele;

import fr.insalyon.paces.metier.modele.Etudiant;
import fr.insalyon.paces.metier.modele.Filiere;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-20T00:59:11")
@StaticMetamodel(Note.class)
public class Note_ { 

    public static volatile SingularAttribute<Note, Double> note;
    public static volatile SingularAttribute<Note, Filiere> filiere;
    public static volatile SingularAttribute<Note, Integer> rangParmiLesAdmis;
    public static volatile SingularAttribute<Note, Integer> rangGlobal;
    public static volatile SingularAttribute<Note, Long> id;
    public static volatile SingularAttribute<Note, Etudiant> etudiant;

}