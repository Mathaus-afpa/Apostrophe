<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="width: 100%; position: sticky;">
    <h1>${param.module}</h1>
</div>
<div class="w-[66rem] max-h-64 m-3 relative overflow-auto shadow-md rounded-xl overflow-y-scroll">
    <table class="w-full text-sm text-left rtl:text-right text-gray-400">
        <colgroup>
            <col class="w-1/25">
            <col class="w-2/4">
            <col class="w-1/4">
            <c:if test="${edit}">
                <col class="w-1/4">
            </c:if>
        </colgroup>
        <thead class="text-xs uppercase bg-gray-900 text-gray-400">
        <tr>
            <th scope="col" class="px-6 py-3 text-green-500 tracking-[.25em]">
                ID
            </th>
            <c:choose>
                <c:when test="${param.info}">
                    <th scope="col" class="px-6 py-3 text-green-500 tracking-[.25em]">
                        VALEUR
                    </th>
                    <th scope="col" class="px-6 py-3 text-green-500 tracking-[.25em]">
                        INFO
                    </th>
                </c:when>
                <c:otherwise>
                    <th scope="col" class="px-6 py-3 text-center text-green-500 tracking-[.25em]" colspan="2">
                        VALEUR
                    </th>
                </c:otherwise>
            </c:choose>
            <c:if test="${edit}">
                <th scope="col" class="px-6 py-3 text-center text-green-500 tracking-[.25em]">
                    GESTION
                </th>
            </c:if>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${param.module == 'COMPTES'}">
                <jsp:include page="/WEB-INF/Vues/Gestion/Comptes/comptes.jsp"></jsp:include>
            </c:when>
            <c:when test="${param.module == 'LIBRAIRES'}">
                <jsp:include page="/WEB-INF/Vues/Gestion/Libraires/libraires.jsp"></jsp:include>
            </c:when>
            <c:when test="${param.module == 'AUTEURS'}">
                <jsp:include page="/WEB-INF/Vues/Gestion/Auteurs/auteurs.jsp"></jsp:include>
            </c:when>
            <c:when test="${param.module == 'CATEGORIES'}">
                <jsp:include page="/WEB-INF/Vues/Gestion/Categories/categories.jsp"></jsp:include>
            </c:when>
            <c:when test="${param.module == 'LIVRES'}">
                <jsp:include page="/WEB-INF/Vues/Visiteur/Livres/livres.jsp"></jsp:include>
            </c:when>
            <c:when test="${param.module == 'CLIENTS'}">
                <jsp:include page="/WEB-INF/Vues/Gestion/Clients/clients.jsp"></jsp:include>
            </c:when>
            <c:otherwise>
                <p>Type inconnu, affichage par défaut</p>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</div>
