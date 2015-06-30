<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<table>
    <thead>
    <th>SKU</th>
    <th>Category</th>
    <th>Title</th>
    </thead>
    <tbody>
    <c:forEach items="${all}" var="current">
        <tr>
            <td>
                    <c:out value="${current.sku}"/>
            </td>
            <td>
                    <c:out value="${current.category}"/>
            </td>
            <td>
                    <c:out value="${current.title}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
