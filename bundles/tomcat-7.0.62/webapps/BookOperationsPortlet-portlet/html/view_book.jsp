<%@page import="com.softwerke.BookModel"%>
<%@page import="com.softwerke.services.model.Book"%>
<%@page import="com.softwerke.services.service.BookLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL var="backURL">
	<portlet:param name="jspPage" value="/html/view.jsp"/>
</portlet:renderURL>

<liferay-ui:header backURL="${backURL}" title="Back" />

<aui:form>
	<aui:model-context bean="${bookEntry}" model="<%=BookModel.class%>" />
	<aui:input type="textarea" name="bookName" label="Book Name" disabled="true"/>
	<aui:input type="textarea" name="bookDescription" label="Description" disabled="true"/>	
	<aui:input type="textarea" name="authorName" value="${authorName}" label="Author Name" disabled="true"/>	
</aui:form>
