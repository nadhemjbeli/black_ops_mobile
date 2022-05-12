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
    public HomeForm(Form previous)
            {
            current=this; //Back 
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAddGame = new Button("Add Game");
        Button btnListGames = new Button("List Games");
        Button btnsendmail = new Button("notify users");
        Button btnAddImage = new Button("Add Image");
        Button btnListImages = new Button("List Images");
        Button btnAddChampion = new Button("Add Champion");
        Button btnListChampions = new Button("List Champions");
        btnAddGame.addActionListener(e-> new AddGameForm(current).show());
        btnListGames.addActionListener(e-> new ListGamesForm(current).show());
        btnsendmail.addActionListener(k->new SendMailForm(current).show());
        btnAddImage.addActionListener(k->new AddPicForm(current).show());
        btnListImages.addActionListener(e-> new ListImagesForm(current).show());
        btnAddChampion.addActionListener(e-> new AddChampionForm(current).show());
        btnListChampions.addActionListener(e-> new ListChampionsForm(current).show());

        addAll(btnAddGame,btnListGames,btnsendmail,btnAddImage,btnListImages,btnAddChampion,btnListChampions);
        
        
     
            }}
    

