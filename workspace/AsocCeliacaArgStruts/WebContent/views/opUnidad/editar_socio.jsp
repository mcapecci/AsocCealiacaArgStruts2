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
				<h3>Edici&oacute;n Socio de Unidad</h3>
				<fieldset align="right">
				<s:form action="socioNormal-modificado" theme="simple">
					<s:label value="Nombre y Apellido"/><s:textfield name="nomyap" value="%{selected.nomyap}"/>(*)<br><br>
					<s:label value="Email"/><s:textfield name="email" value="%{selected.email}"/>(*)<br><br>
					<s:label value="Teléfono"/><s:textfield name="telefono" value="%{selected.telefono}"/>(*)<br><br>
					<s:label value="Dirección"/><s:textfield name="direccion" value="%{selected.direccion}"/>(*)<br><br>
					<s:label value="Username"/><s:textfield name="username" value="%{selected.username}" readonly="true" cssClass="readonly"/><br><br>
					<s:label value="Perfil"/><select name="perfilSocio" id="%{selected.perfil}">
											    <option value="adminCentral">Administrador Central</option>
											    <option value="adminUnidad">Administrador Unidad</option>
											    <option value="opCentral">Operador Central</option>
											    <option value="opUnidad">Operador Unidad</option>
											    <option value="socioNormal">Socio</option>
											    <option value="socioVirtual">Socio Virtual</option>
											</select>(*)<br><br>
					<s:hidden name="idSelected" value="%{selected.id}"/>
					<s:submit value="Guardar cambios" cssClass="button"/>
					<s:submit value="Cancelar" action="ver_sociosNormal" cssClass="button" />
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