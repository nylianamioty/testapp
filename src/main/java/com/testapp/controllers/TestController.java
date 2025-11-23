package com.testapp.controllers;

import com.monframework.annotation.URLMapping;
import com.monframework.mvc.ModelView;
import java.util.Arrays;

@com.monframework.annotation.Controller  
public class TestController extends com.monframework.controller.Controller {
    
    @URLMapping("/page-accueil")
    public ModelView accueil() {
        ModelView mv = new ModelView();
        mv.setView("accueil.jsp");
        mv.addObject("titre", "Page d'Accueil");
        mv.addObject("message", "Bienvenue sur notre site!");
        mv.addObject("produits", Arrays.asList("Laptop", "Smartphone", "Tablette"));
        return mv;
    }
    
    @URLMapping("/profil/{id}")
    public ModelView profil(String id) {
        ModelView mv = new ModelView();
        mv.setView("profil.jsp");
        mv.addObject("userId", id);
        mv.addObject("userName", "Utilisateur " + id);
        mv.addObject("email", "user" + id + "@example.com");
        return mv;
    }
    
    @URLMapping("/direct")
    public String direct() {
        return "<h1>Retour direct en String</h1>";
    }
}