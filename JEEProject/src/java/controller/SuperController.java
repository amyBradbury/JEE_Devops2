/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.resultatRequeteProduit;
import beans.resultrequete;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.AppDao;
import modele.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Alec-PC
 */

public class SuperController {

    AppDao requeteur;
    String erreur;

    public ModelAndView resultat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        switch (request.getParameter("Operation")) {
            case "Gestion des clients":
                try {
                    requeteur = new AppDao();
                    resultrequete bean = new resultrequete();
                    bean.setResult(requeteur.GetCustomers());
                    request.setAttribute("resultat", bean);//déclaration de mon javabean dans mes paramètres POST
                    request.getRequestDispatcher("/WEB-INF/jsp/resultat.jsp").forward(request, response);
                    return new ModelAndView("resultat");
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
                    try {
                        request.getRequestDispatcher("resultat.jsp").forward(request, response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                    } catch (ServletException ex) {
                        Logger.getLogger(SuperController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(SuperController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Gestion des stocks":
                ModelAndView metv = null;
                try {
                    metv = ResultatProduit(request, response);
                    return metv;
                } catch (Exception e) {
                }
                break;
            case "Gestion des ventes":
                try {
                    requeteur = new AppDao();
                    resultrequete bean = new resultrequete();
                    bean.setResult(requeteur.GetCustomers());
                    request.setAttribute("resultat", bean);//déclaration de mon javabean dans mes paramètres POST
                    try {
                        request.getRequestDispatcher("resultat.jsp").forward(request, response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                    } catch (ServletException ex) {
                        Logger.getLogger(SuperController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(SuperController.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    try {
                        request.getRequestDispatcher("resultat.jsp").forward(request, response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                    } catch (ServletException ex) {
                        Logger.getLogger(SuperController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(SuperController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

        }
        return null;
    }

    @RequestMapping("/confirm.htm")
    public ModelAndView confirm(HttpServletRequest request, HttpServletResponse response) {

        try {

            requeteur = new AppDao();
            String param1 = request.getParameter("Id");
            requeteur.DeleteCustomer(Integer.parseInt(param1));

        } catch (Exception e) {
            request.setAttribute("erreur", "erreur requete " + e);
            return new ModelAndView("error");
        }
        request.setAttribute("confirm", "Suppression effectuée");//message de confirmation de suppression envoyé à la jsp
        return new ModelAndView("confirm");
    }

    @RequestMapping("/ResultatProduit.htm")
    public ModelAndView ResultatProduit(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView metv = null;
        try {
            requeteur = new AppDao();
            resultatRequeteProduit bean = new resultatRequeteProduit();
            bean.setResult(requeteur.GetProducts());
            request.setAttribute("resultatProduit", bean);//déclaration de mon javabean dans mes paramètres POST
            metv = new ModelAndView("resultatProduit");

            //renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return metv;
    }
}
