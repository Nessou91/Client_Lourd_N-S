package Modele;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Connexion {
    private String serveur, bdd, user, mdp;
    private Connection maConnexion;

    public Connexion(String serveur, String bdd, String user, String mdp) {
        this.serveur = serveur;
        this.bdd = bdd;
        this.user = user;
        this.mdp = mdp;
        this.maConnexion = null;
    }

    public static void chargerPilote() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du pilote");
        }
    }

    public void seConnecter(){
        String url = "jdbc:mysql://" + this.serveur + "/" + this.bdd;
        try {
            this.maConnexion = DriverManager.getConnection(url, this.user, this.mdp);
        } catch (SQLException e) {
            System.out.println("Impossible de se connecter à la base de données : " + url);
        }
    }

    public void seDeconnecter() {
        try {
            this.maConnexion.close();
        } catch (SQLException e) {
            System.out.println("Impossible de se déconnecter de la base de données");
        }
    }


}
