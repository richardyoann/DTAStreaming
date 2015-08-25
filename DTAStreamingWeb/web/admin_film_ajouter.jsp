<%-- 
    Document   : admin_film_ajouter
    Created on : 19 août 2015, 16:53:18
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
                    <fieldset style="width: 400px;">
                        <legend>Film</legend>                   
                            <label style="width: 100px;">Titre :</label><input name="titre" style="width: 300px;">
                            <br>                        
                             <label style="width: 100px;">Année :</label><input name="annee" style="width: 300px;">
                            <br>  
                             <label style="width: 100px;">Durée :</label><input name="duree" style="width: 300px;">
                            <br>  
                            <label style="width: 100px;">Pays :</label><select name="pays">
                                        <c:forEach items="${requestScope.mesPays}" var="mesPays">
                                            <option value=${mesPays.id}>${mesPays.id}</option>                    
                                        </c:forEach>                        
                                   </select> 
                            <br>
                            Genres : <select name="genres">
                                            <c:forEach items="${requestScope.mesGenres}" var="mesGenres">
                                                <option value=${mesGenres.id}>${mesGenres.intitule}</option>                    
                                            </c:forEach>                        
                                       </select> 
                            <br>
                    </fieldset >
                    <fieldset style="width: 400px;">
                        <legend>Réalisateur</legend>
                        <select multiple="multiple"  name="realisateur" title="realisateur" data-num-options="5" class="required">
                            <c:forEach items="${requestScope.mesCastings}" var="mesCastings">
                                <option value=${mesCastings.id}>${mesCastings.nom}</option>                    
                            </c:forEach> 
                        </select>
                    </fieldset>
                    <fieldset style="width: 400px;">
                        <legend>Acteur</legend>
                        <select multiple="multiple"  name="acteur" title="acteur" data-num-options="5" class="required">
                            <c:forEach items="${requestScope.mesCastings}" var="mesCastings">
                                <option value=${mesCastings.id}>${mesCastings.nom}</option>                    
                            </c:forEach> 
                        </select>
                    </fieldset>
                    
                    <br>
                    <input type="submit">                    
                </form>                    
            </div>
        <div class="pied"><c:import url="_PIED.jsp"/></div>
        
    </body>
</html>

      
                   
