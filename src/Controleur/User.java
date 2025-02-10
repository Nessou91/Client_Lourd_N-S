package Controleur;

import java.util.ArrayList;

import com.mysql.cj.xdevapi.Client;

public class User {
    private int id_user, id_ville, code_postal;
    private String nom, prenom, adresse, email, telphone, mdp, role;
    private String Ville;

    public User(int id_user, int id_ville, int code_postal, String nom, String prenom, String adresse, String email, String telphone, String mdp, String role) {
        this.id_user = id_user;
        this.id_ville = id_ville;
        this.code_postal = code_postal;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telphone = telphone;
        this.mdp = mdp;
        this.role = role;
    }

    public User (int code_postal, String nom, String prenom, String adresse, String email, String telphone, String mdp, String role) {
        this.id_user = 0;
        this.id_ville = 0;
        this.code_postal = code_postal;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telphone = telphone;
        this.mdp = mdp;
        this.role = role;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getVille() {
        // Assuming there is a method to get the city name from the city ID
        return Ville.getCityNameById(id_ville);
    }

    public void setVille(int id_ville) {
        this.id_ville = id_ville;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getVille (int id_ville) {
        //à implementer dans la classe Ville
    }

}
