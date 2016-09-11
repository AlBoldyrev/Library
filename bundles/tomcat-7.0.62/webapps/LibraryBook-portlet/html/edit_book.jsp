<%@page import="builder.model.Book"%>
<%@page import="builder.service.BookLocalServiceUtil"%>
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


<aui:form name="fm" action="${updateBookVar}" method="post">

	<aui:input name="bookName" label="book-Name"/>
	<aui:input type="textarea" name="bookDescription" label="description"/>
	<aui:select name="author" label="author-Name">
		<c:forEach var="currAuthor" items="${authorListArray}">
			<aui:option value="${currAuthor.authorId}" label=" ${currAuthor.authorName}"></aui:option>
		</c:forEach>
	</aui:select>

	<aui:button-row>
        <aui:button name="updateBook" type="submit" value="Update Book"  />
    </aui:button-row>
		
</aui:form>