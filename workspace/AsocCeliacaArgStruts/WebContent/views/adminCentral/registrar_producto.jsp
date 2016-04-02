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
				<h3>Registrar producto</h3>
				<fieldset align="right">
				<s:fielderror />
				<s:form action="producto-registrado" theme="simple">
					<s:label value="Nombre Producto"/><s:textfield name="nombre" required="true"/>(*)<br><br>
					<s:label value="Descripción"/><s:textfield name="descripcion" required="true"/>(*)<br><br>
					<s:label value="R.N.P.A"/><s:textfield name="rnpa" required="true"/>(*)<br><br>
					<s:label value="Empresa"/><s:textfield name="empresa" required="true"/>(*)<br><br>
					<s:label value="R.N.E"/><s:textfield name="rne" required="true"/>(*)<br><br>
					<s:label value="Fecha"/><s:textfield name="fechaCertLdg" required="true"/>(*)<br><br>
					<s:label value="Fecha cert. LDG"/><s:textfield name="fechaCertLdg" required="true"/>(*)<br><br>
					<s:label value="Comentario"/><s:textfield name="comentario" required="true"/>(*)<br><br>
					<s:submit value="Registrar" cssClass="button"/>
					<s:submit redirect="index" value="Cancelar" cssClass="button"/>
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