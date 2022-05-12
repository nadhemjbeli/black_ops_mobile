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
import com.mycompany.myapp.entities.Defi;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;
import java.util.Map;

/**
 *
 * @author medaz
 */
public class ServiceDefi {
    public ArrayList<Defi> defix;
    public static ServiceDefi instance;
     public boolean resultOK;
     private ConnectionRequest  req;
      public ServiceDefi() {
      req = new ConnectionRequest();
    }

    public static ServiceDefi getInstance() {
        if (instance == null) {
            instance = new ServiceDefi();
        }
        return instance;
    }

       public boolean addGame(Defi j) {
       String url = Statics.BASE_URL +"admin/defi/new/addDefi?nomDefi="+j.getNom_Defi()+"&descriptionDefi="+j.getDescription()+"&imgDefi="+j.getImg_Defi()+"&prixDefi="+j.getPrix()+"&nbrEquipeDefi="+j.getNbr_equipe_Defi()+"&regleDefi="+j.getRégle_Defi()+"&recompenseDefi="+j.getRecompense_Defi()+"&jeuDefi="+j.getJeu_Defis();
       req= new ConnectionRequest(url);
           System.out.println("url"+ url);
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
        public ArrayList<Defi> parseTasks(String jsonText){
        try {
            defix=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Defi g = new Defi();
                String jeuDefi ;
                float id = Float.parseFloat(obj.get("idDefi").toString());
                g.setId_Defi((int) id);
                
                Map<String,Object> sscat=(Map<String,Object>) obj.get("jeuDefi");
                 jeuDefi = sscat.get("nom").toString();
              
                g.setNom_Jeu(jeuDefi);
                java.util.Date date = Calendar.getInstance().getTime();;
                 
                g.setNom_Defi(obj.get("nomDefi").toString());
                g.setImg_Defi(obj.get("imgDefi").toString());
                g.setDescription(obj.get("descriptionDefi").toString());
                g.setPrix(((int)Float.parseFloat(obj.get("prixDefi").toString())));
                g.setRégle_Defi(obj.get("regleDefi").toString());
                g.setNbr_equipe_Defi((int)Float.parseFloat(obj.get("nbrEquipeDefi").toString()));
                g.setDate_defi(date);
                g.setRecompense_Defi(obj.get("recompenseDefi").toString());
                
                if (obj.get("nomDefi")==null)
                g.setNom_Defi("null");
                else
                    g.setNom_Defi(obj.get("nomDefi").toString());
                System.out.println(g.getNom_Jeu());
                defix.add(g);
                
                
            }
            
            
        } catch (IOException ex) {
      
       
    }
         return defix;}
        
        public ArrayList<Defi> GetAllDefi(){
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"admin/defi/all";
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
