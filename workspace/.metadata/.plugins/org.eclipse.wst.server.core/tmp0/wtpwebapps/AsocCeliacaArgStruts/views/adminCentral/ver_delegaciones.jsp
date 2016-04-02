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
			<h3>Listado de Delegaciones</h3>

			<table cellpadding="3">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Tel&eacute;fono</th>
					<th>Valor Cuota</th>
					<th>Direcci&oacute;n</th>
					<th>Localidad</th>
					<th>Provincia</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="allDelegaciones">
				<tr>
					<jsp:include page="/views/templates/ver_sede.jsp" />
				</tr>
				</s:iterator>
		   	</tbody>	
			</table>
			<s:form theme="simple">
				<s:submit action="registrar_sede" value="Agregar Sede" cssClass="button"/>
			</s:form>
		</div>
	</div>
	<jsp:include page="/views/templates/footer.jsp" />
</div>
</body>
</html>