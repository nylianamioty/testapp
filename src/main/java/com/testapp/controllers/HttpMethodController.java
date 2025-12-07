package com.testapp.controllers;

import com.monframework.annotation.*;
import com.monframework.mvc.ModelView;

@Controller
public class HttpMethodController extends com.monframework.controller.Controller {
    
    // GET seulement
    @GetMapping("/users")
    public String getAllUsers() {
        return "<h1>Liste des utilisateurs (GET)</h1>";
    }
    
    // GET avec paramètre
    @GetMapping("/users/{id}")
    public String getUser(int id) {
        return "<h1>Utilisateur " + id + " (GET)</h1>";
    }
    
    // POST seulement
    @PostMapping("/users")
    public String createUser() {
        return "<h1>Créer utilisateur (POST)</h1>";
    }
    
    // PUT seulement
    @PutMapping("/users/{id}")
    public String updateUser(int id) {
        return "<h1>Modifier utilisateur " + id + " (PUT)</h1>";
    }
    
    // DELETE seulement
    @DeleteMapping("/users/{id}")
    public String deleteUser(int id) {
        return "<h1>Supprimer utilisateur " + id + " (DELETE)</h1>";
    }
    
    // RequestMapping avec méthode spécifiée
    @RequestMapping(value = "/data", method = "POST")
    public String postData() {
        return "<h1>Données (POST via RequestMapping)</h1>";
    }
    
    // RequestMapping sans méthode (par défaut GET)
    @RequestMapping("/info")
    public String getInfo() {
        return "<h1>Info (GET par défaut)</h1>";
    }
    
    // Mix avec ModelView
    @GetMapping("/form")
    public ModelView showForm() {
        ModelView mv = new ModelView();
        mv.setView("form.jsp");
        return mv;
    }
    
    @PostMapping("/submit")
    public String handleSubmit(@RequestParam("name") String name) {
        return "<h1>Formulaire soumis</h1><p>Nom: " + name + "</p>";
    }
}