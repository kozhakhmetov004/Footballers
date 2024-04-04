<%@ page import="sk.first.servlet.Footballer" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20.01.2021
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        Footballer footballer =(Footballer) request.getAttribute("futbolist");
    %>
    <%@include file="Bootstrap.jsp"%>
    <%@include file="Navbar.jsp"%>
</head>
<body>
<form action="/details" method="post" style="margin-top: -30px" class="container-8 offset-2">
    <div class="form-group" style="display: none" >
        <label>ID</label>
        <input type="text" class="form-control" name="efootballer_id" value="<%=footballer.getId()%>">
    </div>
    <div class="form-group mt-5" style="width: 75%">
        <label>Name</label>
        <input type="text" class="form-control" name="efootballer_name" value="<%=footballer.getName()%>">
    </div>
    <div class="form-group" style="width: 75%">
        <label>Surname</label>
        <input type="text" class="form-control" name="efootballer_surname" value="<%=footballer.getSurname()%>">
    </div>
    <div class="form-group" style="width: 75%">
        <label>Salary</label>
        <input type="number" class="form-control" name="efootballer_salary" value="<%=footballer.getSalary()%>">
    </div>
    <div class="form-group" style="width: 75%">
        <label>Club</label>
        <input type="text" class="form-control" name="efootballer_club" value="<%=footballer.getClub()%>">
    </div>
    <div class="form-group" style="width: 75%">
        <label>Transfer Price</label>
        <input type="text" class="form-control" name="efootballer_transfer_price" value="<%=footballer.getTransferPrice()%>">
    </div>
    <div class="form-group" style="width: 75%">
        <label>BORN COUNTRY</label>
        <input type="text" class="form-control" name="efootballer_born_city_id" value="<%=footballer.getBorn_city().getId()%>"><%=footballer.getBorn_city().getName()%>
    </div>
    <%
        if(currentUser!=null){
    %>
    <button type="submit" class="btn btn-success" onclick="function alert(){ alert.style.display=initial }">Edit</button>
    <a href="/delete?id=<%=footballer.getId()%>"  type="submit" class="btn btn-danger">Delete</a>
    <%
        }
    %>
</form>
</body>
</html>
