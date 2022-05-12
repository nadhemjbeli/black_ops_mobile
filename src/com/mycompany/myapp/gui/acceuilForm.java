/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.util.Resources;

/**
 *
 * @author jmokh
 */
public class acceuilForm extends Form{
    
     Form current;
        public Resources theme;
    public acceuilForm()
            {
               
                
                   getToolbar().addCommandToSideMenu("page1", theme.getImage("round.png"), null);
           
       
//       getToolbar().addCommandToSideMenu("Page 2", theme.getImage("round.png"), e->{
//            page2.show();
//        });
//        getToolbar().addCommandToSideMenu("Page 3",theme.getImage("round.png"), e->{
//            page3.show();
//        });
        
            }
}
