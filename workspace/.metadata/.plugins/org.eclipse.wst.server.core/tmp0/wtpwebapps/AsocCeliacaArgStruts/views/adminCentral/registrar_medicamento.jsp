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
				<h3>Registrar Medicamento</h3>
				<fieldset align="right">
				<s:fielderror />
				<s:form action="medicamento-registrado" theme="simple">
					<s:label value="Nombre"/><s:textfield name="nombre" required="true"/>(*)<br><br>
					<s:label value="Descripción"/><s:textfield name="descripcion" required="true"/>(*)<br><br>
					<s:label value="Precio"/><s:textfield name="precio" required="true"/>(*)<br><br>
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