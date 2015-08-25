<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul class="nav nav-tabs nav-justified">
<c:if test ="${cookie.statut.value != null}"> 
    <c:if test="${cookie.statut.value.equals('admin')}">       
        <li role="menu_admin"><a href="film_lister">Films</a></li>
        <li role="menu_admin"><a href="pays_lister">Pays</a></li>           
        <li role="menu_admin"><a href="genre_lister">Genres</a></li>
        <li role="menu_admin"><a href="casting_lister">Casting</a></li>  
    </c:if> 
    <c:if test="${cookie.statut.value.equals( 'user')}">        
        <li role="menu_user"><a href="film_lister">Films</a></li>
        <li role="menu_user"><a href="pays_lister">Pays</a></li>           
        <li role="menu_user"><a href="genre_lister">Genres</a></li>
        <li role="menu_user"><a href="casting_lister">Casting</a></li> 
    </c:if>        
</c:if>
    <li role="menu_general"><a href="admin_login?action=Connexion">Connexion</a></li>
    <li role="menu_general"><a href="admin_login?action=Deconnexion">Deconnexion</a></li>
</ul>


