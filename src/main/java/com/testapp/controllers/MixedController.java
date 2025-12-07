package com.testapp.controllers;

import com.monframework.annotation.*; // Les nouvelles annotations
import com.monframework.mvc.ModelView;

@Controller
public class MixedController extends com.monframework.controller.Controller {
    
    // ANCIEN SYSTÈME - continue à fonctionner
    @com.monframework.annotation.URLMapping("/ancien/url")
    public String ancienMethod() {
        return "<h1>Ancien système fonctionne toujours!</h1>";
    }
    
    @com.monframework.annotation.URLMapping("/user/{id}")
    public String ancienAvecParam(int id) {
        return "<h1>Ancien avec paramètre: " + id + "</h1>";
    }
    
    // NOUVEAU SYSTÈME - méthodes HTTP spécifiques
    @GetMapping("/api/users")
    public String getUsers() {
        return "<h1>GET Users (nouveau)</h1>";
    }
    
    @PostMapping("/api/users")
    public String createUser() {
        return "<h1>POST Create User (nouveau)</h1>";
    }
    
    @PutMapping("/api/users/{id}")
    public String updateUser(int id) {
        return "<h1>PUT Update User " + id + " (nouveau)</h1>";
    }
    
    // Mix ancien/nouveau avec ModelView
    @com.monframework.annotation.URLMapping("/page")
    public ModelView pageAncienne() {
        ModelView mv = new ModelView();
        mv.setView("page.jsp");
        mv.addObject("message", "Ancien système avec ModelView");
        return mv;
    }
    
    @GetMapping("/nouvelle/page")
    public ModelView pageNouvelle() {
        ModelView mv = new ModelView();
        mv.setView("page.jsp");
        mv.addObject("message", "Nouveau système avec ModelView");
        return mv;
    }
    
    // Avec @RequestParam (les deux systèmes)
    @com.monframework.annotation.URLMapping("/search")
    public String searchAncien(String query, String category) {
        return "<h1>Search ancien</h1><p>Query: " + query + ", Cat: " + category + "</p>";
    }
    
    @GetMapping("/api/search")
    public String searchNouveau(@RequestParam("q") String query, 
                               @RequestParam("cat") String category) {
        return "<h1>Search nouveau</h1><p>Query: " + query + ", Cat: " + category + "</p>";
    }
}