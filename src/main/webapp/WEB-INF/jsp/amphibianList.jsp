<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Amphibian List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Amphibian List</h1>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>Number</th>
            <th>Animal Name</th>
            <th>Class</th>
            <th>Type</th>
        </tr>
        <c:forEach  items="${amphibians}" var ="amphibian">
            <tr>
                <td>${amphibian.getId()}</td>
                <td>${amphibian.getName()}</td>
                <td>${amphibian.getClassName()}</td>
                <td>${amphibian.getType()}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>