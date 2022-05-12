/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Jeu;
import com.mycompany.myapp.services.ServiceGame;

/**
 *
 * @author jmokh
 */
public class AddGameForm extends Form{
    public AddGameForm(Form previous)
    {
        setTitle("Add a game");
         setTitle("Add a new task");
        setLayout(BoxLayout.y());
        
        TextField tfName = new TextField("","GameName");
        TextField tfdes= new TextField("", "description");
        TextField tfurl= new TextField("", "url");
        TextField tfsscat= new TextField("", "Id sous catégorie");
        Button btnValider = new Button("Add Game");
         btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfName.getText().length()==0)||(tfdes.getText().length()==0) ||(tfurl.getText().length()==0)||(tfsscat.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Jeu j = new Jeu(tfName.getText().toString(),tfdes.getText().toString(),tfurl.getText().toString(),Integer.parseInt(tfsscat.getText()));
                      if( new ServiceGame().addGame(j))
                         {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Id sous catégorie must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfName,tfdes,tfurl,tfsscat,btnValider);
    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    
    
    }
}
