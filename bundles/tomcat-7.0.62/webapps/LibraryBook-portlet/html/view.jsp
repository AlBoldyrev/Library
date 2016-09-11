<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="com.softwerke.BookAndAuthor"%>
<%@page import="builder.service.BookLocalServiceUtil"%>
<%@page import="builder.service.AuthorLocalServiceUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="builder.model.Book"%>
<%@page import="builder.model.Author"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />


<portlet:renderURL var="addBookVar">
	<portlet:param name="pageName" value="<%=BookAndAuthor.ADD_BOOK %>"/>
</portlet:renderURL>

<portlet:renderURL var="addAuthorVar">
	<portlet:param name="pageName" value="<%=BookAndAuthor.ADD_AUTHOR %>"/>
</portlet:renderURL>

<a href="${addBookVar}"><h4><liferay-ui:message key="add-book"/></h4></a><br/>

<a href="${addAuthorVar}"><h4><liferay-ui:message key="add-author"/></h4></a>

<c:set var="book" value="${aBook}" scope="request" />
<c:set var="author" value="${aAuthor}" scope="request" />


<liferay-ui:success key="author-added-success" message="author-has-been-added-successfully" />
<liferay-ui:error key="author-added-failed" message="fail-to-add-Author" />
<liferay-ui:success key="book-added-success" message="book-has-been-added-successfully" />
<liferay-ui:error key="book-added-failed" message="fail-to-add-Book" />


<%-- http://stackoverflow.com/questions/26125014/how-to-solve-warning-when-using-liferay-uisearch-container-in-jsp --%> 
<liferay-ui:search-container>
	<liferay-ui:search-container-results results="${bookListArray}" />
	
	<liferay-ui:search-container-row className="builder.model.Book" modelVar="aBook">
		<liferay-ui:search-container-column-text property="bookName" name="book-Name" />
		<liferay-ui:search-container-column-text property="bookDescription" name="description"/>
		<liferay-ui:search-container-column-text property="authorName" name="Author"/>
		<liferay-ui:search-container-column-jsp path="/html/actionBook.jsp" align="right" />
	</liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>

<liferay-ui:search-container>
	<liferay-ui:search-container-results results="${authorListArray}" />
	<liferay-ui:search-container-row className="builder.model.Author" modelVar="aAuthor">
		<liferay-ui:search-container-column-text property="authorName" name="author-Name"/>
		<liferay-ui:search-container-column-text property="numberOfBooks" name="count"/>
		<liferay-ui:search-container-column-jsp path="/html/actionAuthor.jsp" align="right" />
	</liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>
