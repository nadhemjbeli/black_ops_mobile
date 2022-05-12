/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.io.File;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.entities.Messagee;
import com.mycompany.myapp.services.ServiceTask;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class ListTasksForm extends Form {
    Form m;
    String userNm;
    String imagesurl;
    public ListTasksForm(Form previous) {
        userNm = "nadhem5";
        
        setTitle("List Messages");
        m = new Form("Messages",BoxLayout.y());
        SpanLabel sp = new SpanLabel();
        
        Button btnListHome = new Button("<--");
        btnListHome.addActionListener(e-> new HomeForm().show());
        add(btnListHome);
        showAll();
        TextField tfName = new TextField("","Contenu");
        Button btnValider = new Button("Add message");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
//                if ((tfName.getText().length()==0)||(tfStatus.getText().length()==0))
//                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
//                else
//                {
                    try {
                        Messagee t = new Messagee(1, tfName.getText().toString(), 5, 7);
                        if( ServiceTask.getInstance().addTask(t))
                        {
//                            new HomeForm().show();
                            new ListTasksForm(m).show();
                        }
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } 
                    catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
//                }
                
                
            }
        });
        
        addAll(tfName,btnValider);
//        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
             
//        m.show();
//        add(sp);
        System.out.println();
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }
    public void showAll(){
        ArrayList<Messagee> messages = ServiceTask.getInstance().getAllTasks();
            Container cn = new Container(BoxLayout.y());
            Label lab_empty = new Label("");
            
        for(Messagee msg:messages){
            Button btn_del = new Button("x");
            Label labimg = new Label();
            Container cn1 = new Container(new BorderLayout());
            Container cn2 = new Container(BoxLayout.y());
            Label lab_contenu = new Label(msg.getContenu_message());
            Style contenu_style = lab_contenu.getAllStyles();
            Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
            contenu_style.setBorder(RoundRectBorder.create().
            strokeColor(0).
            strokeOpacity(120).
            stroke(borderStroke));
            contenu_style.setBgColor(0x09a195);
            contenu_style.setMargin(Component.BOTTOM, 3);
            Label lab_username = new Label(msg.getNom_Client());
            System.out.println(imagesurl);
            String src = "file:\\C:\\Users\\ASUS\\everything\\esprit\\3A9\\mobile\\projects"
                 + "\\WorkshopOarsingJson\\src\\com\\mycompany\\myapp\\uplo\\"+msg.getImage_Client();
             File Path=new File(src);
              System.out.println(Path);
            try {
                
            Image img=Image.createImage(Path.toURI().toString());
            
            labimg.setIcon(img);
//            add(labimg);

            }   catch (IOException e) {
                System.out.println(e.getMessage());
              } catch (URISyntaxException ex) {
                  System.out.println(ex.getMessage());
              }
            if(msg.getNom_Client().equals(userNm)){
//                Label lab_contenu = new Label(msg.getContenu_message());
//                Label lab_username = new Label(msg.getNom_Client());
                cn2.add(labimg);
                cn2.add(lab_username);
                cn2.add(lab_contenu);
                
                cn1.add(BorderLayout.EAST, cn2);
//                cn1.add(lab_empty);
//                cn1.add(lab_username);
                
            }
            else{
                
                cn2.add(labimg);
                cn2.add(lab_username);
                cn2.add(lab_contenu);
                cn1.add(BorderLayout.WEST, cn2);
            }
            btn_del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            try {
                        if( ServiceTask.getInstance().delete(msg))
                        {
                           Dialog.show("Confirm","Delete \" "+msg.getContenu_message()+"\"?",new Command("OK"));
                           new ListTasksForm(m);
                        }else
                            Dialog.show("Cancel", "back", new Command("OK"));
                    } 
                    catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
            }
            
            
        });
            cn.add(btn_del);
            cn.add(cn1);
            
            
        }
        cn.setX(TOP);
        add(cn);
        setLayout(BoxLayout.y());
        
        
//        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
//             
////        m.show();
////        add(sp);
//        System.out.println();
//        
//        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    
    }
    

}
