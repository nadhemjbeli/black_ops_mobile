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
import com.mycompany.myapp.entities.Picture;
import com.mycompany.myapp.services.ServiceGame;
import com.mycompany.myapp.services.ServiceImage;

/**
 *
 * @author jmokh
 */
public class AddPicForm extends Form{
     public AddPicForm(Form previous)
    {
        setTitle("Add an image");
        
        setLayout(BoxLayout.y());
        
        TextField tfName = new TextField("","Image Url");       
        TextField tfsscat= new TextField("", "Id Jeu");
        Button btnValider = new Button("Add Image");
         btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfName.getText().length()==0)||(tfsscat.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Picture j = new Picture(tfName.getText(),Integer.parseInt(tfsscat.getText()));
                      if( new ServiceImage().addPic(j))
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
        
        addAll(tfName,tfsscat,btnValider);
    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    
    
    }
}
