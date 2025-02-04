<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1 class="text text-7xl mt-3">Bienvenue !</h1>

<div class="mt-16 flex items-center border w-80 focus-within:border-neutral-500 transition duration-300 pr-3 gap-2 bg-white border-gray-500/30 h-[46px] rounded-[5px] overflow-hidden">
    <input type="text" placeholder="Rechercher un livre" class="w-full h-full pl-4 outline-none placeholder-gray-500 text-sm"/>
    <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 30 30" fill="#6B7280">
        <path d="M 13 3 C 7.4889971 3 3 7.4889971 3 13 C 3 18.511003 7.4889971 23 13 23 C 15.396508 23 17.597385 22.148986 19.322266 20.736328 L 25.292969 26.707031 A 1.0001 1.0001 0 1 0 26.707031 25.292969 L 20.736328 19.322266 C 22.148986 17.597385 23 15.396508 23 13 C 23 7.4889971 18.511003 3 13 3 z M 13 5 C 17.430123 5 21 8.5698774 21 13 C 21 17.430123 17.430123 21 13 21 C 8.5698774 21 5 17.430123 5 13 C 5 8.5698774 8.5698774 5 13 5 z"></path>
    </svg>
</div>

<h2 class="space-y-96 text-5xl mt-20">Essayez :</h2>

<div class="card-container flex justify-center mt-8 gap-20">
    <c:forEach var="livre" items="${livres}">
        <c:if test="${not empty livre}">
            <jsp:include page="/WEB-INF/Modules/carte.jsp">
                <jsp:param name="livreId" value="${livre.getId()}" />
                <jsp:param name="livreNom" value="${livre.getTitre()}" />
                <jsp:param name="livreIsbn" value="${livre.getIsbn()}" />
                <jsp:param name="livreImage" value="${livre.getImage()}" />
                <jsp:param name="livreAuteur" value="${livre.getAuteur()}" />
                <jsp:param name="livreCategorie" value="${livre.getCategorie()}" />
            </jsp:include>
        </c:if>
    </c:forEach>
</div>