<%-- 
    Document   : GestionClients
    Created on : 9 juil. 2020, 23:40:03
    Author     : maeva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion Clients</title>
    </head>
    <body>
        <%@page import="java.util.*" %>
        <%@page import="modele.*" %>
        <jsp:useBean id="resultat" class="beans.resultatrequete" scope="request" />
        
        <h1> Liste des clients</h1>
        <form name="Result" action="Controleur" method="POST">
            <input type="submit" value="Ajouter un Client" name="Operation" />
            <table border=1 cellpadding=10>
                <TR>
                <TH>Id</TH>
                <TH>Nom</TH>
                <TH>Code Postal</TH>
                <TH>Adresse</TH>
                <TH>Mail</TH>
                <TH>Code de Réduction</TH>
                </TR>
                <%
                    List <Object> res=resultat.getResult();//jointure native
                    for(Object  ligne : res){
                        out.println("<TR>");           
                        out.println("<TD> <input type=submit value="+String.valueOf(((Customer)ligne).getCustomerId())+" name=Operation /></TD>");
                        out.println("<TD>"+((Customer)ligne).getName()+"</TD>");
                        out.println("<TD>"+((Customer)ligne).getZip()+"</TD>");
                        out.println("<TD>"+((Customer)ligne).getAddressline1()+"<br/>"+((Customer)ligne).getAddressline2()+"</TD>");
                        out.println("<TD>"+((Customer)ligne).getDiscountCode()+"</TD>");
                        out.println("<TD>"+((Customer)ligne).getEmail()+"</TD>");
                        out.println("</TR>");
                    }
                %>
            </table>
        </form>
    </body>
</html>
