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
<%


    Cookie name = null;






        if (name!=null){

%>
<form action="/addcookie" method="post">
    NAME : <input type="text" name="cookiename" value="<%=name.getValue()%>"><br>
    SURNAME : <input type="text" name="cookiesurname" placeholder="%>"><br>
    AGE : <input type="number" name="cookieage" value="%>"><br>
    COUNTRY : <input type="text" name="cookiecountry" placeholder=""><br>
    GENDER : <input type="radio"  name="cookiegender" value="male" >
    <label for="man">Male</label>
    <input type="radio" name="cookiegender" value="female" >
    <label for="man">Female</label><br>
    CREDIT CARD : <input type="text" name="cookiecard" placeholder=""><br>
    <button>SET COOKIES</button>
</form>
<%
    }else{
%>
<form action="/addcookie" method="post">
NAME : <input type="text" name="cookiename" placeholder="Name"><br>
SURNAME : <input type="text" name="cookiesurname" placeholder="Surname"><br>
AGE : <input type="number" name="cookieage" value="0"><br>
COUNTRY : <input type="text" name="cookiecountry" placeholder="Country"><br>
GENDER : <input type="radio" id="man" name="cookiegender" value="male" >
<label for="man">Male</label>
<input type="radio" id="woman" name="cookiegender" value="female" >
<label for="man">Female</label><br>
CREDIT CARD : <input type="text" name="cookiecard" placeholder="XXXX XXXX XXXX XXXX"><br>
<button>SET COOKIES</button>
</form>
<%
    }
%>
</body>
</html>
