package com.testapp.controllers;

import java.util.Collection;

import com.monframework.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

@Controller
public class FileUploadController extends com.monframework.controller.Controller {
    
    @PostMapping("/upload")
    public String handleUpload(HttpServletRequest request) {
        try {
            StringBuilder result = new StringBuilder();
            result.append("<h1>DEBUG Upload</h1>");
            
            // Vérifier si c'est multipart
            if (request.getContentType() != null && 
                request.getContentType().startsWith("multipart/form-data")) {
                
                result.append("<p>Content-Type: ").append(request.getContentType()).append("</p>");
                
                // Récupérer les parts
                Collection<Part> parts = request.getParts();
                result.append("<p>Nombre de parts: ").append(parts.size()).append("</p>");
                
                for (Part part : parts) {
                    result.append("<p>Part: ").append(part.getName()).append("</p>");
                    result.append("<p>  Type: ").append(part.getContentType()).append("</p>");
                    result.append("<p>  Taille: ").append(part.getSize()).append("</p>");
                }
            } else {
                result.append("<p>Pas multipart!</p>");
            }
            
            return result.toString();
            
        } catch (Exception e) {
            return "<h1>Erreur</h1><p>" + e.getMessage() + "</p>";
        }
    }
    
    @GetMapping("/upload-form")
    public String showUploadForm() {
        return "<!DOCTYPE html>\n" +
               "<html>\n" +
               "<head><title>Upload Test</title></head>\n" +
               "<body>\n" +
               "    <h1>Test Upload Simple</h1>\n" +
               "    <form action=\"upload\" method=\"POST\" enctype=\"multipart/form-data\">\n" +
               "        <p>Nom: <input type=\"text\" name=\"name\" value=\"Test\" /></p>\n" +
               "        <p>Fichier: <input type=\"file\" name=\"file\" /></p>\n" +
               "        <button type=\"submit\">Upload</button>\n" +
               "    </form>\n" +
               "</body>\n" +
               "</html>";
    }
}