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

	Book book = (Book) row.getObject();
%>

<%-- <c:set var="row" value="${(ResultRow) request.getAttribute(BookAndAuthor.SEARCH_CONTAINER‌​_RESULT‌​_ROW)}"/> --%>
<%-- <c:set var="book" value="${(Book) row.getObject()}"/> --%>

<liferay-ui:icon-menu>
	
	     <portlet:actionURL name="deleteBook" var="deleteBookVar">
         <portlet:param name="bookId"     value="<%=String.valueOf(book.getBookId())%>" />
     </portlet:actionURL>
	
	<portlet:renderURL var="viewBookVar">
		<portlet:param name="pageName"   value="<%=BookAndAuthor.VIEW_BOOK %>" />
		<portlet:param name="bookId"     value="<%=String.valueOf(book.getBookId())%>" />
	</portlet:renderURL>
	
	<portlet:renderURL var="editBookVar">
		<portlet:param name="pageName"	 value="<%=BookAndAuthor.EDIT_BOOK %>" />
		<portlet:param name="bookId"     value="<%=String.valueOf(book.getBookId())%>" />
	</portlet:renderURL>
	
	<liferay-ui:icon   image="delete"    message="delete" url="${deleteBookVar}" />
	<liferay-ui:icon   image="add"       message="view" url="${viewBookVar}" />
	<liferay-ui:icon   image="add"       message="edit" url="${editBookVar}" />

</liferay-ui:icon-menu>
