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
        <jsp:useBean id="resultatProduit" class="beans.resultatRequeteProduit" scope="request" />
        <form name="resultatRequeteProduit" action="Controller" method="POST">
            <%            
            out.println("<table border=1 cellpadding=10>") ;
          List <Object> res=resultatProduit.getResult();//jointure native
            
            for(Object  ligne : res){
                out.println("<TR>");           
                out.println("<TD>"+((Product)ligne).getProductCode()+"</TD>");
                out.println("<TD>"+((Product)ligne).getDescription()+"</TD>");
                out.println("<TD>"+((Product)ligne).getAvailable()+"</TD>");
                out.println("<TD>"+((Product)ligne).getPurchaseCost()+"</TD>");
                out.println("<TD>"+((Product)ligne).getQuantityOnHand()+"</TD>");
                out.println("<TD>"+((Product)ligne).getManufacturerId()+"</TD>");
                out.println("<TD>"+((Product)ligne).getProductId()+"</TD>");
                out.println("<TD> <input type=submit formaction=confirm.htm value=Supprimer name=Operation/></TD>");
                out.println("<input type=hidden name=Id value="+String.valueOf(((Product)ligne).getProductId())+" />");
                out.println("</TR>");
                
                
            }
            out.println("<TR>"); 
            out.println("<TD> <input type=submit value=Ajouter name=Operation /></TD>");
            out.println("</TR>"); 
            out.println("</table>");
          
        %>
        </form>
        <%@ include file="footer.jsp"%>  
    </body>
</html>
