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
		<jsp:include page="/views/menu/adminUnidad.jsp" />
		<div id="main">
				<h3>Actualizar datos de contacto</h3>
				<fieldset align="right">
				<s:form action="adminunidad-modificado" theme="simple">
					<s:label value="Nombre y Apellido"/><s:textfield name="nomyap" value="%{user.nomyap}" readonly="true" cssClass="readonly"/><br><br>
					<s:label value="Email"/><s:textfield name="email" value="%{user.email}"/>(*)<br><br>
					<s:label value="Teléfono"/><s:textfield name="telefono" value="%{user.telefono}"/>(*)<br><br>
					<s:label value="Dirección"/><s:textfield name="direccion" value="%{user.direccion}"/>(*)<br><br>
					<s:label value="Username"/><s:textfield name="username" value="%{user.username}" readonly="true" cssClass="readonly"/><br><br>
					<s:hidden name="idSelected" value="%{user.id}"/>
					<s:submit value="Guardar cambios" cssClass="button"/>
					<s:submit value="Cancelar" action="ver_datos" cssClass="button" />
				</s:form>
				<br>
				(*): Campo Obligatorio
				</fieldset>			
		</div>
	</div>
	<jsp:include page="/views/templates/footer.jsp" />
</div>
</body>
</html>