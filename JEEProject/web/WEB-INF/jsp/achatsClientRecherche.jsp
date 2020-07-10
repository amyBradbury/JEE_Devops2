<%-- 
    Document   : achatsClientRecherche
    Created on : 9 juil. 2020, 22:35:09
    Author     : maeva
--%>

<%@page import="java.util.*" %>
<%@page import="modele.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Selection client</title>
    </head>
    <body>
        <form name="recherche" action="Controleur" method="POST">
           <p>
                <label for="client">Selectionner un client</label>
                 <%            
            out.println("<select name=clients id=client>") ;
          // resultat.getResult().stream();nouveauté java 8 à creurser 
          List <Object> res=resultat.getResult();//jointure native
            
            for(Object  ligne : res){
                out.println("<option value="+String.valueOf(((Customer)ligne).getCustomerId())+">"+((Customer)ligne).getName()+"</option>") ;  
            }
            out.println("</select>") ;
        %>
            </p>
            <input type="submit" value="rechercher" name="Operation" />
        </form>
        
    </body>
</html>
        
           