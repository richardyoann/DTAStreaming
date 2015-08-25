<%-- 
    Document   : TEMPLATE
    Created on : 19 août 2015, 15:49:01
    Author     : ETY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>   
 <c:import url="_STYLESHEETS.jsp"/>
    <body>
        <div class='menu'><c:import url="_MENU.jsp"/></div>
        <div class="contenu jumbotron"> 
            <div class="container text-center"> 
                <h1>Bienvenue!</h1>
                <p>Voici mon site de streaming</p>
                <c:if test="${cookie.statut.value == null}">
                    <div class="alert alert-warning" role="alert">Merci de vous connecter</div>         
                </c:if>
                <c:if test="${cookie.statut.value != null}">  
                    <div class="page-header">
                        <h2>Liste des films</h2>
                    </div>
                    <br>
                        <div class="table-responsive">  
                            <table class="table table-striped  "> 
                                <tr>                     
                                    <th>Titre</th>
                                    <th>Année</th>
                                    <th>Durée</th>
                                    <th>Pays</th>    
                                    <th>Genres</th>
                                    <th>Réalisateurs</th>
                                    <th>Acteurs</th>
                                    <th>Action</th>
                                </tr>
                                <c:forEach items="${requestScope.mesFilms}" var="monFilm">
                                    <tr>
                                        <td>${monFilm.titre}</td>
                                        <td>${monFilm.annee}</td>
                                        <td>${monFilm.duree}</td>
                                        <td>${monFilm.pays.id}</td>   
                                        <td>
                                            <c:forEach items="${monFilm.genres}" var="genre">
                                                ${genre.intitule}
                                            </c:forEach>
                                        </td>
                                        <td>
                                            <c:forEach items="${monFilm.filmcasting}" var="casting">
                                                ${casting.casting.nom}<br>

                                            </c:forEach>
                                        </td>
                                        <td></td>
                                        <td><a href="film_supprimer?id=${monFilm.id}" > SUP </a>
                                            <a href="film_update?id=${monFilm.id}" >MAJ</a>

                                        </td>
                                    </tr>
                                </c:forEach>
                                <form method="POST">
                                    <tr>
                                        <td><input name="titre"/></td>
                                        <td><input name="annee"/></td>
                                        <td><input name="duree"/></td>                            
                                        <td>
                                            <select name="pays">
                                                    <c:forEach items="${requestScope.mesPays}" var="mesPays">
                                                        <option value=${mesPays.id}>${mesPays.id}</option>                    
                                                    </c:forEach>                        
                                            </select>                             
                                        </td>
                                        <td>
                                            <select name="genres">
                                                <c:forEach items="${requestScope.mesGenres}" var="mesGenres">
                                                    <option value=${mesGenres.id}>${mesGenres.intitule}</option>                    
                                                </c:forEach>                        
                                           </select> 
                                        </td>
                                        <td>
                                             <select multiple="multiple"  name="realisateur" title="realisateur" data-num-options="5" class="required">
                                                <c:forEach items="${requestScope.mesCastings}" var="mesCastings">
                                                    <option value=${mesCastings.id}>${mesCastings.nom}</option>                    
                                                </c:forEach> 
                                            </select>
                                        </td>
                                        <td>
                                            <select multiple="multiple"  name="acteur" title="acteur" data-num-options="5" class="required">
                                                <c:forEach items="${requestScope.mesCastings}" var="mesCastings">
                                                    <option value=${mesCastings.id}>${mesCastings.nom}</option>                    
                                                </c:forEach> 
                                            </select>
                                        </td>
                                        <td><input type="submit" value="ADD">  </td>
                                    </tr> 
                                </form>
                            </table>  
                        </div>
                    </div>
                </c:if>       
            </div>
        </div>  
        <div class="pied"><c:import url="_PIED.jsp"/></div>       
    </body>
</html>






