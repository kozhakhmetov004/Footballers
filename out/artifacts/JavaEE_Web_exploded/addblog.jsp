<%@ page import="java.util.ArrayList" %>
<%@ page import="sk.first.servlet.Born_cities" %>
<%@ page import="sk.first.servlet.DBManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Footballer</title>
    <%@include file="Bootstrap.jsp"%>
</head>
<body style=" background-image: url('https://wallpapercave.com/wp/wp4831635.jpg');" >
<%@include file="Navbar.jsp"%>
<div class="container">
    <div class="row mt-3">
        <div class="col-9 mx-auto">
            <form action="/addblog" method="post">
                <div class="form-group">
                    <label>
                        TITLE:
                    </label>
                    <input type="text" class="form-control" name="title">
                </div>
                <div class="form-group">
                    <label>
                        SHORT CONTENT:
                    </label>
                    <textarea class="form-control" name="short_content" rows="4"></textarea>
                </div>
                <div class="form-group">
                    <label>
                        CONTENT:
                    </label>
                    <textarea class="form-control" name="content" rows="10"></textarea>
                </div>
                <div class="form-group">
                    <button class="btn btn-danger">ADD BLOG</button>
                </div>
            </form>
        </div>
    </div>

</div>

</body>
</html>
