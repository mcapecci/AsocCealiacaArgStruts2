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
			<jsp:include page="/views/menu/adminCentral.jsp" />
			
			<div id="main">	
				<h3>Edici&oacute;n de producto</h3>
				<fieldset align="right">
				<s:form action="medicamento-modificado" theme="simple">
					<s:label value="Nombre"/><s:textfield name="selected.nombre" value="%{selected.nombre}"/>(*)<br><br>
					<s:label value="Descripción"/><s:textfield name="selected.descripcion" value="%{selected.descripcion}" />(*)<br><br>
					<s:label value="Precio"/><s:textfield name="selected.precio" value="%{selected.precio}"/>(*)<br><br>
					<s:hidden name="selected.id" value="%{selected.id}"/>
					<s:submit value="Guardar cambios" cssClass="button"/>
					<s:submit value="Cancelar" action="ver_medicamentos" cssClass="button" />
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