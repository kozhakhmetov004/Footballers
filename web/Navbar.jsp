<%@ page import="sk.first.servlet.AuthUsers" %><%
    AuthUsers currentUser = (AuthUsers) request.getAttribute("currentUser");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(currentUser!=null){
%>
<nav class="navbar navbar-expand-lg navbar-light bg-danger">
    <a class="navbar-brand" href="http://localhost:1111/"><%=currentUser.getFullName()%></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="2">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    More
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/">About</a>
                    <a class="dropdown-item" href="/">Partners</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Suggestions</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/addblog">Add New Blog</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/logout">Log Out</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" style="width:400px;">
            <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<%
    }else{
%>
<nav class="navbar navbar-expand-lg navbar-light bg-danger">
    <a class="navbar-brand" href="http://localhost:1111/">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    More
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/">About</a>
                    <a class="dropdown-item" href="/">Partners</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/">Suggestions</a>
                </div>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/login">Sign In</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/register">Register</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" style="width:400px;">
            <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<%
    }
%>
