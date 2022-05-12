/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.mycompany.myapp.entities.Joueur;
import com.mycompany.myapp.services.ServiceJoueur;
import java.util.List;

/**
 *
 * @author medaz
 */
public class ListJoueurFrom extends Form {
       public ListJoueurFrom(Form previous){
             setTitle("List Joueur");
         List<Joueur> defi =  ServiceJoueur.getInstance().GetAllDefi();
          for(Joueur l:defi){
         Label labimg = new Label();
         Label sparator = new Label("______________________________________________________________________");
         
         Label  nom=new Label("nom Joueur: "+l.getNom_Joueur());
         Label rang=new Label("Rang defi : "+l.getRang_Joueur());
         Label tel =new Label("Numero :"+l.getTel());
           
          addAll(nom,rang,tel,sparator);
       }
         getToolbar().addMaterialCommandToLeftBar("back", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    
    
    
    }
}
