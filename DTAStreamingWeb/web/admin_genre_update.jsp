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
                    Modifier un genre
                    <c:forEach items="${requestScope.mesGenres}" var="mesGenres">
                    <br>
                    ID : <input name="ID" value=${mesGenres.id}>
                    <br>
                    Intitule : <input name="intitule" value=${mesGenres.intitule}>
                    <br>    
                    <input type="submit">  
                    </c:forEach>
                </form>                    
            </div>
        <div class="pied"><c:import url="_PIED.jsp"/></div>
        
    </body>
</html>

      
                   
