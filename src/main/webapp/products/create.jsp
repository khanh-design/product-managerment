<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/23/2025
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create a new products</title>
</head>
<body>
<h1>Create new products</h1>
<p>
  <c:if test="${requestScope['message'] != null}}">
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p>
  <a href="/products">Back to list products</a>
</p>
<form method="post">
  <fieldset>
    <legend>Product information</legend>
    <table>
      <tr>
        <td>Name: </td>
        <td>
          <input type="text" name="name" value="${requestScope['product'].getName()}" />
        </td>
      </tr>
      <tr>
        <td>Price:</td>
        <td>
          <input type="text" name="price" value="${requestScope['product'].getPrice()}" />
        </td>
      </tr>
      <tr>
        <td>Description: </td>
        <td>
          <input type="text" name="description" value="${requestScope['product'].getDescription()}" />
        </td>
      </tr>
      <tr>
        <td>Mamufacture: </td>
        <td>
          <input type="text" name="mamufacture" value="${requestScope['product'].getMamufacture()}" />
        </td>
      </tr>
      <tr>
        <input type="submit" value="Save" />
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
