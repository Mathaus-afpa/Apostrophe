<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="/WEB-INF/Modules/tableau.jsp">
    <jsp:param name="module" value="AUTEURS" />
</jsp:include>
<jsp:include page="/WEB-INF/Modules/tableau.jsp">
    <jsp:param name="module" value="CATEGORIES" />
</jsp:include>
<jsp:include page="/WEB-INF/Modules/tableau.jsp">
    <jsp:param name="module" value="LIVRES" />
</jsp:include>
<jsp:include page="/WEB-INF/Modules/tableau.jsp">
    <jsp:param name="module" value="CLIENTS" />
</jsp:include>