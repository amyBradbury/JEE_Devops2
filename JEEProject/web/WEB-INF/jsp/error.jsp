<%-- 
    Document   : error
    Created on : 11 juil. 2020, 10:51:48
    Author     : Alec-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1><%=request.getAttribute("erreur")%> </h1>
    </body>
</html>
