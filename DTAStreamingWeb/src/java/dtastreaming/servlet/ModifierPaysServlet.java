/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;
import dtastreaming.entity.Pays;
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
@WebServlet( urlPatterns = {"/pays_update"})
public class ModifierPaysServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pays pays = new Pays();      
        pays.setId(req.getParameter("pays"));
        
        new PaysService().modifier(pays);
        resp.sendRedirect("pays_lister");
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer la liste des films de la base en appelant le service FilmService
        Collection<Pays> pays =  new PaysService().lister();
        // Renvoie vers JSP
        req.setAttribute("mesPays", pays);              
        req.getRequestDispatcher("admin_pays_update.jsp").forward(req, resp);
        
    }
}
