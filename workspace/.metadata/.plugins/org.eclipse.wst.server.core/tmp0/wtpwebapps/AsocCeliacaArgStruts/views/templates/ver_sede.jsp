<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<td><s:property value="nombre" /></td>
<td><s:property value="telefono" /></td>
<td><s:property value="valorCuota" /></td>
<td><s:property value="direccion" /></td>
<td><s:property value="localidad" /></td>
<td><s:property value="provincia" /></td>
<td><s:form theme="simple">
		<s:hidden name="idSelected" value="%{id}"/>
		<s:submit action="sede-editar" value="Editar">
			<img src="resources/tema1/images/edit.png" alt="Editar" class="acciones">
		</s:submit><br>
		<s:submit action="sede-eliminado" value="Eliminar">
			 <img src="resources/tema1/images/delete.png" alt="Eliminar" class="acciones">
		</s:submit>
	</s:form>
</td>