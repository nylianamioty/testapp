package com.testapp.controllers;

import com.monframework.annotation.*;
import com.testapp.models.Employee;

import jakarta.servlet.http.HttpServletRequest;

import com.testapp.models.Department;

@Controller
public class BindingController extends com.monframework.controller.Controller {
    
    @PostMapping("/save-employee")
    public String saveEmployee(Employee e) {
        StringBuilder result = new StringBuilder();
        result.append("<h1>Employee sauvegardé</h1>");
        result.append("<p>Nom: ").append(e.getName()).append("</p>");
        
        if (e.getDepartment() != null) {
            result.append("<h2>Départements:</h2>");
            for (int i = 0; i < e.getDepartment().length; i++) {
                Department dept = e.getDepartment()[i];
                result.append("<p>Dept[").append(i).append("]: ")
                      .append(dept.getName()).append("</p>");
            }
        }
        
        return result.toString();
    }
    
    // @PostMapping("/save-employees")
    // public String saveEmployees(Employee[] es, Department d, int deptId) {
    //     StringBuilder result = new StringBuilder();
    //     result.append("<h1>Employés sauvegardés</h1>");
        
    //     if (es != null) {
    //         result.append("<p>Nombre d'employés: ").append(es.length).append("</p>");
    //         for (int i = 0; i < es.length; i++) {
    //             result.append("<p>Employé[").append(i).append("]: ")
    //                   .append(es[i].getName()).append("</p>");
    //         }
    //     }
        
    //     result.append("<p>Département: ").append(d.getName()).append("</p>");
    //     result.append("<p>Dept ID: ").append(deptId).append("</p>");
        
    //     return result.toString();
    // }
    
   @GetMapping("/form")
    public String showForm(HttpServletRequest request) {
        String contextPath = request.getContextPath(); // "/testapp-1.0.0"
        
        return "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head><title>Formulaire Test</title></head>\n" +
            "<body>\n" +
            "    <h1>Test Binding Objet</h1>\n" +
            "    <form action=\"" + contextPath + "/save-employee\" method=\"POST\">\n" +
            "        <p>Nom employé: <input name=\"name\" value=\"John\" /></p>\n" +
            "        <p>Département 1: <input name=\"department[0].name\" value=\"IT\" /></p>\n" +
            "        <p>Département 2: <input name=\"department[1].name\" value=\"HR\" /></p>\n" +
            "        <button type=\"submit\">Envoyer</button>\n" +
            "    </form>\n" +
            "</body>\n" +
            "</html>";
    }
}