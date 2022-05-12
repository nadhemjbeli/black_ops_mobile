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
import com.codename1.ui.util.Resources;

/**
 *
 * @author jmokh
 */
public class MenuForm extends Form{
     Form current;
     Resources theme;
    public MenuForm(Form previous)
            {
            current=this; //Back 
            
            
        setTitle("Options");
        setLayout(BoxLayout.y());
          add(new Label("Choose an option"));
        Button btnGame2 = new Button("Games ");
        Button btnTournament = new Button("Tournament");
        Button btncommunity = new Button("Community");
        
           Button btnStream = new Button("Stream ");
        Button btnCommande = new Button("Pay for a tournament");
        
        
        btnGame2.addActionListener(e-> new HomeForm2(current).show());
       
       
      addAll(btnGame2,btnTournament,btncommunity,btnStream,btnCommande);
            getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());

}}
