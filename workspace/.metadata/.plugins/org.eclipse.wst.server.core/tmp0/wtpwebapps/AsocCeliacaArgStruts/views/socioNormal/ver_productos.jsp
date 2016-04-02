<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	
	<jsp:include page="/views/menu/socio.jsp" />
	<h2>PRODUCTOS SOCIO NORMAL</h2>
	
	<h3>Guía de productos</h3>
	<table cellpadding="3">
		<tr>
		  <th>Producto</th>
		  <th>Descripci&oacute;n</th>
		  <th>Ver M&aacute;s</th>
		</tr>
		 
		<s:iterator value="all">
		  <tr>
		     <td><s:property value="nombre"/></td>
		     <td><s:property value="descripcion"/></td>
		     <td><a href="<s:url action="producto-verMas">
		     				<s:param name="idSelected" value="id"></s:param>
		     			</s:url>">
		     		Ver M&aacute;s
		     		</a>
		     </td>
		  </tr>
		</s:iterator>
	</table>
</body>
</html>