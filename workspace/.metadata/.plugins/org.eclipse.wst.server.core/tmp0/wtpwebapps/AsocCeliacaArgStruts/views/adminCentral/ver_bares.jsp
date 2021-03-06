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
			<h3>Gu&iacute;a de bares</h3>

			<table cellpadding="3">
			<thead>
				<tr>
					<th>Nombre Bar</th>
					<th>Descripci&oacute;n</th>
					<th>Direcci&oacute;n</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="all">
				<tr>
					<td><s:property value="nombre"/></td>
					<td><s:property value="descripcion"/></td>
					<td><s:property value="direccion"/></td>
					<td><s:form theme="simple">
							<s:hidden name="idSelected" value="%{id}"/>
							<s:submit action="bar-editar" value="Editar">
								<img src="resources/tema1/images/edit.png" alt="Editar" class="acciones">
							</s:submit><br>
							<s:submit action="bar-eliminar" value="Eliminar">
								 <img src="resources/tema1/images/delete.png" alt="Eliminar" class="acciones">
							</s:submit>
						</s:form>
					</td>
				</tr>
				</s:iterator>
		   	</tbody>	
			</table>
			<s:form theme="simple">
				<s:submit action="registrar_bar" value="Agregar Bar" cssClass="button"/>
			</s:form>
		</div>
	</div>
	<jsp:include page="/views/templates/footer.jsp" />
</div>
</body>
</html>