<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/25/2025
  Time: 7:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete products</title>
</head>
<body>
<h1>Delete products</h1>
<p>
    <a href="/products">Back to list products</a>
</p>
<form method="post">
    <h3>Tag delete products</h3>
    <fieldset>
        <legend>Products information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>
                    <input type="text" name="name" id="name" value="${requestScope['products'].getName()}"/>
                </td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>
                    <input type="text" name="price" id="price" value="${requestScope['products'].getPrice()}"/>
                </td>
            </tr>
            <tr>
                <td>Description: </td>
                <td>
                    <input type="text" name="description" id="description" value="${requestScope['products'].getDescription()}"/>
                </td>
            </tr>
            <tr>
                <td>Manufacturer: </td>
                <td>
                    <input type="text" name="manufacturer" id="manufacturer" value="${requestScope['products'].getManufacturer()}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Delete"/>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
