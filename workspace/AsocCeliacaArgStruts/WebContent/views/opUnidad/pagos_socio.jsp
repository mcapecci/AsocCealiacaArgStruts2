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
			<h3>Listado de Pagos</h3>

			<table cellpadding="3">
			<thead>
				<tr>
					<th>Nombre y Apellido</th>
					<th>Dni</th>
					<th>Username</th>
					<th>Pagos</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="all">
				<tr>
					<td><s:property value="nomyap" /></td>
					<td><s:property value="dni" /></td>
					<td><s:property value="username" /></td>
					<td><s:form theme="simple">
							<s:hidden name="idSelected" value="%{id}"/>
							<s:submit action="socioNormal-verPagos" value="Ver Pagos">
								<img src="resources/tema1/images/more.png" alt="Ver Pagos" class="acciones">
							</s:submit>
						</s:form>
					</td>
				</tr>
				</s:iterator>
		   	</tbody>	
			</table>
		</div>
	</div>
	<jsp:include page="/views/templates/footer.jsp" />
</div>
</body>
</html>