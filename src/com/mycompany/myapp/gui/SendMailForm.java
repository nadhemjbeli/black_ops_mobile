/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Jeu;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.services.SendEmail;
import com.mycompany.myapp.services.ServiceGame;
import java.util.List;

/**
 *
 * @author jmokh
 */
public class SendMailForm extends Form{
      public SendMailForm(Form previous)
    {
        setTitle("Send mail to users");
        
        setLayout(BoxLayout.y());
        
       
        TextField Mailsubject= new TextField("Subject");
        TextField MailBody= new TextField("Body");
       
        Button btnValider = new Button("send");
      
         btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (( Mailsubject.getText().length()==0)||(MailBody.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        // String[] users = new String[]{"mohamedmokhtar.jaafar@esprit.tn","fedibenammar734@gmail.com"}; 
                        List<User> users =ServiceGame.getInstance().getAllMailUsers() ;
                        for (User l:users){
                     SendEmail send = new SendEmail(l.getMail(),Mailsubject.getText(), 
                             
                           MailBody.getText() ); } 
        
//                      if( new ServiceGame().getAllMailUsers()))
//                         {
//                           Dialog.show("Success","Connection accepted",new Command("OK"));
//                        }else
//                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    
                }
                
                
            }
        });
        
        addAll(Mailsubject,MailBody,btnValider);
    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    
    
    }
    
}
