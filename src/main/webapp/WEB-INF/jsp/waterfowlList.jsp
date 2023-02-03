<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Waterfowl List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Waterfowl List</h1>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>Number</th>
            <th>Animal Name</th>
            <th>Class</th>
            <th>Type</th>
        </tr>
        <c:forEach  items="${waterfowls}" var ="waterfowl">
            <tr>
                <td>${waterfowl.getId()}</td>
                <td>${waterfowl.getName()}</td>
                <td>${waterfowl.getClassName()}</td>
                <td>${waterfowl.getType()}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>