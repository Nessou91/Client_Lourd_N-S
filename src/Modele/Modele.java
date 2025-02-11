package Modele;

import java.sql.*;

public class Modele {
    /************************* Attributs ****************************/
    private static Connexion uneConnexion = new Connexion ("localhost:8889", "orange_cl_lm", "root", "root");




    /********************* Autres méthodes **************************/

    public static void executerRequete (String requete) {
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement(); 
			unStat.execute(requete); 
			unStat.close();
			uneConnexion.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
	}
    
}
