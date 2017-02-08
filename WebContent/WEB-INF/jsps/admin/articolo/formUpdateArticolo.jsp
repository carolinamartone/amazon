<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<c:import url="menu.jsp"></c:import>
<form action="/Amazon/admin/articoli/update" method="POST">
	<input type="hidden"  name="id" value="${articolo.getId()}">
	<input type="hidden" name ="categoryId" value="${articolo.getCategoryId()}">
  	<table class="table">
  	<tr>
  	<th>NomeArticolo</th>
  	<th>PrezzoArticolo</th>
  	<th>QuantitaArticolo</th>
  	<th>Azione</th>
  	</tr>
	<tr>
		<td><input type="text" class="form-control" name="name" value="${articolo.getName()}"></td>
		<td><input type="number" class="form-control" name="prezzo" value="${articolo.getPrezzo()}"></td>
		<td><input type="number" class="form-control" name="quantita" value="${articolo.getQuantita()}"></td>
		<td><input type="submit" value="Update"></td>
	</tr>
	</table>
</form>
</body>
</html>