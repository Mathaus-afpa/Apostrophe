<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="apostrophe.java.javaee.SVG" %>  <!-- Importer la classe utilitaire -->
<div class="sidebar flex-col fixed top-0 bottom-0 left-0 mr-3 mt-3 mb-3 p-2 w-64 overflow-y-auto bg-slate-50 rounded-r-xl shadow-lg shadow-gray-500">
    <!-- Infos -->
    <%@ include file="/WEB-INF/Modules/logo.jsp" %>
    <!-- /Accueil -->
    <jsp:include page="/WEB-INF/Modules/menu-item.jsp">
        <jsp:param name="href" value="/Accueil" />
        <jsp:param name="svg" value="${SVG.ACCUEIL}" />
        <jsp:param name="texte" value="Accueil" />
    </jsp:include>
    <!-- /Livres -->
    <jsp:include page="/WEB-INF/Modules/menu-item.jsp">
        <jsp:param name="href" value="/Livres" />
        <jsp:param name="svg" value="${SVG.LIVRES}" />
        <jsp:param name="texte" value="Livres" />
    </jsp:include>
    <!-- /Connexion -->
    <c:choose>
        <c:when test="${not empty requestScope.utilisateur}">
            <jsp:include page="/WEB-INF/Modules/menu-item.jsp">
                <jsp:param name="href" value="/Deconnexion" />
                <jsp:param name="svg" value="${SVG.ACCUEIL}" />
                <jsp:param name="texte" value="Deconnexion" />
                <jsp:param name="couleur" value="rouge" />
            </jsp:include>
        </c:when>
        <c:otherwise>
            <jsp:include page="/WEB-INF/Modules/menu-item.jsp">
                <jsp:param name="href" value="/Connexion" />
                <jsp:param name="svg" value="${SVG.CONNEXION}" />
                <jsp:param name="texte" value="Connexion" />
            </jsp:include>
        </c:otherwise>
    </c:choose>
    <!-- /CGU -->
    <jsp:include page="/WEB-INF/Modules/menu-item.jsp">
        <jsp:param name="href" value="/CGU" />
        <jsp:param name="svg" value="${SVG.CGU}" />
        <jsp:param name="texte" value="CGU" />
    </jsp:include>

    <c:choose>
        <c:when test="${requestScope.role == 'administrateur'}">
            <h3 class="text-center"></h3>
            <h3 class="text-center">-------------------</h3>
            <h3 class="text-center">${requestScope.role.toUpperCase()}</h3>
            <jsp:include page="/WEB-INF/Modules/menu-item.jsp">
                <jsp:param name="href" value="/Administrateur" />
                <jsp:param name="svg" value="${SVG.CONNEXION}" />
                <jsp:param name="texte" value="Gestion" />
            </jsp:include>
        </c:when>
        <c:when test="${requestScope.role == 'libraire'}">
            <h3 class="text-center"></h3>
            <h3 class="text-center">-------------------</h3>
            <h3 class="text-center">${requestScope.role.toUpperCase()}</h3>
            <jsp:include page="/WEB-INF/Modules/menu-item.jsp">
                <jsp:param name="href" value="/Libraire" />
                <jsp:param name="svg" value="${SVG.CONNEXION}" />
                <jsp:param name="texte" value="Gestion" />
            </jsp:include>
        </c:when>
        <c:when test="${requestScope.role == 'client'}">
            <h3 class="text-center"></h3>
            <h3 class="text-center">-------------------</h3>
            <h3 class="text-center">${requestScope.role.toUpperCase()}</h3>
            <jsp:include page="/WEB-INF/Modules/menu-item.jsp">
                <jsp:param name="href" value="/Client" />
                <jsp:param name="svg" value="${SVG.CONNEXION}" />
                <jsp:param name="texte" value="Emprunts" />
            </jsp:include>
        </c:when>
    </c:choose>
</div>