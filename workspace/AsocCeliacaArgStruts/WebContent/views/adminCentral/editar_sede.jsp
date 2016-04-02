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
				<h3>Edici&oacute;n Sede</h3>
				<fieldset align="right">
				<s:form action="sede-modificar" theme="simple">
					<s:label value="Nombre"/><s:textfield name="nombre" value="%{selected.nombre}"/>(*)<br><br>
					<s:label value="Teléfono"/><s:textfield name="telefono" value="%{selected.telefono}"/>(*)<br><br>
					<s:label value="Valor Cuota"/><s:textfield name="valorCuota" value="%{selected.valorCuota}"/>(*)<br><br>
					<s:label value="Dirección"/><s:textfield name="direccion" value="%{selected.direccion}"/>(*)<br><br>
					<s:label value="Localidad"/><s:textfield name="localidad" value="%{selected.localidad}"/>(*)<br><br>
					<s:label value="Provincia"/><s:textfield name="provincia" value="%{selected.provincia}"/>(*)<br><br>
					<s:hidden name="idSelected" value="%{selected.id}"/>
					<s:submit value="Guardar cambios" cssClass="button"/>
					<s:submit value="Cancelar" action="cancelar-sede-editar" cssClass="button" />
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