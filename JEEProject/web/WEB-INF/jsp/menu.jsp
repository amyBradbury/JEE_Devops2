<%-- 
    Document   : menu
    Created on : 4 juil. 2020, 20:12:39
    Author     : Alec-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenue dans le menu</h1>
        <h2><%=session.getAttribute("login")%></h2>
    </body>
</html>
