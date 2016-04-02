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
			<h3>Historial de pagos: <s:property value=selected.nomyap/></h3>
			<h3>Historial de pagos: ${selected.nomyap}</h3>

			<table cellpadding="3">
			<thead>
				<tr>
					<th>Fecha Pago</th>
					<th>Importe</th>
					<th>Per&iacute;odo</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="getPagos">
				<tr>			
					<td><s:property value="fechaPago" /></td>
					<td><s:property value="importe" /></td>
					<td><s:property value="periodo" /></td>
				</tr>
				</s:iterator>
		   	</tbody>	
			</table>
			<s:form theme="simple">
				<s:submit action="registrar_pago" value="Registrar Pago" cssClass="button"/>
				<s:submit value="Volver" action="pagos_socioNormal" cssClass="button" />
			</s:form>
		</div>
	</div>
	<jsp:include page="/views/templates/footer.jsp" />
</div>
</body>
</html>