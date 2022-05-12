/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form{
Form current;
    public HomeForm() {
        current=this; //Back 
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAddTask = new Button("Add Message");
        Button btnListTasks = new Button("List Message");
	Button btnAddDefi = new Button("Add Defi");
        Button btnListDefis = new Button("List Defi");
         Button btnAddJoueur = new Button("Add Joueur");
        Button btnListJoueurs = new Button("List Joueur");
        
        
        btnAddDefi.addActionListener(e-> new AddDefiForm(current).show());
        btnListDefis.addActionListener(e-> new ListDefisForm(current).show());
        btnAddJoueur.addActionListener(e-> new AddJoueurFrom(current).show());
        btnListJoueurs.addActionListener(e-> new ListJoueurFrom(current).show());
        
        btnAddTask.addActionListener(e-> new AddTaskForm(current).show());
        btnListTasks.addActionListener(e-> new ListTasksForm(current).show());
        addAll(btnAddDefi,btnListDefis,btnAddJoueur,btnListJoueurs,btnAddTask,btnListTasks);
        
        
    }
    
    
}
