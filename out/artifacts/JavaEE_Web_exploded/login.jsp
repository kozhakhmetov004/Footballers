<%@ page import="java.util.ArrayList" %>
<%@ page import="sk.first.servlet.Born_cities" %>
<%@ page import="sk.first.servlet.DBManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
    <%@include file="Bootstrap.jsp"%>
</head>
<body style=" background-image: url('https://wallpapercave.com/wp/wp4831635.jpg');" >
<%@include file="Navbar.jsp"%>
<form action="/auth" method="post">
    <div>
        <div class="container-8 offset-3"><div class="row"><div class="col-8">
            <br>
            EMAIL:
            <input class="form-control mt-4" type="email" placeholder="example@mail.ru" name="email">
        </div><div class="col-8">
            <br>
            PASSWORD:
            <input class="form-control mt-4" type="password" placeholder="Password..." name="password">
        </div><div class="col-8">
            <button class="btn btn-danger mt-4">Sign In</button>
        </div>
        </div>
        </div>
    </div>
</form>
</body>
</html>
