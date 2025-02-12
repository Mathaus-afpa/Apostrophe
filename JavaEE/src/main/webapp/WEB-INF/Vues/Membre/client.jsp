<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="table-auto border-collapse border border-black w-full">
    <thead>
    <tr>
        <th class="border border-black px-4 py-2">Confirmation</th>
        <th class="border border-black px-4 py-2">Date d'emprunt</th>
        <th class="border border-black px-4 py-2">Titre</th>
        <th class="border border-black px-4 py-2">Date de retour</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="i" begin="1" end="10">
        <tr>
            <td class="border border-black px-4 py-2 h-16 w-32">
<%--                <form method="post" action="/confirmation">--%>
<%--                    <button type="submit" class="bg-blue-500 text-white px-2 py-1 rounded">Confirmer</button>--%>
<%--                </form>--%>
            </td>
            <td class="border border-black px-4 py-2 h-16 w-32"></td> <!-- Exemple de date d'emprunt -->
            <td class="border border-black px-4 py-2 h-16 w-80"></td> <!-- Exemple de titre -->
            <td class="border border-black px-4 py-2 h-16 w-32">
<%--                <form method="post" action="/retour">--%>
<%--                    <button type="submit" class="bg-green-500 text-white px-2 py-1 rounded">Retourner</button>--%>
<%--                </form>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
