package com.testapp.controllers;

import com.monframework.annotation.URLMapping;
import com.monframework.mvc.ModelView;

import jakarta.servlet.http.HttpServletRequest;

@com.monframework.annotation.Controller  
public class PatternController extends com.monframework.controller.Controller {
    
    @URLMapping("/article/{id}")
    public String article(String id) {
        return "<h1>Article ID: " + id + "</h1>";
    }
    
    @URLMapping("/categorie/{cat}/produit/{id}")
    public String produit(String cat, String id) {
        return "<h1>Produit</h1>" +
               "<p>Catégorie: " + cat + "</p>" +
               "<p>ID Produit: " + id + "</p>";
    }
    
    @URLMapping("/user/{username}/profil")
    public ModelView userProfile(String username) {
        ModelView mv = new ModelView();
        mv.setView("profil.jsp");
        mv.addObject("username", username);
        mv.addObject("role", "Utilisateur");
        return mv;
    }
    
    @URLMapping("/api/{type}/{action}/{id}")
    public String apiMethod(HttpServletRequest req) {
        String type = (String) req.getAttribute("type");
        String action = (String) req.getAttribute("action"); 
        String id = (String) req.getAttribute("id");
        return "API - Type: " + type + ", Action: " + action + ", ID: " + id;
    }
}