<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:forEach var="categorie" items="${categories}">
    <tr class="border-b border-neutral-500 bg-gray-800 border-gray-200 hover:bg-gray-900">
        <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                ${categorie.id}
        </th>
        <td class="px-6 py-4">
                ${categorie.toString()}
        </td>
        <td class="px-6 py-4">
                ${categorie.toString()}
        </td>
        <c:if test="${edit}">
            <td class="px-6 py-4 flex justify-center gap-3">
                <a href="#" class="font-normal text-sky-500 tracking-wide hover:underline underline-offset-2">Edition</a>
                <a href="#" class="font-normal text-rose-400 tracking-wide hover:underline underline-offset-2">Supprimer</a>
            </td>
        </c:if>
    </tr>
</c:forEach>