<%-- 
    Document   : resultat
    Created on : 9 juil. 2020, 23:23:34
    Author     : jorda
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultat</title>
    </head>
    <body>
        <%@page import="java.util.*" %>
        <%@page import="modele.*" %>
        <jsp:useBean id="resultat" class="beans.resultrequete" scope="request" />
        <h1>Liste des clients</h1>
        <form name="Result" action="Controller" method="POST">
            <%            
            out.println("<table border=1 cellpadding=10>") ;
            out.println("<TR>");
            out.println("<TH>Id</TH>");
            out.println("<TH>Nom</TH>");
            out.println("<TH>Code de Réduction</TH>");
            out.println("<TH>Adresse</TH>");
            out.println("<TH>Code Postal</TH>");
            out.println("<TH>Ville</TH>");
            out.println("<TH>Mail</TH>");
            out.println("<TH>Supprimer</TH>");
            out.println("</TR>");
          List <Object> res=resultat.getResult();//jointure native
            
            for(Object  ligne : res){
                out.println("<TR>");           
                out.println("<TD>"+((Customer)ligne).getCustomerId()+"</TD>");
                out.println("<TD>"+((Customer)ligne).getName()+"</TD>");
                out.println("<TD>"+((Customer)ligne).getDiscountCode()+"</TD>");
                out.println("<TD>"+((Customer)ligne).getAddressline1()+"<br/>"+((Customer)ligne).getAddressline2()+"</TD>");
                out.println("<TD>"+((Customer)ligne).getZip()+"</TD>");
                out.println("<TD>"+((Customer)ligne).getCity()+"</TD>");
                out.println("<TD>"+((Customer)ligne).getEmail()+"</TD>");
                /*jointure réalisée par mappng xml
                out.println("<TD>"+((Customer)resultat.getResult().get(i)).getName()+"</TD>");
                out.println("<TD>"+((Customer)resultat.getResult().get(i)).getDiscountCode().getRate()+"</TD>");*/
                out.println("<TD> <input type=submit formaction=confirm.htm value=Supprimer name=Operation/></TD>");
                out.println("<input type=hidden name=Id value="+String.valueOf(((Customer)ligne).getCustomerId())+" />");
                out.println("</TR>");
                
                
            }
            out.println("<TR>"); 
            out.println("<TD colspan='8' > <input type=submit value=Ajouter name=Operation /></TD>");
            out.println("</TR>"); 
            out.println("</table>");
          
        %>
        </form>
        <%@ include file="footer.jsp"%>  
    </body>
</html>
