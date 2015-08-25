/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.Casting;
import dtastreaming.service.CastingService;
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
@WebServlet( urlPatterns = {"/casting_lister"})
public class ListerCastingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer la liste des films de la base en appelant le service FilmService
        Collection<Casting> castings =  new CastingService().lister();
        // Renvoie vers JSP
        req.setAttribute("mesCasting", castings);
        req.getRequestDispatcher("admin_casting_lister.jsp").forward(req, resp);
        
    }

    
}
