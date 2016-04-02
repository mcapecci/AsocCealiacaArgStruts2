<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import='java.util.*' %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="left-box">
<nav id="menu">
			<div class="itemMenu">Gesti&oacute;n de Operadores</div>
			<ul>
				<li> <a href="<s:url action="registrar_opC"/>">Registrar operador</a></li>
				<li> <a href="<s:url action="ver_operadoresC"/>">Listado de operadores</a></li>
			</ul>			
			<br/>
			<div class="itemMenu">Gesti&oacute;n de Informaci&oacute;n</div>
			<ul>
				<li> <a href="<s:url action="ver_filiales"/>">Filiales</a> </li>
				<li> <a href="<s:url action="ver_delegaciones"/>">Delegaciones</a> </li>
				<li> <a href="<s:url action="ver_g_referencias"/>">Grupos de referencia</a> </li>
				<li> <a href="<s:url action="ver_i_beneficiarias"/>">Instituciones Beneficiarias</a> </li>
				<li> <a href="<s:url action="registrar_sede" />">Registrar Sede</a> </li>
			</ul>
			<br/>
			<div class="itemMenu">Gesti&oacute;n de Gu&iacute;as</div>
			<ul>
				<li> <a href="<s:url action="ver_productos"/>">Listado de Productos</a></li>
				<li> <a href="<s:url action="registrar_producto"/>">Registrar Producto</a> </li>
				<li> <a href="<s:url action="ver_medicamentos"/>">Listado de Medicamentos</a> </li>
				<li> <a href="<s:url action="registrar_medicamento"/>">Registrar Medicamento</a> </li>
				<li> <a href="<s:url action="ver_bares"/>">Listado de Bares</a></li>
				<li> <a href="<s:url action="registrar_bar"/>">Registrar Bar</a></li>
			</ul>
			<br/>
			<div class="itemMenu">Configuraci&oacute;n de la cuenta</div>
			<ul>
				<li> <a href="<s:url action="ver_datos" />"> Ver sus datos personales</a> </li>
				<li> <a href="<s:url action="editar_datos" />">Actualizar datos de contacto </a> </li>
				<li> <a href="<s:url action="cambiar_pass" />">Cambiar contrase&ntilde;a </a> </li>
			</ul>
</nav>
</div>