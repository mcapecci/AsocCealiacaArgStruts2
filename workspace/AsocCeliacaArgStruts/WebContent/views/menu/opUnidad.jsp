<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import='java.util.*' %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="left-box">
<nav id="menu">
	<div class="itemMenu">Gesti&oacute;n de Socios</div>
	<ul>
		<li><a href="<s:url action="registrar_socioNormal"/>">Registrar socio</a></li>
		<li><a href="<s:url action="ver_sociosNormal"/>">Listado de socios</a></li>
		<li><a href="<s:url action="pagos_sociosNormal"/>">Listado de pagos</a></li>
	</ul>
	<div class="itemMenu">Configuraci&oacute;n de la cuenta</div>
	<ul>	
		<li><a href="<s:url action="ver_datos"/>">Ver sus datos personales</a></li>
		<li><a href="<s:url action="editar_datos"/>">Actualizar datos de contacto</a></li>
		<li><a href="<s:url action="cambiar_pass"/>">Cambiar contrase&ntilde;a</a></li>
	</ul>			
</nav>
</div>