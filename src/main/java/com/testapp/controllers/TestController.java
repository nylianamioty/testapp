package com.testapp.controllers;

import com.monframework.annotation.URLMapping;
import com.monframework.mvc.ModelView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@com.monframework.annotation.Controller  
public class TestController extends com.monframework.controller.Controller {
    
    @URLMapping("/hello")
    public String hello() {
        return "<h1>Bonjour depuis le framework!</h1><p>Ceci est un retour String direct</p>";
    }
    
    @URLMapping("/home")
    public ModelView home() {
        ModelView mv = new ModelView();
        mv.setView("test.jsp");
        mv.addObject("message", "Bienvenue sur la page d'accueil!");
        mv.addObject("users", new String[]{"Jean", "Marie", "Paul"});
        return mv;
    }
    
    @URLMapping("/users/{id}")
    public ModelView getUser(String id) {
        ModelView mv = new ModelView();
        mv.setView("user.jsp");
        mv.addObject("userId", id);
        mv.addObject("userName", "Utilisateur " + id);
        return mv;
    }
    
    @URLMapping("/api/info")
    public String apiInfo(HttpServletRequest req, HttpServletResponse res) {
        res.setContentType("application/json");
        return "{\"status\":\"success\",\"message\":\"API Info\"}";
    }
}