/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.Casting;
import dtastreaming.entity.Film;
import dtastreaming.entity.Genre;
import dtastreaming.entity.Pays;
import dtastreaming.service.CastingService;
import dtastreaming.service.FilmService;
import dtastreaming.service.GenreService;
import dtastreaming.service.PaysService;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ETY
 */
@WebServlet( urlPatterns = {"/casting_ajouter"})
public class AjouterCastingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // instance de l'objet film
        Casting c =new Casting();
        // initialisation des setteur
        c.setNom(req.getParameter("nom"));
        //// instance de l'objet pays        
        new CastingService().ajouter(c);
        resp.sendRedirect("casting_lister");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
        req.getRequestDispatcher("admin_casting_ajouter.jsp").forward(req, resp);
        
    }
}
