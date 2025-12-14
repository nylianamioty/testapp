package com.testapp.controllers;

import com.monframework.annotation.*;
import com.monframework.mvc.JsonResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SimpleApiController extends com.monframework.controller.Controller {
    
    @Json
    @GetMapping("/api/test")
    public Map<String, String> test() {
        System.out.println("=== API TEST CALLED ===");
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello API!");
        response.put("status", "working");
        return response;
    }
    
    @Json
    @GetMapping("/api/user/{id}")
    public Map<String, Object> getUser(int id) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("name", "Jean Dupont");
        user.put("email", "jean@example.com");
        return user;
    }
    
    @GetMapping("/api-page")
    public String apiPage() {
        return "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head><title>Test API</title></head>\n" +
            "<body>\n" +
            "    <h1>Test API JSON</h1>\n" +
            "    <button onclick=\"testApi('/api/test')\">Test API</button>\n" +
            "    <button onclick=\"testApi('/api/user/123')\">Test User</button>\n" +
            "    <pre id=\"result\"></pre>\n" +
            "    <script>\n" +
            "    async function testApi(url) {\n" +
            "        const response = await fetch(url);\n" +
            "        const data = await response.json();\n" +
            "        document.getElementById('result').textContent = \n" +
            "            JSON.stringify(data, null, 2);\n" +
            "    }\n" +
            "    </script>\n" +
            "</body>\n" +
            "</html>";
    }
}