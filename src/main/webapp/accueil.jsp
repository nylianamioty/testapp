<!DOCTYPE html>
<html>
<head>
    <title>${titre}</title>
</head>
<body>
    <h1>${titre}</h1>
    <p>${message}</p>
    
    <h2>Nos produits:</h2>
    <ul>
        <% java.util.List<String> produits = (java.util.List<String>) request.getAttribute("produits"); %>
        <% for(String produit : produits) { %>
            <li><%= produit %></li>
        <% } %>
    </ul>
    
    <a href="profil/123">Voir profil 123</a> | 
    <a href="direct">Retour direct</a>
</body>
</html>