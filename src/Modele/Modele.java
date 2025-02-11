package Modele;

import java.sql.*;

import Controleur.User;

public class Modele {
    /************************* Attributs ****************************/
    private static Connexion uneConnexion = new Connexion ("localhost:8889", "orange_cl_lm", "root", "root");

    /********************* Gestion des utilisateurs **************************/

    public static void insertUser (User unUser) {
        String requete = "insert into user values (null, '" + unUser.getNom() + "', '" + unUser.getPrenom() + "', '" + unUser.getEmail() + "', '" + unUser.getMdp() + "')";
        executerRequete(requete);
    }




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
