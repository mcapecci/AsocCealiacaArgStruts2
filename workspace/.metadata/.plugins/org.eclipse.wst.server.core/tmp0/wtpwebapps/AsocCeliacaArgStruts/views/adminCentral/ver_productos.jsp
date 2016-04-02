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
		<h3>Gu&iacute;a de productos</h3>
		<table cellpadding="3">
		<thead>
			<tr>
			  <th>Producto</th>
			  <th>Descripci&oacute;n</th>
			  <th>Ver M&aacute;s</th>
			</tr>
	  </thead>
	  <tbody>
			<s:iterator value="all">
			  <tr>
			     <td><s:property value="nombre"/></td>
			     <td><s:property value="descripcion"/></td>
			     <td><s:form theme="simple">
							<s:hidden name="idSelected" value="%{id}"/>
							<s:submit action="producto-verMas" value="Ver Más">
								<img src="resources/tema1/images/more.png" alt="Ver Mas" class="acciones">
							</s:submit><br>
							<s:submit action="producto-editar" value="Editar">
								<img src="resources/tema1/images/edit.png" alt="Editar" class="acciones">
							</s:submit><br>
							<s:submit action="producto-eliminar" value="Eliminar">
								 <img src="resources/tema1/images/delete.png" alt="Eliminar" class="acciones">
							</s:submit>
						</s:form>
					</td>
			  </tr>
			</s:iterator>
	    </tbody>
		</table>
		<s:form theme="simple">
				<s:submit action="registrar_producto" value="Agregar Producto" cssClass="button"/>
			</s:form>
		</div><!-- end main -->
	</div><!-- end content -->
	
	<jsp:include page="/views/templates/footer.jsp" />
</div><!-- end page -->
</body>
</html>