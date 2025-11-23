package com.testapp.controllers;

import com.monframework.annotation.URLMapping;

@com.monframework.annotation.Controller  
public class ParameterController extends com.monframework.controller.Controller {
    
    @URLMapping("/search")
    public String search(String query, String category, String page) {
        return "<h1>Résultats de recherche</h1>" +
               "<p>Query: " + query + "</p>" +
               "<p>Catégorie: " + category + "</p>" +
               "<p>Page: " + page + "</p>";
    }
    
    @URLMapping("/user/{id}/edit")
    public String editUser(String id, String name, String email) {
        return "<h1>Édition Utilisateur</h1>" +
               "<p>ID: " + id + "</p>" +
               "<p>Nom: " + name + "</p>" +
               "<p>Email: " + email + "</p>";
    }
    
    @URLMapping("/test")
    public String test(String param1, String param2) {
        return "<h1>Test Paramètres</h1>" +
               "<p>Param1: " + param1 + "</p>" +
               "<p>Param2: " + param2 + "</p>";
    }
}