package com.testapp.controllers;

import com.monframework.annotation.URLMapping;

@com.monframework.annotation.Controller  
public class UrlInjectionController extends com.monframework.controller.Controller {
    
    // Injection par nom - URL param {id} → paramètre id
    @URLMapping("/user/{id}/profile")
    public String userProfile(int id, String name) {
        return "<h1>Profil Utilisateur</h1>" +
               "<p>ID: " + id + "</p>" +
               "<p>Nom: " + name + "</p>";
    }
    
    // Multiple URL params
    @URLMapping("/categorie/{cat}/produit/{id}")
    public String produit(String cat, int id, String action) {
        return "<h1>Produit</h1>" +
               "<p>Catégorie: " + cat + "</p>" +
               "<p>ID: " + id + "</p>" +
               "<p>Action: " + action + "</p>";
    }
    
    // Mix URL params + query params
    @URLMapping("/api/{version}/data")
    public String apiData(String version, String type, int limit) {
        return "<h1>API Data</h1>" +
               "<p>Version: " + version + "</p>" +
               "<p>Type: " + type + "</p>" +
               "<p>Limit: " + limit + "</p>";
    }
    
    // Test simple
    @URLMapping("/test/{value}")
    public String test(String value, String param) {
        return "<h1>Test</h1>" +
               "<p>Value: " + value + "</p>" +
               "<p>Param: " + param + "</p>";
    }
}