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
			<jsp:include page="/views/menu/adminUnidad.jsp" />
			
			<div id="main">	
				<h3>Cambiar Contrase&ntilde;a</h3>
				<fieldset align="right">
				<s:form action="adminunidad-cambiopass" theme="simple">
					<s:label value="Nueva Contraseña"/><s:password name="pass" value="%{user.pass}"/>(*)<br><br>
					<s:label value="Repita Contraseña"/><s:password name="newPass" value="%{user.newPass}"/>(*)<br><br>
					<s:hidden name="idSelected" value="%{user.id}"/>
					<s:submit value="Guardar cambios" cssClass="button"/>
					<s:submit value="Cancelar" action="index" cssClass="button" />
				</s:form>
				<br>
				(*): Campo Obligatorio
				</fieldset>
			</div>
		</div>
		<jsp:include page="/views/templates/footer.jsp" />
	</div>
</body>
</html>