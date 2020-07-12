<%-- 
    Document   : menu
    Created on : 4 juil. 2020, 20:12:39
    Author     : Alec-PC
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu de sélection</title>
    </head>
    <body>
        <h1>Sélectionner une opération à exécuter :</h1>
         <form name="form" action="Controller" method="POST">
         <select name="Operation">
            <option>Récupération des achats d'un client</option>
            <option>Gestion des ventes</option>
            <option>Gestion des stocks</option>
            <option>Gestion des référence produit</option>
            <option>Gestion des clients</option>
        </select>
        <input type="submit" value="Valider" name="validation" />
        </form>
        <%@ include file="footer.jsp"%>  
    </body>
</html>
