<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL windowState="normal" var="backURL">
	<portlet:param name="mvcPath" value="/html/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:header backURL="${backURL}" title="Back"/>

<portlet:actionURL  var="addBookActionURL" name="addBook"> </portlet:actionURL>

<aui:form action="${addBookActionURL}" method="post" name="fm">

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