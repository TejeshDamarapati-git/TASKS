<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Customers</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<a href="get" class="btn btn-outline-primary">Search</a>
<div class="container">
    <h2 class="text-center">Customers List</h2>
    <div class="table responsive">
    <table class="table table-striped">
        <thead>
            <tr>
                <td>Id</td>
                <td>Customer Name</td>
                <td>Email</td>
                <td>Mobile</td>
                <td colspan="2">Actions</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customer}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.phonenum}</td>
                <td> <a href="Delete?id=${customer.id}">DELETE</a>
                <td> <a href="Update?id=${customer.id}">UPDATE</a>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>
    </div>
</body>
</html>