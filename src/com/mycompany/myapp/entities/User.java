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
public class User {
    private int id_user;
    private String mail;
    private String username;
    private String password;
    private int status ;
    private String images;
    private String roles;
public User()
{}
    public User(int id_user, String mail, String username, String password, int status, String images) {
        this.id_user = id_user;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.status = status;
        this.images = images;
    }
    public User(String mail)
    {  this.mail = mail;}

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", mail=" + mail + ", username=" + username + ", password=" + password + ", status=" + status + ", images=" + images + '}';
    }
    
}
