/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.Casting;
import dtastreaming.entity.Film;
import dtastreaming.entity.Film_Casting;
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
@WebServlet( urlPatterns = {"/film_lister"})
public class ListerFilmsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer la liste des films de la base en appelant le service FilmService
        Collection<Film> films =  new FilmService().lister();
        // Renvoie vers JSP
        req.setAttribute("mesFilms", films);
         // Récupérer la liste des films de la base en appelant le service FilmService
        Collection<Pays> pays =  new PaysService().lister();
        // Renvoie vers JSP
        req.setAttribute("mesPays", pays); 
        Collection<Genre> genres =  new GenreService().lister();
        // Renvoie vers JSP
        req.setAttribute("mesGenres", genres);                
        Collection<Casting> castings =  new CastingService().lister();
        // Renvoie vers JSP
        req.setAttribute("mesCastings", castings);   
        req.getRequestDispatcher("admin_film_lister.jsp").forward(req, resp);        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // instance de l'objet film
        Film f =new Film();
        // initialisation des setteur
        f.setTitre(req.getParameter("titre"));
        //// instance de l'objet pays
        Pays p = new Pays();
        p.setId(req.getParameter("pays"));
        f.setPays(p); 
        f.setAnnee(Integer.parseInt(req.getParameter("annee")));
        f.setDuree(Integer.parseInt(req.getParameter("duree"))); 
        Genre g = new Genre();
        g.setId(Long.parseLong(req.getParameter("genres")));               
        f.getGenres().add(g);
        // Associe les realisateurs
        for( String realString : req.getParameterValues("realisateur") ){
            
            Film_Casting fc = new Film_Casting();
            fc.setFilm(f);
            f.getFilmcasting().add(fc);
            
            Casting c = new Casting();
            c.setId( new Long(realString) );
            fc.setCasting(c);
            c.getFilm_Castings().add(fc);
        }
        // Associe les acteurs
        for( String actString : req.getParameterValues("acteur") ){
            
            Film_Casting fc = new Film_Casting();
            fc.setFilm(f);
            f.getFilmcasting().add(fc);
            
            Casting c = new Casting();
            c.setId( new Long(actString) );
            fc.setCasting(c);
            c.getFilm_Castings().add(fc);
        }      
        new FilmService().ajouter(f);
        resp.sendRedirect("film_lister");
    }


    
}
