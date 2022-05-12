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
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.myapp.entities.Defi;
import com.mycompany.myapp.services.ServiceDefi;
import java.io.IOException;
import java.util.Date;




/**
 *
 * @author medaz
 */
public class AddDefiForm extends Form{
    public AddDefiForm(Form previous)
    {
        setTitle("Add a game");
        setTitle("Add a new task");
        setLayout(BoxLayout.y());
        Label n = new Label("Nom :");
        TextField nom = new TextField("","Nom");
        Label d = new Label("description :");
        TextField desc= new TextField("", "description");
        Label img = new Label("Image :");
        TextField url= new TextField("", "Image");
        Label prix = new Label("Prix :");
        TextField pr= new TextField("", "Prix");
        Label nj = new Label("Nombre De Joueur :");
        TextField nbe= new TextField("", "Nombre De Joueur");
        Label j = new Label("Jeu :");
        TextField k = new TextField("", "Jeu");
        Label r = new Label("regle :");
        TextField regle = new TextField("", "regle");
        Label re = new Label("Recomponse :");
        TextField rec = new TextField("", "Recomponse");
        Date da = null ;
       // java.util.Date date = Calendar.getInstance().getTime();
             Button imp = new Button("Importer Image"); 
              imp.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent evt) {
                       ActionListener callback = e->{
            if (e != null && e.getSource() != null) {
                String SymphonyPath= "file://C:/Users/medaz/Documents/Pidev/master/public/uploads/defi/";
                String filePath = nom.getText()+".png" ;
                String p = SymphonyPath+filePath ;
               
               File f = new File(p);
              
             
                System.out.println(f.getParentFile());
                try {
                     f.createNewFile();
                     Image img =  Image.createImage(f.toString());
                } catch (IOException ex) {
                    System.out.println("erreur");
                }
               // String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "screenshot.png";
//                String oldPath = "file://C:/Users/medaz/AppData/Local/Temp/";
//                String nPath = filePath.replaceAll(oldPath, SymphonyPath);
                System.out.println(f);
                url.setText(filePath);
                
            }
        };

        if (FileChooser.isAvailable()) {
            FileChooser.showOpenDialog(".pdf,application/pdf,.gif,image/gif,.png,image/png,.jpg,image/jpg,.tif,image/tif,.jpeg", callback);
        } else {
            Display.getInstance().openGallery(callback, Display.GALLERY_IMAGE);
        }
                   }
              });
            
             
             
             
         Button btnValider = new Button("Add Defi");
         btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((nom.getText().length()==0)||(desc.getText().length()==0) ||(url.getText().length()==0)||(pr.getText().length()==0)
                        ||(nbe.getText().length()==0)
                        ||(k.getText().length()==0)
                        ||(regle.getText().length()==0)
                        ||(rec.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Defi dfi = new Defi(999, nom.getText().toString(), desc.getText().toString(), url.getText().toString(),
                                Integer.parseInt(pr.getText()),
                                 Integer.parseInt(k.getText()), Integer.parseInt(nbe.getText()),
                                regle.getText().toString(), rec.getText().toString());
                      if( new ServiceDefi().addGame(dfi))
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
    
         
        
    addAll(n,nom,d,desc,img,url,imp,prix,pr,nj,nbe,j,k,r,regle,re,rec,btnValider);
    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    
}
   
}
