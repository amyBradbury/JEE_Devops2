/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.User;

/**
 *
 * @author Alec-PC
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/menu.htm"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        boolean loggedIn = req.getUserPrincipal() != null && req.isUserInRole("user");
        if (loggedIn) {
            if (session.getAttribute("login") == null) {
                User user = new User(req.getUserPrincipal().getName());
                session.setAttribute("login", user.getLogin());
            }
            req.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(req, resp);
        }
        return;

    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//    }
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//    }
}
