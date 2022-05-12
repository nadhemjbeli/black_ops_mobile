/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author jmokh
 */
public class ChampionsForm extends Form{
      Form current;
    public ChampionsForm(Form previous)
            {
            current=this; //Back 
        setTitle("Crud champions");
        setLayout(BoxLayout.y());
        
         Button btnAddChampion = new Button("Add Champion");
        Button btnListChampions = new Button("List Champions");
        
          btnAddChampion.addActionListener(e-> new AddChampionForm(current).show());
        btnListChampions.addActionListener(e-> new ListChampionsForm(current).show());
        
        addAll(btnAddChampion,btnListChampions);
            getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());

}
}