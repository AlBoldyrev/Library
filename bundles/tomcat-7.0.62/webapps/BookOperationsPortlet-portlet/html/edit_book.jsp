<%@page import="com.softwerke.services.model.Book"%>
<%@page import="com.softwerke.services.service.BookLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL var="backURL">
	<portlet:param name="jspPage" value="/html/view.jsp"/>
</portlet:renderURL>

<liferay-ui:header backURL="${backURL}" title="back" />

<portlet:actionURL name="updateBook" var="updateBookVar" />

<aui:form action="${updateBookVar}" method="post" name="fm">

	<aui:input name="bookName" value="" label="Book-Name"/>
	<aui:input  name="bookDescription" value=""  label="Description"/>
		
		<aui:select name="author" label="Author-Name">
   		 	<c:forEach var="currAuthor" items="${authorModels}">
     			   <aui:option value="${currAuthor.authorId}" label=" ${currAuthor.authorName}"></aui:option>
    		</c:forEach>
		</aui:select>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>