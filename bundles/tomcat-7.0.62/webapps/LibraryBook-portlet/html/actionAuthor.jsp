<%@page import="com.softwerke.BookAndAuthor"%>
<%@page import="builder.model.Book"%>
<%@page import="builder.model.Author"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
	ResultRow row = (ResultRow) request.getAttribute(BookAndAuthor.SEARCH_CONTAINER_RESULT_ROW);

	Author author = (Author) row.getObject();
%>


<liferay-ui:icon-menu>
	
	<portlet:actionURL name="deleteAuthor" var="deleteAuthorVar">
		<portlet:param name="authorId"     value="<%=String.valueOf(author.getAuthorId())%>" />
	</portlet:actionURL>
	
	<liferay-ui:icon   image="delete"    message="delete" url="${deleteAuthorVar}" />

</liferay-ui:icon-menu>

