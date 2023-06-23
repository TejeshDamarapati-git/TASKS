<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="edit" method="post">
		<pre>
		<input type="hidden" name="id" value="${customer.id}">
		Name<input type="text" name="name" value="${customer.name}">
		Email<input type="text" name="email" value="${customer.email}">
		Phone<input type="text" name="phonenum" value="${customer.phonenum}">
		Submit<input type="submit">
		</pre>
		</form>

		
</body>
</html>