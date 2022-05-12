/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.io.File;
import com.codename1.ui.Component;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Defi;
import com.mycompany.myapp.services.ServiceDefi;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


/**
 *
 * @author medaz
 */
public class ListDefisForm extends Form {

       public ListDefisForm(Form previous){
           super("HomeForm",BoxLayout.y());
           
     setTitle("List Defi");

       List<Defi> defi =  ServiceDefi.getInstance().GetAllDefi();
       for(Defi l:defi){
         Label labimg = new Label();
         Label sparator = new Label("______________________________________________________________________");
         String p = ""+l.getPrix();
         Label  nom=new Label("nom defi: "+l.getNom_Defi());
         Label prix=new Label("prix defi : "+l.getPrix());
           System.out.println(l.getImg_Defi());
            String path = "file://C:/Users/medaz/Documents/Pidev/master/public/uploads/defi/"+l.getImg_Defi();
          File Path = new File(path);
              System.out.println(Path);
            try {
            Image img = Image.createImage(Path.toString());
            
             labimg.setIcon(img);
            
             
            }   catch (IOException e) {
                System.out.println(e.getMessage());
              }
          addAll(labimg,nom,prix,sparator);
       }
    getToolbar().addMaterialCommandToLeftBar("back", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    
    
    
    }
}
