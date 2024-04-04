<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.01.2021
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
<form action="/setsession" method="post">
NAME : <input type="text" name="name" placeholder="Name"><br>
SURNAME : <input type="text" name="surname" placeholder="Surname"><br>
AGE : <input type="number" name="age" value="0"><br>
<button>SET SESSION</button>
</form>
    <h1>
    <%
        String name = (String) request.getAttribute("name");
        String surname = (String) request.getAttribute("surname");
        String age = (String) request.getAttribute("age");
        out.println("HELLO "+name+" "+surname+" "+age);
    %>
    </h1>

</body>
</html>
