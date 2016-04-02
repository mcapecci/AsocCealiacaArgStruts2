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
				<h3>Registrar Operador de la Central</h3>
				<fieldset align="right">
				<s:form action="opcentral-registrado" theme="simple">
					<s:label value="Perfil"/><s:textfield name="perfil" value="Operador Central" readonly="true" cssClass="readonly"/><br><br>
					<s:label value="Central"/><s:textfield name="central" value="%{entidad.nombre}" readonly="true" cssClass="readonly"/><br><br>
					<s:label value="Nombre y Apellido"/><s:textfield name="nomyap" required="true"/>(*)<br><br>
					<s:label value="Email"/><s:textfield name="email" required="true"/>(*)<br><br>
					<s:label value="Teléfono"/><s:textfield name="telefono" required="true"/>(*)<br><br>
					<s:label value="Dirección"/><s:textfield name="direccion" required="true"/>(*)<br><br>
					<s:label value="Username"/><s:textfield name="username" required="true"/>(*)<br><br>
					<s:label value="Contraseña"/><s:password name="password" required="true"/>(*)<br><br>
					<s:submit value="Registrar" cssClass="button"/>
					<s:submit action="index" value="Cancelar" cssClass="button"/>
				</s:form>
				<br>
				(*): Campo Obligatorio
				</fieldset>
			</div> <!-- end main -->
		</div><!-- end content -->
		<jsp:include page="/views/templates/footer.jsp" />
	</div><!-- end page -->
</body>
</html>