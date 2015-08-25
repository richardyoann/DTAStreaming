<%-- 
    Document   : _CONTENU
    Created on : 24 août 2015, 11:45:30
    Author     : ETY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="contenu jumbotron"> 
    <div class="container text-center"> 
        <h1>Bienvenue!</h1>
        <p>Voici mon site de streaming</p>
        <c:if test="${cookie.statut.value == null}">
            <div class="alert alert-warning" role="alert">Merci de vous connecter</div>         
        </c:if>       
    </div>
</div>