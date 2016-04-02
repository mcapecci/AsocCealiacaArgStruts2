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
				<h3>Registrar Sede</h3>
				<fieldset align="right">
				<s:form action="sede-registrada" theme="simple">
					<s:label value="Nombre"/><s:textfield name="nombre" required="true"/>(*)<br><br>
					<s:label value="Tipo de Sede"/><s:select key="idTipo" list="allTypes" listKey="id" listValue="nombre"/>(*)<br><br>
					<s:label value="Teléfono"/><s:textfield name="telefono" required="true"/>(*)<br><br>
					<s:label value="Valor Cuota"/><s:textfield name="valorCuota" required="true"/>(*)<br><br>
					<s:label value="Dirección"/><s:textfield name="direccion" required="true"/>(*)<br><br>
					<s:label value="Localidad"/><s:textfield name="localidad" required="true"/>(*)<br><br>
					<s:label value="Provincia"/><s:textfield name="provincia" required="true"/>(*)<br><br>
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