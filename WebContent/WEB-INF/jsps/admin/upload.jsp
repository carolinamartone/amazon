<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Upload File</title>
</head>
<body>
	<form method="POST" action="upload?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
		<p>File to upload: <input type="file" name="file"> </p>
		<p>Press here to upload the file!<input type="submit" value="Upload"></p>
	</form>
</body>
</html>