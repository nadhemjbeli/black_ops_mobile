/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.components.ImageViewer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;


import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Picture;
import com.mycompany.myapp.entities.Jeu;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.utils.Statics;
import com.sun.mail.smtp.SMTPTransport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;


import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





/**
 *
 * @author jmokh
 */
public class ServiceGame {
     public ArrayList<Jeu> jeux;
     public Picture pic;
    public String urlimage;
     public ArrayList<User> users;
    public static ServiceGame instance;
    private Form f2;
     public boolean resultOK;
     public String json;
     private ConnectionRequest  req;
        private Resources theme;
    private ImageViewer lurl;
    private Label lnom,ldescription;
      public ServiceGame() {
      req = new ConnectionRequest();
    
    }

    public static ServiceGame getInstance() {
        if (instance == null) {
            instance = new ServiceGame();
        }
        return instance;
    }

       public boolean addGame(Jeu j) {
       String url = Statics.BASE_URL +"admin/jeu/new/addjeu?nom="+j.getNom()+"&description="+j.getDescription()+"&url="+j.getUrl()+"&idSouscat="+j.getId_souscat();
       req= new ConnectionRequest(url);
       
       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
        public ArrayList<Jeu> parseTasks(String jsonText) {
        try {
            jeux=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Jeu g = new Jeu();
                float id = Float.parseFloat(obj.get("idJeu").toString());
                g.setId_Jeu((int) id);
                
                Map<String,Object> sscat=(Map<String,Object>) obj.get("idSouscat");
                 String id_sscat = sscat.get("nomSouscat").toString();
              
                g.setNomsscat(id_sscat);

                g.setNom(obj.get("nom").toString());
                g.setDescription(obj.get("description").toString());
                g.setUrl(obj.get("url").toString());
                
                
                if (obj.get("nom")==null)
              g.setNom("null");
                else
                    g.setNom(obj.get("nom").toString());
               
                 if (obj.get("description")==null)
              g.setDescription("null");
                else
                    g.setDescription(obj.get("description").toString());
                
                 if (obj.get("url")==null)
              g.setUrl("null");
                else
                    g.setUrl(obj.get("url").toString());
                jeux.add(g);
                
                
            }
            
            
        } catch (IOException ex) {
      
       
    }
         return jeux;}
        
       
        
        
        public ArrayList<Jeu> getAllGames(){
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"admin/jeu/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                jeux = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return jeux;
    }
        
       
        public boolean deleteGame(int id){
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"admin/jeu/deletejeu?id="+id;
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOK;
    }
        
       public Jeu DetailGame(int id ,Jeu jeu)
       {String url = Statics.BASE_URL+"admin/jeu/displayjeu?id="+id;
         req.setUrl(url);
         String str=new String(req.getResponseData());
           req.addResponseListener(((evt)-> {
               JSONParser j = new JSONParser();
               try 
               {
                   Map<String,Object> obj=j.parseJSON(new CharArrayReader (new String(str).toCharArray()));
                float idjeu = Float.parseFloat(obj.get("idJeu").toString());
                jeu.setId_Jeu((int) id);
                    Map<String,Object> sscat=(Map<String,Object>) obj.get("idSouscat");
                 String id_sscat = sscat.get("nomSouscat").toString();
              
                jeu.setNomsscat(id_sscat);

                jeu.setNom(obj.get("nom").toString());
                jeu.setDescription(obj.get("description").toString());
                jeu.setUrl(obj.get("url").toString());
               } catch(IOException ex)
               {  System.out.println(ex.getMessage());
               
               }
          
               System.out.println("data ======"+str);
               
        }));
           NetworkManager.getInstance().addToQueueAndWait(req);
           return jeu;
       }
        public ArrayList<User> parseUsers(String jsonText) {
        try {
            users=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                User u = new User();
                u.setMail(obj.get("mail").toString());
                users.add(u);
            }
        } catch (IOException ex) {
    }
         return users;}
        
         public ArrayList<User> getAllMailUsers(){
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"admin/jeu/new/users";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users = parseUsers(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return users;
    }
//         public void sendEmail()
//         {
//             try {Properties props =new Properties();
//         props.put("mail.transport.protocol", "smtp");
//		props.put("mail.smtps.host", "smtp.gmail.com");
//
//                props.put("mail.smtps.auth", "true");
//		Session session=Session.getInstance(props,null);
//                MimeMessage msg = new MimeMessage(session);
//                msg.setFrom( new InternetAddress("mohamedmokhtar.jaafar@esprit.tn"));
//                msg.setRecipients(Message.RecipientType.TO, "mohamedmokhtar.jaafar@esprit.tn");
//                msg.setSubject("New content ");
//                msg.setSentDate(new Date(System.currentTimeMillis()));
//                msg.setText("testing mail");
//                SMTPTransport st = (SMTPTransport) session.getTransport("smtps");
//                st.connect("smtp.gmail",465,"mohamedmokhtar.jaafar@esprit.tn","Matfinix1990@");
//                st.sendMessage(msg, msg.getAllRecipients());
//                 System.out.println("server response"+st.getLastServerResponse());
//                
//                
//                
//                
//                
//             }catch (Exception e)
//             {e.getMessage();}
//           
//         }

       public String getImagebyIdjeu(int idjeu)
       { 
           String url=Statics.BASE_URL+"admin/image/new/geturl?idJeu="+idjeu;
        req.setUrl(url);
         
        req.setPost(false);
        req.addResponseListener((e)-> {
          JSONParser j = new JSONParser();    
          json=new String(req.getResponseData());
          try
          {
//              System.out.println("data===="+json);
          Map<String,Object> image=j.parseJSON(new CharArrayReader(json.toCharArray()));
          if(image.get("urlImage")!=null)
          {
             urlimage= image.get("urlImage").toString();
          }else
          {urlimage="1.jpeg";}
          
          }catch(IOException ex)
          {ex.getStackTrace();}
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
       return urlimage;
        }
        
        
}
