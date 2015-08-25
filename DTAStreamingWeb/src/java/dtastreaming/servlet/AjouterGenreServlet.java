/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.Genre;
import dtastreaming.service.GenreService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ETY
 */
@WebServlet( urlPatterns = {"/genre_ajouter"})
public class AjouterGenreServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Genre g =new Genre();
        g.setIntitule(req.getParameter("intitule"));        
        //f.setAnnee(Integer.parseInt(req.getParameter("annee")));
        //f.setDuree(Integer.parseInt(req.getParameter("duree")));
        
        new GenreService().ajouter(g);
        resp.sendRedirect("genre_lister");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer la liste des films de la base en appelant le service FilmService
        //Collection<Film> films =  new FilmService().lister();
        // Renvoie vers JSP
       // req.setAttribute("mesFilms", films);
        req.getRequestDispatcher("admin_genre_ajouter.jsp").forward(req, resp);
        
    }
}
