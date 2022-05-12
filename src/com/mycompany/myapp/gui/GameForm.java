/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author jmokh
 */
public class GameForm extends Form{
    
     Form current;
    public GameForm(Form previous)
            {
            current=this; //Back 
        setTitle("Crud Games");
        setLayout(BoxLayout.y());
        
            add(new Label("Choose an option"));
        Button btnAddGame = new Button("Add Game");
        Button btnListGames = new Button("List Games");
        Button btnsendmail = new Button("notify users");
        
          btnAddGame.addActionListener(e-> new AddGameForm(current).show());
        btnListGames.addActionListener(e-> new ListGamesForm(current).show());
        btnsendmail.addActionListener(k->new SendMailForm(current).show());
 
        addAll(btnAddGame,btnListGames,btnsendmail);
            getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());

}
}