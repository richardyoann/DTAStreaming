<%-- 
    Document   : TEMPLATE
    Created on : 19 août 2015, 15:49:01
    Author     : ETY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="_STYLESHEETS.jsp"/>
        <c:import url="_JAVASCRIPT.jsp"/>
        
    </head>
    <body>
        <div class='menu'><c:import url="_MENU.jsp"/></div>
            <div class="contenu">
                <form method="POST">                     
                    Modifier un film
                    <br>
                   
                        <input type="hidden" name="ID" value=${monFilm.id} />
                        <br>
                        Titre : <input name="titre" value=${monFilm.titre}>
                        <br>                        
                        Année : <input name="annee" value=${monFilm.annee}>
                        <br>  
                        Durée : <input name="duree" value=${monFilm.duree}>
                        <br>  
                        Pays : <select name="pays" >
                                <c:forEach items="${requestScope.mesPays}" var="mesPays"> 
                                        <option value=${mesPays.id} >${mesPays.id}</option>  
                                </c:forEach>                        
                               </select> 
                        <br>
                        Genres : <select name="genres">
                                    <c:forEach items="${requestScope.mesGenres}" var="mesGenres">
                                        <option value=${mesGenres.id}>${mesGenres.intitule}</option>                    
                                    </c:forEach>                        
                               </select> 
                        <br>
                        <br>
                   
                <input type="submit"> 
                </form>
            </div>
        <div class="pied"><c:import url="_PIED.jsp"/></div>
        
    </body>
</html>

      
                   
