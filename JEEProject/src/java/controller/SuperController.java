/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author Alec-PC
 */
@Controller 
public class SuperController {

    @RequestMapping("/accueil.htm")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        
        System.out.println("accueil controller");
        HttpSession session = request.getSession();

        if (session.getAttribute("login") == null) {
            System.out.println("if yes");
            return new ModelAndView("redirect:/JEEProject/connexion");
            
        } else {
            System.out.println("yes else");
            User user = new User(request.getUserPrincipal().getName());
            session.setAttribute("login", user.getLogin());
            return new ModelAndView("redirect:/JEEProject/menu");
            
        }
    }
    
    @RequestMapping("/menu.htm")
    public ModelAndView menu(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("in menu");
        return new ModelAndView("/menu");
    }
    
    
}
