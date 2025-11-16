package com.testapp.controllers;

import com.monframework.annotation.URLMapping;

// Utilise l'annotation avec le nom complet
@com.monframework.annotation.Controller  
public class TestController extends com.monframework.controller.Controller {
    
    @URLMapping("/hello")
    public String hello() {
        return "<h1>Bonjour depuis le framework!</h1>";
    }
    
    @URLMapping("/users/{id}")
    public String getUser(String id) {
        return "<p>Utilisateur ID: " + id + "</p>";
    }
    
    @URLMapping("/home")
    public String home() {
        return "<html><body><h1>Page d'accueil</h1><p>Bienvenue!</p></body></html>";
    }
}