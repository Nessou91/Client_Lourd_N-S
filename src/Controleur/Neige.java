package Controleur;

import Vue.VueGenerale;
import Vue.VueConnexion;


public class Neige {

    private static VueConnexion uneVueConnexion;

    private static VueGenerale uneVueGenerale;

    private static User userConnecte;

    public static void setUserConnecte(User unUser) {
        unUser = userConnecte;
    }

    public static User getUserConnecte() {
        return userConnecte;
    }

    public static void creerVueGenerale() {
        uneVueGenerale = new VueGenerale();
    }

    
}
