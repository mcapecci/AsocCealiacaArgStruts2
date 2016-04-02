<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="main">	
	<h3>Ficha completa del producto</h3>
	<fieldset align="center" style="padding-right: 0px; padding-left: 60px;">
		<s:label value="Producto"/>${selected.nombre}<br><br>
		<s:label value="Descripcion" />${selected.descripcion}<br><br>
		<s:label value="R.N.P.A" />${selected.rnpa}<br><br>
		<s:label value="Empresa" />${selected.empresa}<br><br>
		<s:label value="R.N.E" />${selected.rne}<br><br>
		<s:label value="Fecha" />${selected.fecha}<br><br>
		<s:label value="Fecha certificado LDG" />${selected.fechaCertLdg}<br><br>
		<s:label value="Comentario" />${selected.comentario}<br><br>
		<s:form theme="simple">
			<s:submit cssClass="button" action="ver_productos" value="Volver" align="center"/>
		</s:form>
	</fieldset>
</div>
