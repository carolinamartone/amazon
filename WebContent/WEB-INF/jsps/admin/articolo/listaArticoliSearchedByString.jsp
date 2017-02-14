<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>listaArticoliSearchedByString</title>
</head>
<body>
<c:import url="menu.jsp"></c:import>
<div class="alert alert-info" role="alert">${flash.getMessage()}</div>
	<div class="container" style="margin-top: 80px">
		<div class="jumbotron">
			<h2>Articoli</h2>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Azioni</th>
							
						</tr>
					</thead>	
					<c:forEach var="articolo" items="${articoli}" >
						<tr>
							<td>${articolo.getId()}</td>
							<td><a href="/Amazon/articoli/${articolo.getId()}">${articolo.getName()}</a></td>
							<td><a href="/Amazon/admin/articoli/${articolo.getId()}/update">Update</a><a href="/Amazon/admin/articoli/${articolo.getId()}/delete">Delete</a></td>
							
						</tr>
						
					</c:forEach>	
	
				</table>
				<a href="/Amazon/admin/articoli/create">AddArticoli</a>
			</div>
		</div>
		</div>
</body>
</html>