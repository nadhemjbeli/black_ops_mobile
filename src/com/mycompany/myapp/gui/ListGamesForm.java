
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.mycompany.myapp.entities.Picture; 

import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Jeu;
import com.mycompany.myapp.services.ServiceGame;
import com.mycompany.myapp.services.ServiceImage;
import com.codename1.io.File;
import com.codename1.ui.TextField;

import java.io.IOException;
import java.util.List;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Champion;
import com.mycompany.myapp.services.ServiceChampion;
import java.net.URISyntaxException;
import java.util.ArrayList;



/**
 *
 * @author jmokh
 */
public class ListGamesForm extends Form{
       private Resources theme;
        Form current;
        Form f3;
        Form f4;
        Label nomc,dessc,rolec,difficultec,nomjeu;
    public ListGamesForm(Form previous){
          super("HomeForm",BoxLayout.y());
          current=this; //Back 
     setTitle("List games");
    Form f2 = new Form("Détails",BoxLayout.y());
    

    
       Label lnom=new Label();
       Label url=new Label();
       
        TextField test=new TextField();
         Label ldescription=new Label();
         
         Button btnchamps = new Button("View champions");
         
//         Label nomc=new Label();
//                  Label dessc=new Label();
//         Label rolec=new Label();
//         Label difficultec=new Label();
//         Label nomjeu=new Label();


         
         
        f2.add(lnom).add(test).add(url).add(btnchamps);

     theme = UIManager.initFirstTheme("/theme");
       
        List<Jeu> jeux=ServiceGame.getInstance().getAllGames();
         Label labimg= new Label();
         Label labimgc= new Label();
      for (Jeu j:jeux)
      {                      

////              String url2="/Images/ImagesJeux/"+image;
//System.out.println("/"+imagesurl);
              
//                           try{
//                               Image logo;
//                           logo=Image.createImage("/"+imagesurl);
//                           f2.add(logo);
//                           String imageFile=FileSystemStorage.getInstance().getAppHomePath()+"/3.png";
//                           try(OutputStream os =FileSystemStorage.getInstance().openOutputStream(imageFile))
//                           {System.out.println(imageFile);
//                           }catch(IOException e)
//                           {System.out.println(e.getMessage());}  
//                           }catch(IOException ex)
//                           {System.out.println(ex.getMessage());} 
                           
         
      Label labn = new Label(j.getNom());
      
      Button btnsscat = new Button(j.getNomsscat());
      

          
          
                       
     btnsscat.addActionListener(new ActionListener() {


          @Override
          public void actionPerformed(ActionEvent l) {
              String  imagesurl=ServiceGame.getInstance().getImagebyIdjeu(j.getId_Jeu());
              
            List<Champion>champions=ServiceChampion.getInstance().getChampionsbyIdjeu(j.getId_Jeu());
            f3=new Form("List of Champions",BoxLayout.y());
                for (Champion c:champions){
                     Label labnom = new Label(c.getNom_Champ());
                   
                     Button btrole = new Button(c.getRole_Champ());
                     
                  f3.add(labnom).add(btrole);
              
              
                  
                  f3.getToolbar().addCommandToLeftBar("back",theme.getImage("back-command.png"),e1->f2.show());
                
                       
                          
         
       
          
           Label labelurl2=new Label(theme.getImage("round.png"));
//           f3.add(labelurl2);
//       Container cn3 = new Container(BoxLayout.y());
//        cn3.add(labnom).add(btrole);
//        Container cn4 = new Container(new BorderLayout());
//        cn4.add(BorderLayout.WEST,cn3);
//        cn4.add(BorderLayout.EAST,labelurl2);
//          
//        f3.add(cn4);
         btrole.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent evt) {
                      String imgchamp=c.getImage_Champ();

    File Path2=new File("file:\\C:\\Users\\jmokh\\OneDrive\\Documents\\NetBeansProjects\\Pidev2\\src\\Images\\Champions\\"+imgchamp);
              System.out.println(Path2);
            try {
            Image img2=Image.createImage(Path2.toURI().toString());
            
            labimgc.setIcon(img2);
            

            }   catch (IOException e) {
                System.out.println(e.getMessage());
              } catch (URISyntaxException ex) {
                  System.out.println(ex.getMessage());
              }
      
                             
                             
                             
                             
                             Form f4=new Form("Détail champion",BoxLayout.y());
                nomc=new Label(("Nom: " + c.getNom_Champ()));
                dessc=new Label("Description: " + c.getDescription_Champ());
                rolec=new Label("Rôle: " + c.getRole_Champ());
                difficultec= new Label("Difficulté: " + c.getDifficulte_Champ());
                nomjeu= new Label("Genre du jeu : " + c.getNomJeu());
                   f4.addAll(nomc,dessc,rolec,difficultec,nomjeu,labimgc);
        f4.getToolbar().addCommandToLeftBar("back",theme.getImage("back-command.png"),e1->f3.show());

                            f4.show();

                         }
                     });
         

                }

               System.out.println(imagesurl);
             File Path=new File("file:\\C:\\Users\\jmokh\\OneDrive\\Documents\\NetBeansProjects\\Pidev2\\src\\Images\\ImagesJeux\\"+imagesurl);
              System.out.println(Path);
            try {
            Image img=Image.createImage(Path.toURI().toString());
            
            labimg.setIcon(img);
            

            }   catch (IOException e) {
                System.out.println(e.getMessage());
              } catch (URISyntaxException ex) {
                  System.out.println(ex.getMessage());
              }
             
            
            
            
            
            
            
              lnom.setText("nom : " + j.getNom());
              ldescription.setText(j.getDescription());
              test.setText(j.getDescription());
              test.setSingleLineTextArea(true);
              test.setHeight(200);
              url.setText("url : " + j.getUrl());
              
              f2.show();
              
          
              }
      });
     btnchamps.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent evt) {
                
                   
       
                  f3.show();
                  
              }
     
      });
          f2.getToolbar().addCommandToLeftBar("back",theme.getImage("back-command.png"),e1->current.show());
           Label labelurl=new Label(theme.getImage("round.png"));
       Container cn1 = new Container(BoxLayout.y());
        cn1.add(labn).add(btnsscat);
        Container cn2 = new Container(new BorderLayout());
        cn2.add(BorderLayout.WEST,cn1);
        cn2.add(BorderLayout.EAST,labelurl);
          System.out.println(labimg);
        add(cn2);
        
      }
        
        
      
      
      
    f2.add(labimg);
              
      
        
//      SpanLabel sp = new SpanLabel();
//        sp.setText(ServiceGame.getInstance().getAllGames().toString());
//        add(sp);
            
    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    
    
    
    }
}
