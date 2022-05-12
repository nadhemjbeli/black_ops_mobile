/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

//import java.sql.Timestamp;

/**
 *
 * @author ASUS
 */
public class Messagee {
    private int id_message;
    private String date_message;
    private String contenu_message;
    private int id_cl, id_sous_cat;
    private String nom_Client;
    private String mail_Client;
    private String image_Client;

    public String getImage_Client() {
        return image_Client;
    }

    public void setImage_Client(String image_Client) {
        this.image_Client = image_Client;
    }

    public String getNom_Client() {
        return nom_Client;
    }

    public void setNom_Client(String nom_Client) {
        this.nom_Client = nom_Client;
    }

    public String getMail_Client() {
        return mail_Client;
    }

    public void setMail_Client(String mail_Client) {
        this.mail_Client = mail_Client;
    }

    public Messagee() {
    }

    
    
    public Messagee(int id_message,String date_message, String contenu_message, int id_cl, int id_sous_cat) {
        this.id_message = id_message;
        this.date_message = date_message;
        this.contenu_message = contenu_message;
        this.id_cl = id_cl;
        this.id_sous_cat = id_sous_cat;
    }
    
    public Messagee(int id_message, String contenu_message, int id_cl, int id_sous_cat) {
        this.id_message = id_message;
        this.contenu_message = contenu_message;
        this.id_cl = id_cl;
        this.id_sous_cat = id_sous_cat;
    }

    

    

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public String getDate_message() {
        return date_message;
    }

    public void setDate_message(String date_message) {
        this.date_message = date_message;
    }

    public String getContenu_message() {
        return contenu_message;
    }

    public void setContenu_message(String contenu_message) {
        this.contenu_message = contenu_message;
    }

    public int getId_cl() {
        return id_cl;
    }

    public void setId_cl(int id_cl) {
        this.id_cl = id_cl;
    }

    public int getId_sous_cat() {
        return id_sous_cat;
    }

    public void setId_sous_cat(int id_sous_cat) {
        this.id_sous_cat = id_sous_cat;
    }

    @Override
    public String toString() {
        return "message{" + "id_message=" + id_message + ", contenu_message=" + contenu_message + ", usename=" + nom_Client + ", date_message=" + date_message + ", id_cl=" + id_cl + ", id_sous_cat=" + id_sous_cat + '}';
    }
    
    
    
    
    
}
