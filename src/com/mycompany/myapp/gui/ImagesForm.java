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
public class ImagesForm extends Form{
    Form current;
    public ImagesForm(Form previous)
            {
            current=this; //Back 
        setTitle("Crud Images");
        setLayout(BoxLayout.y());
        
          Button btnAddImage = new Button("Add Image");
        Button btnListImages = new Button("List Images");
          btnAddImage.addActionListener(k->new AddPicForm(current).show());
        btnListImages.addActionListener(e-> new ListImagesForm(current).show());
        addAll(btnAddImage,btnListImages);
            getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());

}
    }