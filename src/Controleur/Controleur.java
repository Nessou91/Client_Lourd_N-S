package Controleur;

import java.util.ArrayList;

public class Controleur {

    	/************************** Controle des données ************************/
	public static boolean verifDonnees (ArrayList<String> lesChamps) {
		boolean ok = true;
		for (String Champ : lesChamps) {
			if (Champ.isEmpty()) {
				ok = false;
			}
	}
	return ok;
	}
    
}
