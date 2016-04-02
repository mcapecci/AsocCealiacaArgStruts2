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
			<h3>Gu&iacute;a de medicamentos</h3>
			
			<table cellpadding="3">
				<thead>
					<tr>
						<th>Medicamento</th>
						<th>Descripci&oacute;n</th>
						<th>Precio</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="all">
						<tr>
							<td><s:property value="nombre" /></td>
							<td><s:property value="descripcion" /></td>
							<td><s:property value="precio" /></td>
							<td><s:form theme="simple">
										<s:hidden name="idSelected" value="%{id}"/>
										<s:submit action="medicamento-editar" value="Editar">
											<img src="resources/tema1/images/edit.png" alt="Editar" class="acciones">
										</s:submit><br>
										<s:submit action="medicamento-eliminar" value="Eliminar">
											 <img src="resources/tema1/images/delete.png" alt="Eliminar" class="acciones">
										</s:submit>
									</s:form>
							</td>
							
					   	</tr>
					</s:iterator>
				</tbody>	
			</table>
			<s:form theme="simple">
				<s:submit action="registrar_medicamento" value="Agregar Medicamento" cssClass="button"/>
			</s:form>
		</div>
	</div>
	<jsp:include page="/views/templates/footer.jsp" />
</div>
</body>
</html>