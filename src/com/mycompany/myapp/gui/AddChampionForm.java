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
import com.mycompany.myapp.entities.Champion;
import com.mycompany.myapp.entities.Jeu;
import com.mycompany.myapp.services.ServiceChampion;
import com.mycompany.myapp.services.ServiceGame;

/**
 *
 * @author jmokh
 */
public class AddChampionForm extends Form{
     public AddChampionForm(Form previous)
    {
        setTitle("Add a Champion");
        
        setLayout(BoxLayout.y());
        
        TextField tfName = new TextField("","ChampionName");
        TextField tfdes= new TextField("", "description");
        TextField tfrole= new TextField("", "Role");
        TextField tfdiff= new TextField("", "Difficulté");
        TextField tfImage= new TextField("", "Image");
        TextField tfjeu= new TextField("", "Jeu");
        Button btnValider = new Button("Add Game");
         btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfName.getText().length()==0)||(tfdes.getText().length()==0) ||(tfrole.getText().length()==0)||(tfdiff.getText().length()==0)||(tfImage.getText().length()==0)||(tfjeu.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Champion j = new Champion(tfName.getText().toString(),tfdes.getText().toString(),tfrole.getText().toString(),tfdiff.getText().toString(),tfImage.getText().toString(),Integer.parseInt(tfjeu.getText()));
                      if( new ServiceChampion().addChampion(j))
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
        
        addAll(tfName,tfdes,tfrole,tfdiff,tfImage,tfjeu,btnValider);
    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    
    
    }
}
