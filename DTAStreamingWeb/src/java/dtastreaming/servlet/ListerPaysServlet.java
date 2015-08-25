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
@WebServlet( urlPatterns = {"/pays_lister"})
public class ListerPaysServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        Pays p = new Pays();      
        p.setId(req.getParameter("pays"));        
        new PaysService().modifier(p);    
        // Récupérer la liste des films de la base en appelant le service FilmService
        Collection<Pays> pays =  new PaysService().lister();
        req.setAttribute("mesPays", pays);   
        // Renvoie vers JSP
        req.getRequestDispatcher("admin_pays_lister.jsp").forward(req, resp);       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pays p = new Pays();
        p.setId(req.getParameter("pays"));
        new PaysService().ajouter(p);
        if (!req.getParameter("modifier").isEmpty()){           
            new PaysService().modifier(p);
        }
        else 
            new PaysService().ajouter(p);
        resp.sendRedirect("pays_lister");       
    }
    
}
