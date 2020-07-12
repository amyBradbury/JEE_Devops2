/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.*;
import beans.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author jorda
 */
@WebServlet(name = "Controller", urlPatterns = {"/resultat.htm"})
public class Controller extends HttpServlet {

    AppDao requeteur;
    String erreur;

    @Override
    public void init() {

    }

    @Override
    public void destroy() {

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("menu.jsp");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("menu.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Operation : "+request.getParameter("Operation"));
        switch (request.getParameter("Operation")) {
            case "Gestion des clients":
                try {
                    requeteur = new AppDao();
                    resultrequete bean = new resultrequete();
                    bean.setResult(requeteur.GetCustomers());
                    request.setAttribute("resultat", bean);//déclaration de mon javabean dans mes paramètres POST
                    request.getRequestDispatcher("/WEB-INF/jsp/resultat.jsp").forward(request, response);
                    ////renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            break;
            case "Gestion des référence produit":
                try {
                    requeteur = new AppDao();
                    resultrequete bean = new resultrequete();
                    bean.setResult(requeteur.GetCustomers());
                    request.setAttribute("resultat", bean);//déclaration de mon javabean dans mes paramètres POST
                    request.getRequestDispatcher("resultat.jsp").forward(request, response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Gestion des stocks":
        try {
            requeteur = new AppDao();
            resultatRequeteProduit bean = new resultatRequeteProduit();
            bean.setResult(requeteur.GetProducts());
            request.setAttribute("resultatProduit", bean);//déclaration de mon javabean dans mes paramètres POST*
            //renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
        } catch (SQLException e) {
            e.printStackTrace();
        }
                break;
            case "Gestion des ventes":
                try {
                    requeteur = new AppDao();
                    resultrequete bean = new resultrequete();
                    bean.setResult(requeteur.GetCustomers());
                    request.setAttribute("resultat", bean);//déclaration de mon javabean dans mes paramètres POST
                    request.getRequestDispatcher("resultat.jsp").forward(request, response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Récupération des achats d'un client":
                try {
                    requeteur = new AppDao();
                    resultrequete bean = new resultrequete();
                    bean.setResult(requeteur.GetCustomers());
                    request.setAttribute("resultat", bean);//déclaration de mon javabean dans mes paramètres POST
                    request.getRequestDispatcher("resultat.jsp").forward(request, response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Supprimer":
                try {
                    System.out.println("prout");
                    requeteur = new AppDao();
                    String param1 = request.getParameter("Id");
                    requeteur.DeleteCustomer(Integer.parseInt(param1));

                } catch (Exception e) {
                    request.setAttribute("erreur", "erreur requete " + e);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                ;
                request.setAttribute("confirm", "Suppression effectuée");//message de confirmation de suppression envoyé à la jsp
                request.getRequestDispatcher("confirm.jsp").forward(request, response);
                break;
                
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Résultat";
    }// </editor-fold>

}
