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
        <div class="contenu jumbotron"> 
            <div class="container text-center"> 
                <h1>Bienvenue!</h1>
                <p>Voici mon site de streaming</p>
                <div class="page-header">
                    <h2>Liste des pays</h2>
                </div>
                <br>
                <div class="table-responsive">  
                    <table class="table table-striped  "> 
                        <tr>                     
                            <th>Pays</th>
                            <th>Action</th>
                        </tr>                            
                        <c:forEach items="${requestScope.mesPays}" var="mesPays">
                            <form method="POST">                             
                                <tr>
                                    <td><input name="pays"  value="${mesPays.id}"</td>
                                    <td><a href="pays_supprimer?pays=${mesPays.id}"> SUPP </a> <input type="submit" name="modifier" value="MODI"></td>
                                </tr>
                            </form>
                        </c:forEach>                                
                        <form method="POST">                    
                            <tr>
                                <td><input name="pays"/></td>      
                                <td><input type="submit" value="ADD"></td>
                            </tr> 
                        </form>
                    </table>
                </div>
            </div>
        </div>
        <div class="pied"><c:import url="_PIED.jsp"/></div>        
    </body>
</html>

      
                   

