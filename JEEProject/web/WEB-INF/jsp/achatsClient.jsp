<%-- 
    Document   : resultatAchats
    Created on : 9 juil. 2020, 22:42:23
    Author     : maeva
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Achats du client</title>
    </head>
    <body>
        <%@page import="java.util.*" %>
        <%@page import="modele.*" %>
        <jsp:useBean id="resultat" class="beans.resultatrequete" scope="request" />
        <form name="Result" action="Controleur" method="POST">
        
            <%            
            out.println("<table border=1 cellpadding=10>") ;
          // resultat.getResult().stream();nouveauté java 8 à creurser 
          List <Object> res=resultat.getResult();//jointure native
          
            out.println("<TR>");
            out.println("<TH>Numéro de Commande</TH>");
            out.println("<TH>Id Produit</TH>");
            out.println("<TH>Quantité</TH>");
            out.println("<TH>Date Ventes</TH>");
            out.println("<TH>Date d'expédition</TH>");
            out.println("</TR>");
            
            for(Object  ligne : res){
                out.println("<TR>");           
                out.println("<TD> <input type=submit value="+String.valueOf(((PurchaseOrder)ligne).getOrderNum())+" name=Operation /></TD>");
                out.println("<TD>"+((PurchaseOrder)ligne).getProductId()+"</TD>");
                /* liste nom produit ?
                out.println("<TD>"+((PurchaseOrder)resultat.getResult() +"</TD>");*/
                out.println("<TD>"+((PurchaseOrder)ligne).getQuantity()+"</TD>");
                out.println("<TD>"+((PurchaseOrder)ligne).getSalesDate()+"</TD>");
                out.println("<TD>"+((PurchaseOrder)ligne).getSalesDate()+"</TD>");
                out.println("<TD>"+((PurchaseOrder)ligne).getShippingDate()+"</TD>");
                out.println("</TR>");
            }
            out.println("</table>");
        %>
        </form>
        <%@ include file="footer.jsp"%>  
    </body>
</html>
