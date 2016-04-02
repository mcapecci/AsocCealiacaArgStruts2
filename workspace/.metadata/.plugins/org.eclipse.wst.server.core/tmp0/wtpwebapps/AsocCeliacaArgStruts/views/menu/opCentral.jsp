<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import='java.util.*' %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="left-box">
<nav id="menu">
	<div class="itemMenu">Gesti&oacute;n de Socios de la Central</div>
	<ul>				
		<li><a href="<s:url action="registrar_central"/>">Registrar Socio</a></li>
		<li><a href="<s:url action="ver_central"/>">Listado de Socios</a></li>
		<li><a href="<s:url action="ver_pagos_socioN"/>">Listado de Pagos</a></li>
	</ul>
	<br />
	<div class="itemMenu">Gesti&oacute;n de Socios Virtuales</div>
	<ul>		
		<li><a href="<s:url action="registrar_virtual"/>">Registrar Socio</a></li>
		<li><a href="<s:url action="ver_virtual"/>">Listado de Socios</a></li>
		<li><a href="<s:url action="ver_pagos_socioV"/>">Listado de Pagos</a></li>
		<li><a href="<s:url action="ver_avisospago"/>">Listado de Avisos de Pago</a></li>
	</ul>
	<br />
	<div class="itemMenu">Consulta de Socios de Unidades</div>
	<ul>				
		<li><a href="<s:url action="ver_unidad"/>">Listado de socios</a></li>
	</ul>
	<br />
	<div class="itemMenu">Configuraci&oacute;n de la cuenta</div>
	<ul>	
		<li><a href="<s:url action="ver_datos"/>">Ver sus datos personales</a></li>
		<li><a href="<s:url action="editar_datos"/>">Actualizar datos de contacto</a></li>
		<li><a href="<s:url action="cambiar_pass"/>">Cambiar contrase&ntilde;a</a></li>
	</ul> 
</nav>
</div>