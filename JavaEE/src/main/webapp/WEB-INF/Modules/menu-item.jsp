<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<a class="group" href="${param.href}">
    <div class="p-2 pl-20 flex justify-start items-center bg-slate-50 rounded gap-3 hover:bg-gray-700 ease-in-out duration-300">
        <c:out value="${param.svg}" escapeXml="false"/>
    <c:choose>
        <c:when test="${param.couleur == 'rouge'}">
            <span class="pt-1 text-red-700 font-medium group-hover:text-lime-300 group-hover:font-normal">${param.texte}</span>
        </c:when>
        <c:otherwise>
            <span class="pt-1 text-gray-700 font-medium group-hover:text-lime-300 group-hover:font-normal">${param.texte}</span>
        </c:otherwise>
    </c:choose>
    </div>
</a>