<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="/WEB-INF/Modules/tableau.jsp">
    <jsp:param name="module" value="COMPTES" />
</jsp:include>
<jsp:include page="/WEB-INF/Modules/tableau.jsp">
    <jsp:param name="module" value="LIBRAIRES" />
</jsp:include>