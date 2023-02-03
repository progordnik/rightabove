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


<div align="center">
    <h1>Add animal Form</h1>
    <form action="<%= request.getContextPath() %>/addAnimal" method="post">
        <table style="with: 80%">
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Class</td>
                <td><input type="text" name="class" /></td>
            </tr>
            <tr>
                <td>Type</td>
                <td>
                    <select name="type">
                        <option value="amphibian">Amphibian</option>
                        <option value="mammal" selected>Mammal</option>
                        <option value="waterfowl">Waterfowl</option>
                    </select>
                </td>
            </tr>
        </table>
        <input type="submit" value="Submit" />
    </form>
</div>

</body>

</html>