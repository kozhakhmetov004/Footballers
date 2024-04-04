<%@ page import="java.util.ArrayList" %>
<%@ page import="sk.first.servlet.Born_cities" %>
<%@ page import="sk.first.servlet.DBManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AuthUsers currentUsers = (AuthUsers) request.getAttribute("currentUser");
%>
<html>
<head>
    <title>Log in</title>
    <%@include file="Bootstrap.jsp"%>
</head>
<body style=" background-image: url('https://wallpapercave.com/wp/wp4831635.jpg');" >
<%@include file="Navbar.jsp"%>
<div class="container">
    <div class="row mt-3">
        <div class="col-8 mx-auto">
            <h1>
                WELCOME <%=(currentUsers!=null?currentUser.getFullName():"NO USER")%>
            </h1>
        </div>
    </div>
</div>
</body>
</html>
