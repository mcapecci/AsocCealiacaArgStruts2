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
				<h3>Registrar Socio</h3>
				<fieldset align="right">
				<s:form action="socioNormal-registrado" theme="simple">
					<s:label value="Nombre y Apellido"/><s:textfield name="nomyap" required="true"/>(*)<br><br>
					<s:label value="DNI"/><s:textfield name="DNI" required="true"/>(*)<br><br>
					<s:label value="Ocupación"/><s:textfield name="ocupacion" required="true"/>(*)<br><br>
					<s:label value="Dirección"/><s:textfield name="direccion" required="true"/>(*)<br><br>
					<s:label value="Teléfono"/><s:textfield name="telefono" required="true"/>(*)<br><br>
					<s:label value="Fecha de Nacimiento"/><s:textfield name="fechaNacimiento" required="true"/>(*)<br><br>
					<s:label value="Fecha de Ingreso"/><s:textfield name="fechaIngreso" required="true"/>(*)<br><br>
					<s:label value="Fecha de Diagnóstico"/><s:textfield name="fechaDiagnostico" required="true"/>(*)<br><br>
					<s:label value="Presentado Por"/><s:textfield name="presentadoPor" required="true"/>(*)<br><br>
					<s:label value="Email"/><s:textfield name="email" required="true"/>(*)<br><br>
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