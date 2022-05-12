package com.mycompany.myapp;


import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.Component;
import com.codename1.ui.FontImage;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.myapp.gui.HomeForm;
import com.mycompany.myapp.gui.HomeForm2;
import com.mycompany.myapp.gui.MenuForm;
import com.mycompany.myapp.gui.acceuilForm;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start() {
        new MenuForm(current).show();
//        if(current != null){
//            current.show();
//            return;
//        }
//        Form hi = new Form("ToolBar");
//        Label labelurl=new Label(theme.getImage("logo.png"));
//        hi.add(labelurl);
//       
//        Form page2 =new Form("Page 2",new FlowLayout(Component.CENTER, Component.CENTER));
//        page2.add(new Label("Page 2"));
//        page2.getToolbar().addCommandToRightBar("back", theme.getImage("back-command.png"), ev->{
//        hi.show();
//         });
//        
//        Form page3=new Form("Page 3",new FlowLayout(Component.CENTER, Component.CENTER));
//        page3.add(new Label("Page 3"));
//        
//        page3.getToolbar().addCommandToOverflowMenu("logout", null, ev->{
//            hi.show();
//        });
//        
//        
//        hi.getToolbar().addCommandToSideMenu("Page 1",theme.getImage("jeux.png"), e->{
//          new HomeForm2(current).show();
//        });
//        hi.getToolbar().addCommandToSideMenu("Page 2", theme.getImage("round.png"), e->{
//            page2.show();
//        });
//        hi.getToolbar().addCommandToSideMenu("Page 3",theme.getImage("round.png"), e->{
//            page3.show();
//        });
//        hi.show();
//    
        
               
       
    }

    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }

}
