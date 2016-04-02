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
				<h3>Edición de Bar</h3>
				<fieldset align="right">
				<s:form action="bar-modificado" theme="simple">
					<s:label value="Nombre"/><s:textfield name="nombre" value="%{selected.nombre}"/>(*)<br><br>
					<s:label value="Descripción"/><s:textfield name="descripcion" value="%{selected.descripcion}"/>(*)<br><br>
					<s:label value="Dirección"/><s:textfield name="direccion" value="%{selected.direccion}"/>(*)<br><br>
					<s:hidden name="idSelected" value="%{selected.id}"/>
					<s:submit value="Guardar cambios" cssClass="button"/>
					<s:submit value="Cancelar" action="ver_bares" cssClass="button" />
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