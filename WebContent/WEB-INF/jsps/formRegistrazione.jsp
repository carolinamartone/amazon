<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>formRegistrazione</title>
<style type="text/css">
h3 {
	font-family: Calibri;
	font-size: 22pt;
	font-style: normal;
	font-weight: bold;
	color: SlateBlue;
	text-align: center;
	text-decoration: underline
}

table {
	font-family: Calibri;
	color: white;
	font-size: 11pt;
	font-style: normal;
	width: 50%;
	text-align:;
	background-color: SlateBlue;
	border-collapse: collapse;
	border: 2px solid navy
}

table.inner {
	border: 0px
}
</style>
</head>
<body>
	<h3>User Registration Form</h3>
	<div class="alert alert-info" role="alert">${flash.getMessage()}</div>
	<form action="/Amazon/users/registrazione" method="POST">
		<table align="center" cellpadding="10">
			<tr>
				<td>Select a Role</td>
				<td><select name="user_roles_id">
						<c:forEach var="user_roles" items="${user_roles}">
							<option value="${user_roles.getUserRoleId()}">${user_roles.getRole()}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" maxlength="30"
					value="${username}" /> (max 30 characters a-z and A-Z)</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" maxlength="100"
					value="${password}" /></td>
			</tr>
			<tr>
				<td>Ripeti Password</td>
				<td><input type="text" name="password2" maxlength="100" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="${_csrf.parameterName}"
					maxlength="30" value="${_csrf.token}" /></td>
				<td colspan="2" align="center"><input type="submit"
					value="Registrati"></td>
			</tr>
		</table>
	</form>
</body>
</html>
