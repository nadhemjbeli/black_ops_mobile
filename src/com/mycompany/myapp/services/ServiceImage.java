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
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Picture;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jmokh
 */
public class ServiceImage {
     public ArrayList<Picture> images;
    public static ServiceImage instance;
     public boolean resultOK;
     String json;
     private ConnectionRequest  req;
      public ServiceImage() {
      req = new ConnectionRequest();
    }

    public static ServiceImage getInstance() {
        if (instance == null) {
            instance = new ServiceImage();
        }
        return instance;
    }

       public boolean addPic(Picture j) {
       String url = Statics.BASE_URL +"admin/image/new/addimage?urlImage="+j.getUrl_Image()+"&idJeu="+j.getId_jeu();
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
        public ArrayList<Picture> parsepics(String jsonText) {
        try {
            images=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Picture g = new Picture();
                float id = Float.parseFloat(obj.get("idImage").toString());
                g.setId_Image((int) id);
                
                Map<String,Object> sscat=(Map<String,Object>) obj.get("idJeu");
                 String id_sscat = sscat.get("nom").toString();
              
                g.setNomjeu(id_sscat);

                g.setUrl_Image(obj.get("urlImage").toString());
               
   
                images.add(g);
                
                
            }
            
            
        } catch (IOException ex) {
      
       
    }
         return images;}
        
        public ArrayList<Picture> getAllpics(){
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"admin/image/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                images = parsepics(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return images;
    }
        public String getImagebyIdjeu(int idjeu)
        { String url=Statics.BASE_URL+"admin/image/new/geturl?idJeu="+idjeu;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener((e)-> {
          JSONParser j = new JSONParser();    
          String json=new String(req.getResponseData()) + "";
          try
          {System.out.println("data===="+json);
          Map<String,Object> image=j.parseJSON(new CharArrayReader(json.toCharArray()));
          
          }catch(IOException ex)
          {ex.getStackTrace();}
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
       return json;
        }
}
