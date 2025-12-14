<!DOCTYPE html>
<html>
<head>
    <title>Test JSP</title>
</head>
<body>
    <h1>Page JSP chargée via ModelView!</h1>
    <p>Message: ${message}</p>
    
    <h2>Liste des utilisateurs:</h2>
    <ul>
        <% String[] users = (String[]) request.getAttribute("users"); %>
        <% for(String user : users) { %>
            <li><%= user %></li>
        <% } %>
    </ul>
    
    <a href="hello">Test retour String</a>
</body>
</html>