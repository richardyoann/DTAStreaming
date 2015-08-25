/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.Film;
import dtastreaming.entity.Genre;
import dtastreaming.entity.Pays;
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
@WebServlet( urlPatterns = {"/film_update"})
public class ModifierFilmServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Film film = new Film();
        Pays pays = new Pays();      
        pays.setId(req.getParameter("pays"));
        film.setId(Long.parseLong(req.getParameter("ID")));
        film.setAnnee(Integer.parseInt(req.getParameter("annee")));
        film.setDuree(Integer.parseInt(req.getParameter("duree")));
        film.setTitre(req.getParameter("titre"));
        film.setPays(pays);
        new FilmService().modifier(film);
        resp.sendRedirect("film_lister");
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer la liste des films de la base en appelant le service FilmService
        
        Film film =  new FilmService().rechercher(Long.decode( req.getParameter("id")));
        // Renvoie vers JSP
        req.setAttribute("monFilm", film);
        
        Collection<Pays> pays =  new PaysService().lister();
        // Renvoie vers JSP
        req.setAttribute("mesPays", pays);
         Collection<Genre> genres =  new GenreService().lister();
        // Renvoie vers JSP
        req.setAttribute("mesGenres", genres);        
        req.getRequestDispatcher("admin_film_update.jsp").forward(req, resp);
        
    }
}
