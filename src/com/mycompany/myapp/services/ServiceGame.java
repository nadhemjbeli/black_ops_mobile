/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Jeu;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




/**
 *
 * @author jmokh
 */
public class ServiceGame {
     public ArrayList<Jeu> jeux;
    public static ServiceGame instance;
     public boolean resultOK;
     private ConnectionRequest  req;
   
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
        
        
        
        
}
