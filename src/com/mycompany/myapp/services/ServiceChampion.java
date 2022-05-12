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
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Champion;
import com.mycompany.myapp.entities.Jeu;
import com.mycompany.myapp.entities.Picture;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jmokh
 */

    public class ServiceChampion {
     public ArrayList<Champion> champions;
     public Picture pic;
    public String urlimage;
     public ArrayList<User> users;
    public static ServiceChampion instance;
    private Form f2;
     public boolean resultOK;
     public String json;
     private ConnectionRequest  req;
        private Resources theme;
    private ImageViewer lurl;
    private Label lnom,ldescription;
      public ServiceChampion() {
      req = new ConnectionRequest();
    
    }

    public static ServiceChampion getInstance() {
        if (instance == null) {
            instance = new ServiceChampion();
        }
        return instance;
    }

       public boolean addChampion(Champion j) {
       String url = Statics.BASE_URL +"admin/champion/new/addchamp?nomChamp="+j.getNom_Champ()+"&descriptionChamp="+j.getDescription_Champ()+"&roleChamp="+j.getRole_Champ()+"&difficulteChamp="+j.getDifficulte_Champ()+"&imageChamp="+j.getImage_Champ()+"&idJeu="+j.getId_jeu();
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
//        public ArrayList<Champion> parseTasks(String jsonText) {
//        try {
//            champions=new ArrayList<>();
//            JSONParser j = new JSONParser();
//            Map<String,Object> tasksListJson = 
//               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
//            
//            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
//            for(Map<String,Object> obj : list){
//                Jeu g = new Jeu();
//                float id = Float.parseFloat(obj.get("idJeu").toString());
//                g.setId_Jeu((int) id);
//                
//                Map<String,Object> sscat=(Map<String,Object>) obj.get("idSouscat");
//                 String id_sscat = sscat.get("nomSouscat").toString();
//              
//                g.setNomsscat(id_sscat);
//
//                g.setNom(obj.get("nom").toString());
//                g.setDescription(obj.get("description").toString());
//                g.setUrl(obj.get("url").toString());
//                
//                
//                if (obj.get("nom")==null)
//              g.setNom("null");
//                else
//                    g.setNom(obj.get("nom").toString());
//               
//                 if (obj.get("description")==null)
//              g.setDescription("null");
//                else
//                    g.setDescription(obj.get("description").toString());
//                
//                 if (obj.get("url")==null)
//              g.setUrl("null");
//                else
//                    g.setUrl(obj.get("url").toString());
//                champions.add(g);
//                
//                
//            }
//            
//            
//        } catch (IOException ex) {
//      
//       
//    }
//         return champions;}
//        
//       
//        
//        
//        public ArrayList<Champion> getAllGames(){
//        //String url = Statics.BASE_URL+"/tasks/";
//        String url = Statics.BASE_URL+"admin/jeu/";
//        req.setUrl(url);
//        req.setPost(false);
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                champions = parseTasks(new String(req.getResponseData()));
//                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return champions;
//    }
//        
//       
//        public boolean deleteGame(int id){
//        //String url = Statics.BASE_URL+"/tasks/";
//        String url = Statics.BASE_URL+"admin/jeu/deletejeu?id="+id;
//        req.setUrl(url);
//        
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                
//                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return  resultOK;
//    }
//        
//       public Jeu DetailGame(int id ,Jeu jeu)
//       {String url = Statics.BASE_URL+"admin/jeu/displayjeu?id="+id;
//         req.setUrl(url);
//         String str=new String(req.getResponseData());
//           req.addResponseListener(((evt)-> {
//               JSONParser j = new JSONParser();
//               try 
//               {
//                   Map<String,Object> obj=j.parseJSON(new CharArrayReader (new String(str).toCharArray()));
//                float idjeu = Float.parseFloat(obj.get("idJeu").toString());
//                jeu.setId_Jeu((int) id);
//                    Map<String,Object> sscat=(Map<String,Object>) obj.get("idSouscat");
//                 String id_sscat = sscat.get("nomSouscat").toString();
//              
//                jeu.setNomsscat(id_sscat);
//
//                jeu.setNom(obj.get("nom").toString());
//                jeu.setDescription(obj.get("description").toString());
//                jeu.setUrl(obj.get("url").toString());
//               } catch(IOException ex)
//               {  System.out.println(ex.getMessage());
//               
//               }
//          
//               System.out.println("data ======"+str);
//               
//        }));
//           NetworkManager.getInstance().addToQueueAndWait(req);
//           return jeu;
//       }
//        public ArrayList<User> parseUsers(String jsonText) {
//        try {
//            users=new ArrayList<>();
//            JSONParser j = new JSONParser();
//            Map<String,Object> tasksListJson = 
//               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
//            
//            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
//            for(Map<String,Object> obj : list){
//                User u = new User();
//                u.setMail(obj.get("mail").toString());
//                users.add(u);
//            }
//        } catch (IOException ex) {
//    }
//         return users;}
//        
//         public ArrayList<User> getAllMailUsers(){
//        //String url = Statics.BASE_URL+"/tasks/";
//        String url = Statics.BASE_URL+"admin/jeu/new/users";
//        req.setUrl(url);
//        req.setPost(false);
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                users = parseUsers(new String(req.getResponseData()));
//                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return users;
//    }
//
       public ArrayList<Champion>parseChampions(String jsonText)
       {
        try {
            champions=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Champion g = new Champion();
                
                
                Map<String,Object> sscat=(Map<String,Object>) obj.get("idJeu");
                 String id_sscat = sscat.get("nom").toString();
              
                g.setNomJeu(id_sscat);

                g.setNom_Champ(obj.get("nomChamp").toString());
                g.setDescription_Champ(obj.get("descriptionChamp").toString());
                g.setRole_Champ(obj.get("roleChamp").toString());
                g.setDifficulte_Champ(obj.get("difficulteChamp").toString());
                g.setImage_Champ(obj.get("imageChamp").toString());

                champions.add(g);
 
            }
            
            
        } catch (IOException ex) {
      
       
    }
         return champions;}
        
        public ArrayList<Champion> getChampionsbyIdjeu(int idJeu){
        
        String url = Statics.BASE_URL+"admin/champion/new/getchampion?idJeu="+idJeu;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                champions = parseChampions(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return champions;
    }
}

