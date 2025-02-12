<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="content flex-col justify-items-center pl-60">
    <c:if test="${not empty page}">
        <jsp:include page="${page}" />
    </c:if>
</div>