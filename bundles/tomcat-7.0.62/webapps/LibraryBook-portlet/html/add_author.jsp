<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.softwerke.BookAndAuthor"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL windowState="normal" var="backURL">
	<portlet:param name="pageName" value="something"/>
</portlet:renderURL>

<liferay-ui:header backURL="${backURL}" title="Back"/>

<portlet:actionURL  var="addAuthorActionURL" name="addAuthor" />

<aui:form action="${addAuthorActionURL}" method="post" name="fm">
	<aui:input name="authorName" value="" label="Author Name"/>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
