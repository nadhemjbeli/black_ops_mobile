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
import com.mycompany.myapp.entities.Joueur;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author medaz
 */
public class ServiceJoueur {
    public ArrayList<Joueur> defix;
    public static ServiceJoueur instance;
     public boolean resultOK;
     private ConnectionRequest  req;
      public ServiceJoueur() {
      req = new ConnectionRequest();
    }

    public static ServiceJoueur getInstance() {
        if (instance == null) {
            instance = new ServiceJoueur();
        }
        return instance;
    }

       public boolean add(Joueur j) 
       {
       String url = Statics.BASE_URL +"client/joueur/new/AddJoueurs";
       req.setUrl(url);

       req.addArgument("nomJoueur", j.getNom_Joueur());
       req.addArgument("pseaudoJoueur", j.getPseaudo_Joueur());
       req.addArgument("rangJoueur", j.getRang_Joueur());
       req.addArgument("Tel", j.getTel());
       
       req.addArgument("idEquipe",""+j.getId_equipe());
       req.addArgument("idUser",""+j.getId_user());
       System.out.println(url);
       try{
       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
       
       NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
        
       }catch(Exception e){
           System.out.println("Problem");
           resultOK = false ;
           return resultOK;
       }
       }
        public ArrayList<Joueur> parseTasks(String jsonText){
        try {
            defix=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Joueur g = new Joueur();
                String eq ;
                float id = Float.parseFloat(obj.get("idJoueur").toString());
                g.setId_Joueur((int) id);
                
                Map<String,Object> sscat=(Map<String,Object>) obj.get("idEquipe");
                 eq = sscat.get("nomEquipe").toString();
                Map<String,Object> usermap=(Map<String,Object>) obj.get("idUser");
                 String user = usermap.get("username").toString();
                g.setNom_Joueur(eq);
                
               g.setTel(obj.get("Tel").toString());
                g.setNom_Joueur(obj.get("nomJoueur").toString());
                g.setRang_Joueur(obj.get("rangJoueur").toString());
                g.setUsername(user);
                g.setNom_equipe(eq);
                g.setPseaudo_Joueur(obj.get("pseaudoJoueur").toString());
                
                System.out.println(g.getTel());
                
                if (obj.get("nomJoueur")==null)
                g.setNom_Joueur("null");
                else
                    g.setNom_Joueur(obj.get("nomJoueur").toString());
                if (obj.get("Tel")==null)
                g.setTel("null");
                else
                    g.setTel(obj.get("Tel").toString());
               
                defix.add(g);
                
                
            }
            
            
        } catch (IOException ex) {
      
       
    }
         return defix;}
        
        public ArrayList<Joueur> GetAllDefi(){
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"client/joueur/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                defix = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return defix;
    }
}
