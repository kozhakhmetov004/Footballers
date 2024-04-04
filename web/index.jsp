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
<form action="/addfootballer" method="post">
    <div>
        <%@include file="Navbar.jsp"%>
        <div class="container-8 offset-3"><div class="row"><div class="col-8">
            <input class="form-control mt-4" type="text" placeholder="Name" name="footballer_name">
        </div><div class="col-8">
            <input class="form-control mt-4" type="text" placeholder="Surname" name="footballer_surname">
        </div><div class="col-8">
            <input class="form-control mt-4" type="number" placeholder="Salary" name="footballer_salary">
        </div><div class="col-8">
            <input class="form-control mt-4" type="text" placeholder="Club" name="footballer_club">
        </div><div class="col-8">
            <input class="form-control mt-4" type="number" placeholder="Transfer Price" name="footballer_transfer_price">
        </div><div class="col-8">
            <select class="form-control mt-4" name="footballer_born_city_id">
                <%
                 ArrayList<Born_cities> born_cities= DBManager.getBornCities() ;
                    if(born_cities!=null){
                        for(Born_cities bc : born_cities){

                %>
                <option value="<%=bc.getId()%>">
                    <%=bc.getName()+" / "+bc.getCountry_code()%>
                </option>
                <%
                        }
                    }
                %>
            </select>
        </div><div class="col-8">
            <button class="btn btn-danger mt-4">ADD FOOTBALLER</button>
        </div>
        </div>
    </div>
</form>
</body>
</html>
