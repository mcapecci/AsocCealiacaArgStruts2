<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import='java.util.*' %>
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
		<div id="profile">
					¡Bienvenido/a!<br>
					Perfil:Visitante<br>
		</div><!-- end profile -->
			
		<div id="left-box">
			<fieldset id="login" align="center" >
				<s:fielderror />
				<s:label value="Acceso a Usuarios"/><br><br>
				<s:form action="Login" theme="simple">
					<s:textfield placeholder="Nombre de Usuario " name="username" /><br><br>
					<s:password placeholder="Contraseña " name="password" /><br><br>
					<s:submit value="Entrar" cssClass="button"/>
				</s:form>
				<br><br>
				<p>
				<a href="<s:url value="/olvido_user.jsp"/>">¿Olvid&oacute; su nombre de usuario?</a><br>
				<a href="<s:url value="/olvido_pass.jsp"/>">¿Olvid&oacute; su contrase&ntilde;a?</a>
				</p>
			</fieldset>	
		</div>
		
		<div id="main">
		<jsp:include page="/views/templates/intro.jsp" />
		
		<table columns="2" border="1" cellpadding="1" cellspacing="1">
		<thead>
			<tr>
			  <th>Nombre de Usuario</th>
			  <th>Contraseña</th>
			</tr>
	  	</thead>
	  	<tbody>
			  <tr>
			     <td>adminCentral</td>
			     <td>adminCentral</td>
			  </tr>
			  <tr>
			     <td>adminUnidad</td>
			     <td>adminUnidad</td>
			  </tr>
			  <tr>
			     <td>opCentral</td>
			     <td>opCentral</td>
			  </tr>
			  <tr>
			     <td>opUnidad</td>
			     <td>opUnidad</td>
			  </tr>
			  <tr>
			     <td>jperez (socio normal)</td>
			     <td>jperez</td>
			  </tr>
			  <tr>
			     <td>gRiddick (socio normal)</td>
			     <td>gRiddick</td>
			  </tr>
			  <tr>
			     <td>mVidal (socio virtual)</td>
			     <td>mVidal</td>
			  </tr>
	    </tbody>
		</table>
		</div>
		
	</div>
	
	<jsp:include page="/views/templates/footer.jsp" />
</div>
</body>
</html>