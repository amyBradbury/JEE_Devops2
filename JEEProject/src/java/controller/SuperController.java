/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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

@Controller
public class SuperController {

    
    @RequestMapping("/resultat.htm")
    public ModelAndView resultat(HttpServletRequest request, HttpServletResponse response) {
        
        System.out.println("prout");
        
        AppDao requeteur;
        String erreur;

        switch (request.getParameter("Operation")) {
            case "Gestion des clients":
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
}
