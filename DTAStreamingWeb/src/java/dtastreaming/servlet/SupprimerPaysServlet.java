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
@WebServlet( urlPatterns = {"/pays_supprimer"})
public class SupprimerPaysServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new PaysService().supprimer(req.getParameter("pays"));
        resp.sendRedirect("pays_lister");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new PaysService().supprimer(req.getParameter("pays"));
        req.getRequestDispatcher("admin_pays_lister.jsp").forward(req, resp);       
    }
}
