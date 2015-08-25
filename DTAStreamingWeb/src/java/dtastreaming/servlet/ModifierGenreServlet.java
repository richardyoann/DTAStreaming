/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.Genre;
import dtastreaming.entity.Pays;
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
@WebServlet( urlPatterns = {"/genre_update"})
public class ModifierGenreServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Genre genre = new Genre();      
        genre.setId(Long.parseLong(req.getParameter("ID")));
        genre.setIntitule(req.getParameter("intitule"));
        new GenreService().modifier(genre);
        resp.sendRedirect("genre_lister");
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer la liste des films de la base en appelant le service FilmService
        Collection<Pays> pays =  new PaysService().lister();
        // Renvoie vers JSP
        req.setAttribute("mesPays", pays);
         Collection<Genre> genres =  new GenreService().lister();
        // Renvoie vers JSP
        req.setAttribute("mesGenres", genres);        
        req.getRequestDispatcher("admin_film_update.jsp").forward(req, resp);
        
    }
}
