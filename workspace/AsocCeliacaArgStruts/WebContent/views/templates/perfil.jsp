<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="profile">
	¡Bienvenid@ ${user.username}!<br>
	Perfil: ${perfil}<br>
	<a href="<s:url action="logout"/>">Cerrar Sesi&oacute;n</a>
</div><!-- end profile -->