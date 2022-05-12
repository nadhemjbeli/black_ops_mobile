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
import com.mycompany.myapp.MyApplication;

/**
 *
 * @author jmokh
 */
public class HomeForm2 extends Form {
     Form current;
     Resources theme;
    public HomeForm2(Form previous)
            {
            current=this; //Back 
            
            
        setTitle("Video Games");
        setLayout(BoxLayout.y());
          add(new Label("Choose an option"));
        Button btnGame = new Button("Crud Games");
        Button btnPictures = new Button("Crud Pictures of games");
        Button btnImages = new Button("Crud Champions");
        
        btnGame.addActionListener(e-> new GameForm(current).show());
        btnPictures.addActionListener(e-> new ImagesForm(current).show());
        btnImages.addActionListener(k->new ChampionsForm(current).show());
        
        
      addAll(btnGame,btnPictures,btnImages);
//        
//         getToolbar().addCommandToSideMenu("Page 1",theme.getImage("jeux.png"), e->{
//          new HomeForm2(current).show();
//        });
//        getToolbar().addCommandToSideMenu("Page 2", theme.getImage("round.png"), e->{
//            page2.show();
//        });
//        getToolbar().addCommandToSideMenu("Page 3",theme.getImage("round.png"), e->{
//            page3.show();
//        });
//       hi.show();
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());

}
}