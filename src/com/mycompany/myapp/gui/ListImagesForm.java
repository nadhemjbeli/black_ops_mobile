/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.io.File;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Jeu;
import com.mycompany.myapp.entities.Picture;
import com.mycompany.myapp.services.ServiceGame;
import com.mycompany.myapp.services.ServiceImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 *
 * @author jmokh
 */
public class ListImagesForm extends Form{
     private Resources theme;
        Form current;

     public ListImagesForm(Form previous){
          super("HomeForm",BoxLayout.y());
          current=this; //Back 
           setTitle("List Images");
    
            theme = UIManager.initFirstTheme("/theme");
     
        List<Picture> images=ServiceImage.getInstance().getAllpics();
         
      for (Picture j:images)
      {   
           Label labimg= new Label();
         Label labjeu= new Label(j.getNomjeu());
          File Path=new File("file:\\C:\\Users\\jmokh\\OneDrive\\Documents\\NetBeansProjects\\Pidev2\\src\\Images\\ImagesJeux\\"+j.getUrl_Image());
              System.out.println(Path);
            try {
            Image img=Image.createImage(Path.toURI().toString());
            
            labimg.setIcon(img);
            
      }
               catch (IOException e) {
                System.out.println(e.getMessage());
              } catch (URISyntaxException ex) {
                  System.out.println(ex.getMessage());
              }
            Container cn1 = new Container(BoxLayout.y());
        cn1.add(labjeu);
        Container cn2 = new Container(new BorderLayout());
        cn2.add(BorderLayout.WEST,cn1);
        cn2.add(BorderLayout.EAST,labimg);
        add(cn2);   
}

 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());


}}
