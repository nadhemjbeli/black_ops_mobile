/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;



/**
 *
 * @author medaz
 */

    




public class Equipe {
    private int id_Equipe ;
    private String  nom_Equipe ;
    private String logo_Equipe ;
    private Date date ;
    private int nbr_joueur_Equipe ;

    public Equipe() {
    }

    public int getId_Equipe() {
        return id_Equipe;
    }

    public void setId_Equipe(int id_Equipe) {
        this.id_Equipe = id_Equipe;
    }

    public String getNom_Equipe() {
        return nom_Equipe;
    }

    public void setNom_Equipe(String nom_Equipe) {
        this.nom_Equipe = nom_Equipe;
    }

    public String getLogo_Equipe() {
        return logo_Equipe;
    }

    public void setLogo_Equipe(String logo_Equipe) {
        this.logo_Equipe = logo_Equipe;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNbr_joueur_Equipe() {
        return nbr_joueur_Equipe;
    }

    public void setNbr_joueur_Equipe(int nbr_joueur_Equipe) {
        this.nbr_joueur_Equipe = nbr_joueur_Equipe;
    }

    @Override
    public String toString() {
        return "Equipe{" + "id_Equipe=" + id_Equipe + ", nom_Equipe=" + nom_Equipe + ", logo_Equipe=" + logo_Equipe + ", date=" + date + ", nbr_joueur_Equipe=" + nbr_joueur_Equipe + '}';
    }

    public Equipe(int id_Equipe, String nom_Equipe, String logo_Equipe, Date date, int nbr_joueur_Equipe) {
        this.id_Equipe = id_Equipe;
        this.nom_Equipe = nom_Equipe;
        this.logo_Equipe = logo_Equipe;
        this.date = date;
        this.nbr_joueur_Equipe = nbr_joueur_Equipe;
    }

    public Equipe(int id_Equipe) {
        this.id_Equipe = id_Equipe;
    }
    
    

}


