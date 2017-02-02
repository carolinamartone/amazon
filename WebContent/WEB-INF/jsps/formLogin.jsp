<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Login Page</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="alert alert-info" role="alert">${flash.getMessage()}</div>
	<form method="post" action="/Amazon/users/login">
		<div style="padding: 100px 0 0 250px;">
			<div id="login-box">
				<h2>Login Page</h2>
				<div id="login-box-name" style="margin-top: 20px;">Username:</div>
				<div id="login-box-field" style="margin-top: 20px;">
					<input name="username" class="form-login" title="Username" value="" size="30" maxlength="50" />
				</div>
				<div id="login-box-name">Password:</div>
				<div id="login-box-field">
					<input name="password" type="password" class="form-login" title="Password" value="" size="30" maxlength="48" />
				</div>
				<br /> 
				 <input style="margin-left: 100px;" type="submit" value="Login" />
			</div>
		</div>
	</form>
</body>
</html>