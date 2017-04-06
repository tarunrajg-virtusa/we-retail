<%@include file="/apps/foosball/champs/global.jsp"%>
<%@page pageEncoding="UTF-8" %>
<%@page import="com.day.cq.wcm.api.WCMMode,
                java.util.HashMap,
                org.apache.sling.commons.json.JSONArray,
                org.apache.sling.commons.json.JSONObject"%>

<form id="updateForm" name="updateForm" accept-charset="UTF-8" autocomplete="off"
    enctype="multipart/form-data" method="post" novalidate
    action="<%=currentNode.getPath()%>.UpdateResult.html">
    <h2>Destination Data Form</h2><br>
    <h5>Destination data*</h5>
	<div>
	    <textarea id="destinations" name="destinations" style="width:70%;" rows="10" wrap="off"></textarea>
	</div>
	<p>Line-delimited text in the form of destination=data</p>
    <input id="submitButton" name="submitButton" type="submit" value="Update Destination Data"/>
</form>
<br><hr><br>
