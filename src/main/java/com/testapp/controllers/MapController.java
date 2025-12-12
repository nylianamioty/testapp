package com.testapp.controllers;

import com.monframework.annotation.*;
import com.monframework.mvc.ModelAndView;
import java.util.Map;

@Controller
public class MapController extends com.monframework.controller.Controller {
    
    // Avec Map<String, Object> comme paramètre
    @GetMapping("/user/{id}/edit")
    public ModelAndView editUser(Map<String, Object> data, int id) {
        // La Map 'data' contient TOUS les paramètres
        ModelAndView mv = new ModelAndView();
        mv.setView("editUser.jsp");
        
        // Ajouter l'ID au modèle
        mv.addObject("userId", id);
        
        // Ajouter aussi tous les paramètres reçus
        mv.addObject("allParams", data);
        
        // Ajouter des données supplémentaires
        mv.addObject("userName", data.get("name"));
        mv.addObject("userEmail", data.get("email"));
        
        return mv;
    }
    
    // Formulaire avec Map
    @PostMapping("/user/save")
    public String saveUser(Map<String, Object> data) {
        // Tous les paramètres du formulaire sont dans 'data'
        String name = (String) data.get("name");
        String email = (String) data.get("email");
        String ageStr = (String) data.get("age");
        
        int age = ageStr != null ? Integer.parseInt(ageStr) : 0;
        
        return "<h1>Utilisateur sauvegardé</h1>" +
               "<p>Nom: " + name + "</p>" +
               "<p>Email: " + email + "</p>" +
               "<p>Âge: " + age + "</p>" +
               "<p>Total paramètres: " + data.size() + "</p>";
    }
    
    // Mix Map et paramètres individuels
    @GetMapping("/search")
    public String search(Map<String, Object> params, String query, String category) {
        return "<h1>Recherche</h1>" +
               "<p>Query: " + query + "</p>" +
               "<p>Category: " + category + "</p>" +
               "<p>Tous les paramètres: " + params + "</p>";
    }
    
    // Avec attributs de requête
    @GetMapping("/profile")
    public ModelAndView profile(Map<String, Object> allData) {
        // Ajouter un attribut pour le test
        // (normalement ajouté par un filtre ou autre contrôleur)
        
        ModelAndView mv = new ModelAndView("profile.jsp");
        mv.addObject("userData", allData);
        return mv;
    }
}