/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author jmokh
 */
public class Picture {
    private int Id_Image;
    private String Url_Image;
    private int Id_jeu;
    private String nomjeu;
    public Picture(){}

    public Picture(int Id_Image, String Url_Image, int Id_jeu) {
        this.Id_Image = Id_Image;
        this.Url_Image = Url_Image;
        this.Id_jeu = Id_jeu;
    }

    public Picture(int Id_Image, String Url_Image, String nomjeu) {
        this.Id_Image = Id_Image;
        this.Url_Image = Url_Image;
        this.nomjeu = nomjeu;
    }

    public Picture(String Url_Image, int Id_jeu) {
        this.Url_Image = Url_Image;
        this.Id_jeu = Id_jeu;
    }

    public Picture(String Url_Image) {
        this.Url_Image = Url_Image;
    }
    
     public Picture(int Id_Image){
     this.Id_Image=Id_Image;}

    public int getId_Image() {
        return Id_Image;
    }

    public String getUrl_Image() {
        return Url_Image;
    }

    public int getId_jeu() {
        return Id_jeu;
    }

    public void setId_Image(int Id_Image) {
        this.Id_Image = Id_Image;
    }

    public void setUrl_Image(String Url_Image) {
        this.Url_Image = Url_Image;
    }

    public void setId_jeu(int Id_jeu) {
        this.Id_jeu = Id_jeu;
    }

    public String getNomjeu() {
        return nomjeu;
    }

    public void setNomjeu(String nomjeu) {
        this.nomjeu = nomjeu;
    }

    @Override
    public String toString() {
        return "Image{" + "Id_Image=" + Id_Image + ", Url_Image=" + Url_Image + ", Id_jeu=" + Id_jeu + '}'+'\n';
    }
}
