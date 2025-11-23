package com.testapp.controllers;

import com.monframework.annotation.URLMapping;
import com.monframework.annotation.RequestParam;

@com.monframework.annotation.Controller  
public class RequestParamController extends com.monframework.controller.Controller {
    
    // Avec @RequestParam - les noms sont explicites
    @URLMapping("/search")
    public String search(
        @RequestParam("query") String query, 
        @RequestParam("category") String category, 
        @RequestParam("page") int page) {
        
        return "<h1>Résultats de recherche</h1>" +
               "<p>Query: " + query + "</p>" +
               "<p>Catégorie: " + category + "</p>" +
               "<p>Page: " + page + "</p>";
    }
    
    @URLMapping("/user/{id}/edit")
    public String editUser(
        String id, // Paramètre URL (sans annotation)
        @RequestParam("name") String nom, 
        @RequestParam("email") String email) {
        
        return "<h1>Édition Utilisateur</h1>" +
               "<p>ID: " + id + "</p>" +
               "<p>Nom: " + nom + "</p>" +
               "<p>Email: " + email + "</p>";
    }
    
    // Paramètres optionnels avec valeurs par défaut
    @URLMapping("/products")
    public String products(
        @RequestParam(value = "category", required = false, defaultValue = "all") String category,
        @RequestParam(value = "sort", required = false, defaultValue = "name") String sort,
        @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        
        return "<h1>Produits</h1>" +
               "<p>Catégorie: " + category + "</p>" +
               "<p>Tri: " + sort + "</p>" +
               "<p>Limit: " + limit + "</p>";
    }
    
    // Types numériques avec @RequestParam
    @URLMapping("/calc")
    public String calculate(
        @RequestParam("a") double a,
        @RequestParam("b") double b,
        @RequestParam("operation") String operation) {
        
        double result = 0;
        if ("add".equals(operation)) result = a + b;
        else if ("multiply".equals(operation)) result = a * b;
        
        return "<h1>Calculatrice</h1><p>" + a + " " + operation + " " + b + " = " + result + "</p>";
    }
    
    // Test avec paramètre requis manquant (doit générer une erreur)
    @URLMapping("/required-test")
    public String requiredTest(@RequestParam("id") int id) {
        return "<p>ID: " + id + "</p>";
    }
}