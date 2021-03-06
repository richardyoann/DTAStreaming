/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ETY
 */
@WebServlet( urlPatterns = {"/admin_login"})
public class GestionLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        if ("admin".equals(req.getParameter("login")) || "admin".equals(req.getParameter("mdp")))
        {
             Cookie action = new Cookie("statut","admin");
             resp.addCookie(action);
             resp.sendRedirect("film_lister");
        }   
        else
        {
            Cookie action = new Cookie("statut","user");
            resp.addCookie(action);
            resp.sendRedirect("user_film_lister");             
        }       
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {         
        req.getRequestDispatcher("admin_login.jsp").forward(req, resp); 
        if (req.getAttribute("action").equals("Deconnexion")){
            Cookie[] cookies = req.getCookies();
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("statut"))
                {
                    cooky.setMaxAge(0);
                }
            }
            req.getRequestDispatcher("admin_login.jsp").forward(req, resp); 
        }        
        else if (req.getAttribute("action").equals("Connexion")){
            req.getRequestDispatcher("admin_login.jsp").forward(req, resp); 
        }
           
       
    }
}
