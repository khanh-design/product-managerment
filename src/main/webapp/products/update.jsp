<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/23/2025
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update product</title>
</head>
<body>
<h1>Update product</h1>
<p>
  <c:if test="${requestScope['message'] != null}">
    <span>${requestScope['message']}</span>
  </c:if>
</p>
<p>
  <a href="/products">Back to list product</a>
</p>
<form method="post">
  <fieldset>
    <legend>Customer information</legend>
    <table>
      <tr>
        <td>Name: </td>
        <td>
          <input type="text" name="name" id="name" value="${requestScope['product'].getName()}"/>
        </td>
      </tr>
      <tr>
        <td>Price: </td>
        <td>
          <input type="text" name="price" id="price" value="${requestScope['product'].getPrice()}"/>
        </td>
      </tr>
      <tr>
        <td>Description: </td>
        <td>
          <input type="text" name="description" id="description" value="${requestScope['product'].getDescription()}"/>
        </td>
      </tr>
      <tr>
        <td>Manufacturer: </td>
        <td>
          <input type="text" name="manufacturer" id="manufacturer" value="${requestScope['product'].getManufacturer()}"/>
        </td>
      </tr>
      <tr>
        <input type="submit" value="Update"/>
      </tr>
    </table>
  </fieldset>>
</form>
</body>
</html>
