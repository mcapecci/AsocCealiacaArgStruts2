<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="left-box">
		<nav id="menu">
			<div class="itemMenu">Gu&iacute;as para cel&iacute;acos</div>
			<ul>
				<li> <a href="<s:url action="ver_productos" />">Ver la Gu&iacute;a de productos </a> </li>
				<li> <a href="<s:url action="ver_medicamentos" />"> Ver la Gu&iacute;a de medicamentos</a> </li>
				<li> <a href="<s:url action="ver_bares"/>">Ver la Gu&iacute;a de bares </a> </li>
			</ul>			
			<br/>
			<div class="itemMenu">Cuenta Corriente</div>
			<ul>
				<li> <a href="<s:url action="estado_cuenta" />">Ver estado de cuenta </a> </li>
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