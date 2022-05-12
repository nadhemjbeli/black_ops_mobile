/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author jmokh
 */
public class ToolbarForm extends Form{
    Form current;
    Resources theme;
    public ToolbarForm(Form previous)
            {
 Form hi = new Form("ToolBar");
        Label labelurl=new Label(theme.getImage("logo.png"));
        hi.add(labelurl);
       
        Form page2 =new Form("Page 2",new FlowLayout(Component.CENTER, Component.CENTER));
        page2.add(new Label("Page 2"));
        page2.getToolbar().addCommandToRightBar("back", theme.getImage("back-command.png"), ev->{
        hi.show();
         });
        
        Form page3=new Form("Page 3",new FlowLayout(Component.CENTER, Component.CENTER));
        page3.add(new Label("Page 3"));
        
        page3.getToolbar().addCommandToOverflowMenu("logout", null, ev->{
            hi.show();
        });
        
        
        hi.getToolbar().addCommandToSideMenu("Page 1",theme.getImage("jeux.png"), e->{
          new HomeForm2(current).show();
        });
        hi.getToolbar().addCommandToSideMenu("Page 2", theme.getImage("round.png"), e->{
            page2.show();
        });
        hi.getToolbar().addCommandToSideMenu("Page 3",theme.getImage("round.png"), e->{
            page3.show();
        });
        hi.show();
    
           
}
}