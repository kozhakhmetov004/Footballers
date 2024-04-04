<%@ page import="java.util.ArrayList" %>
<%@ page import="sk.first.servlet.Born_cities" %>
<%@ page import="sk.first.servlet.DBManager" %>
<%@ page import="sk.first.servlet.Blogs" %>
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
            <%
                Blogs blog = (Blogs) request.getAttribute("blog");
                if(blog!=null){
            %>
            <div class="alert alert-danger" role="alert">
                <br>
                <h4 class="alert-heading"><%=blog.getTitle()%></h4>
                <br>
                <p><%=blog.getContent()%></p>
                <br>
                <hr>
                <br>
                <p class="mb-0">Posted by <%=blog.getUser().getFullName()%> at <%=blog.getPost_date()%></p>
                <br>
                <a class="btn btn-danger btn-sm" href="/blogdetail?id=<%=blog.getId()%>" role="button">Read More →</a>
                <br>
            </div>
            <%
                }else{
            %>
            <img width="90%" src="https://www.nicepng.com/png/full/225-2255762_error404-error-404-icono-png.png">
            <%
                }
            %>
        </div>
    </div>

</div>

</body>
</html>
