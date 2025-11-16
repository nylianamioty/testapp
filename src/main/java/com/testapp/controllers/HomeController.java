package com.testapp.controllers;

import com.monframework.annotation.URLMapping;
import com.monframework.annotation.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class HomeController extends com.monframework.controller.Controller {

    public void init() {
        System.out.println("HomeController initialisé");
    }

    @URLMapping("/home")
    public void home(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Accueil</title></head><body>");
            out.println("<h1>Bienvenue</h1>");
            out.println("<p>Application de test gérée par HomeController.</p>");
            out.println("<ul>");
            out.println("<li><a href='" + req.getContextPath() + "/home'>/home</a></li>");
            out.println("<li><a href='" + req.getContextPath() + "/about'>/about</a></li>");
            out.println("</ul>");
            out.println("</body></html>");
        }
    }
    
    @URLMapping("/about")
    public void about(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>À propos</title></head><body>");
            out.println("<h1>À propos</h1>");
            out.println("<p>Mini framework de démonstration.</p>");
            out.println("<p><a href='" + req.getContextPath() + "/home'>← Retour</a></p>");
            out.println("</body></html>");
        }
    }
}
