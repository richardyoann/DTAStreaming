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
                <c:forEach items="${requestScope.mesGenres}" var="mesGenres">
                    ${mesGenres.intitule}
                    <br>
                </c:forEach>
            </div>
        <div class="pied"><c:import url="_PIED.jsp"/></div>
        
    </body>
</html>

      
                   
