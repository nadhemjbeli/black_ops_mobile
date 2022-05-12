/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ext.filechooser.FileChooser;
import com.codename1.io.File;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Joueur;
import com.mycompany.myapp.services.ServiceJoueur;

/**
 *
 * @author medaz
 */
public class AddJoueurFrom extends Form {
    
    public AddJoueurFrom(Form previous)
     {
        setTitle("Add  Joueur");
        setTitle("Add a new task");
        setLayout(BoxLayout.y());
        Label n = new Label("Nom :");
        TextField nom = new TextField("","Nom");
        Label d = new Label("Pseaudo :");
        TextField desc= new TextField("", "Pseaudo");
        Label img = new Label("Rang :");
        TextField url= new TextField("", "Rang");
        Label prix = new Label("Equipe :");
        TextField pr= new TextField("", "Equipe");
       Label u = new Label("User");
        TextField ur= new TextField("", "User");
        Label tel = new Label("Telephone");
        TextField teln= new TextField("", "Telephone");
        
       // java.util.Date date = Calendar.getInstance().getTime();
           
            
             
             
             
         Button btnValider = new Button("Add Defi");
         btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((nom.getText().length()==0)||(desc.getText().length()==0) ||(url.getText().length()==0)||(pr.getText().length()==0)
                        
                        ||(tel.getText().length()==0)
                        )
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Joueur dfi = new Joueur(3, nom.getText().toString(), 
                                desc.getText().toString(),url.getText().toString(),
                                teln.getText().toString(),Integer.parseInt(pr.getText()),Integer.parseInt(ur.getText()));
                      if( new ServiceJoueur().add(dfi))
                         {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "equipe must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
    
         
        
    addAll(n,nom,d,desc,img,url,prix,pr,u,ur,tel,teln,btnValider);
    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    
}
}


