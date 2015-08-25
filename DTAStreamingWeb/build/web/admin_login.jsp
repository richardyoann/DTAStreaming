<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <c:import url="_STYLESHEETS.jsp"/>      
    <body>
        <div class='menu'>
            <c:import url="_MENU.jsp"/>
        </div>
        <div class="contenu jumbotron">        
            <div class="container text-center"> 
                <h1>Bienvenue!</h1>
                <p>Voici mon site de streaming</p>
            </div>
            <div class="container text-center"> 
                <c:if test="${cookie.statut.value == null}">
                    <form method="POST">  
                        <fieldset style="width: 400px;">                     
                            <label for="login">Login</label>
                            <input type="text"  name="login">
                            <br>
                            <label for="mdp">Password:</label>
                            <input type="password"  name="mdp">  
                            <br>
                            <input type="submit" value="Connexion">    
                        </fieldset>
                    </form>               
                </c:if>
            </div>
        </div>      
        <div class="pied"><c:import url="_PIED.jsp"/></div>
        
    </body>
</html>

      
                   
