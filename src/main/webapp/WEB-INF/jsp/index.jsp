<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Welcome</h1>
<h2>${message}</h2>



<a href="${pageContext.request.contextPath}/mammalList">Mammal List</a>
<a href="${pageContext.request.contextPath}/amphibianList">Amphibian List</a>
<a href="${pageContext.request.contextPath}/waterfowlList">Waterfowl List</a>

</body>

</html>