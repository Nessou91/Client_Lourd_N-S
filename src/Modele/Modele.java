package Modele;

public class Modele {
    private static Connexion uneConnexion = new Connexion("localhost:8889", "NeigeSoleil", "root", "root");

    public static void insertUser (User unUser){
        String requete = "insert into user values (null, '"+unUser.getNom()+"', '"+unUser.getPrenom()+"', '"+unUser.getMail()+"', '"+unUser.getTel()+"', '"+unUser.getMdp()+"', '"+unUser.getRole()+"')";
    }


}
