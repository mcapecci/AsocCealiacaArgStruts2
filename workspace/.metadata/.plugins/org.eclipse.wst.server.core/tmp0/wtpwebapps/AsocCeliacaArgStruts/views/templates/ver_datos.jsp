<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="main">
	<h3>Datos Personales</h3>
	<fieldset style="padding-top: 10%; padding-left: 25%;">	
		<s:label value="Nombre y Apellido" />${user.nomyap}<br><br>
		<s:label value="Email"/>${user.email}<br><br>
		<s:label value="Teléfono"/>${user.telefono}<br><br>
		<s:label value="Dirección"/>${user.direccion}<br><br>
		<s:label value="Nombre Usuario"/>${user.username}<br><br>
	</fieldset>
	<br><br>
	<s:form theme="simple">
		<s:submit action="editar_datos" value="Actualizar Datos" cssClass="button"/>
	</s:form>
</div>
		