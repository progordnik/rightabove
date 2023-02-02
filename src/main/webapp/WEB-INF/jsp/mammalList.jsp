<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Mammal List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Mammal List</h1>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>Number</th>
            <th>Animal Name</th>
            <th>Class</th>
            <th>Type</th>
        </tr>
        <c:forEach  items="${mammals}" var ="mammal">
            <tr>
                <td>${mammal.getId()}</td>
                <td>${mammal.getName()}</td>
                <td>${mammal.getClassName()}</td>
                <td>${mammal.getType()}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>