<%@page import="builder.model.Book"%>
<%@page import="builder.service.BookLocalServiceUtil"%>
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
	<aui:model-context bean="${bookEntry}" model="<%=Book.class%>" />
	<aui:input name="bookName" label="book-Name" disabled="true"/>
	<aui:input type="textarea" name="bookDescription" label="Description" disabled="true"/>	
	<aui:input name="authorName" label="Author Name" disabled="true"/>	
</aui:form>
