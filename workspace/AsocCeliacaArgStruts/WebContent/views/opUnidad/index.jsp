<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/views/templates/head.jsp" />
</head>
<body>
<div id="page">
	<jsp:include page="/views/templates/header.jsp" />
	<div id="content">
		<jsp:include page="/views/templates/perfil.jsp" />
		<jsp:include page="/views/menu/opUnidad.jsp" />
		<div id="main">
			<jsp:include page="/views/templates/intro.jsp" />
		</div><!-- end main -->
	</div><!-- end content -->
	<jsp:include page="/views/templates/footer.jsp" />
</div><!-- end page -->
</body>
</html>