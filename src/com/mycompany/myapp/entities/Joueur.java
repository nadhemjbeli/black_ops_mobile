/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author medaz
 */
public class Joueur {
    private int id_Joueur ;
    private String nom_Joueur ;
    private String rang_Joueur ;
    private String Pseaudo_Joueur;
    private int id_equipe ;
    private int id_user;
    private String Nom_equipe ;
    private String Username;
    private String tel ;

    public Joueur(int id_Joueur, String nom_Joueur, String rang_Joueur, String Pseaudo_Joueur,String tel,int id_equipe,int id_user) {
        this.id_Joueur = id_Joueur;
        this.nom_Joueur = nom_Joueur;
        this.rang_Joueur = rang_Joueur;
        this.Pseaudo_Joueur = Pseaudo_Joueur;
        this.id_equipe = id_equipe;
        this.id_user = id_user;
        this.tel = tel ;

    }

    public Joueur() {
    }

    public int getId_Joueur() {
        return id_Joueur;
    }

    public void setId_Joueur(int id_Joueur) {
        this.id_Joueur = id_Joueur;
    }

    public String getNom_Joueur() {
        return nom_Joueur;
    }

    public void setNom_Joueur(String nom_Joueur) {
        this.nom_Joueur = nom_Joueur;
    }

    public String getRang_Joueur() {
        return rang_Joueur;
    }

    public void setRang_Joueur(String rang_Joueur) {
        this.rang_Joueur = rang_Joueur;
    }

    public String getPseaudo_Joueur() {
        return Pseaudo_Joueur;
    }

    public void setPseaudo_Joueur(String Pseaudo_Joueur) {
        this.Pseaudo_Joueur = Pseaudo_Joueur;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom_equipe() {
        return Nom_equipe;
    }

    public void setNom_equipe(String Nom_equipe) {
        this.Nom_equipe = Nom_equipe;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public Joueur(int id_Joueur, String nom_Joueur, String Pseaudo_Joueur,String rang_Joueur,  String tel, int id_equipe) {
        this.id_Joueur = id_Joueur;
        this.nom_Joueur = nom_Joueur;
        this.rang_Joueur = rang_Joueur;
        this.Pseaudo_Joueur = Pseaudo_Joueur;
        this.id_equipe = id_equipe;
        
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Joueur{" + "id_Joueur=" + id_Joueur + ", nom_Joueur=" + nom_Joueur + ", rang_Joueur=" + rang_Joueur + ", Pseaudo_Joueur=" + Pseaudo_Joueur + ", Nom_equipe=" + Nom_equipe + ", Username=" + Username + ", tel=" + tel + '}';
    }


    
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

  

    

    

   

    public Joueur(int id_Joueur) {
        this.id_Joueur = id_Joueur;
    }
    
}
