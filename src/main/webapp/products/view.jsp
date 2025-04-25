<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/24/2025
  Time: 7:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Products</title>
</head>
<body>
<h1>Products Details</h1>
<p>
    <a href="/products">Back to the product list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>
            ${requestScope['products'].getName()}
        </td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>
            ${requestScope['products'].getPrice()}
        </td>
    </tr>
    <tr>
        <td>Description: </td>
        <td>
            ${requestScope['products'].getDescription()}
        </td>
    </tr>
    <tr>
        <td>Manufacturer: </td>
        <td>${requestScope['products'].getManufacturer()}</td>
    </tr>
</table>
</body>
</html>
