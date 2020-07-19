<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Artículos</title>
</head>
<body>
	<h1>Lista  Artículos</h1>
	<table>
		<tr>
			<td><a href="AdminAlumno?action=mostrarporId&id=<c:out value="${lista[0].id}" />" >Alumno</a> </td>
		</tr>
	</table>
	
	<table border="1" width="100%">
		<tr>
		 <td> CATEGORIA</td>
		 <td> FECHADOC</td>
		 <td> NROSERIE</td>
		 <td>DIRECCION</td>
		 <td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="documento" items="${lista}">
			<tr>
				<td><c:out value="${documento.categoria}"/></td>
				<td><c:out value="${documento.fechadoc}"/></td>
				<td><c:out value="${documento.nroserie}"/></td>
				<td><c:out value="${documento.direccionimagen}"/></td>
				<td><a href="adminArticulo?action=showedit&id=<c:out value="${documento.id}" />">Editar</a></td>
				<td><a href="adminArticulo?action=eliminar&id=<c:out value="${documento.id}"/>">Eliminar</a> </td>				
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>