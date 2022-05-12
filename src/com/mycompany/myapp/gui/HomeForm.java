/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author jmokh
 */
public class HomeForm extends Form{
    Form current;
    public HomeForm()
        {
        current=this; //Back 
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAddGame = new Button("Add Game");
        Button btnListGames = new Button("List Games");
        Button btnAddDefi = new Button("Add Defi");
        Button btnListDefis = new Button("List Defi");
         Button btnAddJoueur = new Button("Add Joueur");
        Button btnListJoueurs = new Button("List Joueur");
        
        btnAddGame.addActionListener(e-> new AddGameForm(current).show());
        btnListGames.addActionListener(e-> new ListGamesForm(current).show());
        btnAddDefi.addActionListener(e-> new AddDefiForm(current).show());
        btnListDefis.addActionListener(e-> new ListDefisForm(current).show());
        btnAddJoueur.addActionListener(e-> new AddJoueurFrom(current).show());
        btnListJoueurs.addActionListener(e-> new ListJoueurFrom(current).show());
        addAll(btnAddGame,btnListGames,btnAddDefi,btnListDefis,btnAddJoueur,btnListJoueurs);
            
            
        }
    
}
