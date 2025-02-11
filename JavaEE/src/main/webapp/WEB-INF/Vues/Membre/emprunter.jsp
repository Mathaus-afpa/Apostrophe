<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<div>
    <h1>Emprunter un Livre</h1>
    <c:if test="${not empty livre}">
        <h3>Livre: ${livre.titre}</h3>
        <p><strong>Auteur:</strong> ${livre.auteur}</p>
        <p><strong>Résumé:</strong> ${livre.resume}</p>
        <p><strong>Disponibilité:</strong> ${livre.quantite > 0 ? 'Disponible' : 'Non disponible'}</p>
        <c:if test="${livre.quantite > 0}">
            <form action="ConfirmerEmprunt" method="post">
                <input type="hidden" name="livreId" value="${livre.id}">
                <button type="submit">Emprunter ce livre</button>
            </form>
        </c:if>
    </c:if>
</div>