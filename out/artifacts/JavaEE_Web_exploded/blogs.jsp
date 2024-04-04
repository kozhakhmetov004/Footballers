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
                ArrayList<Blogs> blogs = (ArrayList<Blogs>) request.getAttribute("blogs");
                if(blogs!=null){
                    for(Blogs b : blogs){
            %>
            <div class="alert alert-danger" role="alert">
                <br>
                <h4 class="alert-heading"><%=b.getTitle()%></h4>
                <br>
                <p><%=b.getShortContent()%></p>
                <br>
                <hr>
                <br>
                <p class="mb-0">Posted by <%=b.getUser().getFullName()%> at <%=b.getPost_date()%></p>
                <br>
                <a class="btn btn-danger btn-sm" href="/blogdetail?id=<%=b.getId()%>" role="button">Read More →</a>
                <br>
            </div>
            <%
                }
                }
            %>
        </div>
    </div>

</div>

</body>
</html>
