<%-- 
    Document   : confirm
    Created on : 11 juil. 2020, 10:50:38
    Author     : Alec-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
    </head>
    <body>
        <h1><%=request.getAttribute("confirm")%> </h1>
        <form action="resultat.htm" method="POST">
        <input type="submit" value="Gestion des clients" name="Operation" />
        </form>
    </body>
</html>