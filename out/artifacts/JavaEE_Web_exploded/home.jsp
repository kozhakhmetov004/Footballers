<%@ page import="java.util.ArrayList" %>
<%@ page import="sk.first.servlet.Footballer" %>
<%@ page import="sk.first.servlet.DBManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="Bootstrap.jsp"%>
<head>
    <title>Title</title>
</head>
<body><div>
    <%@include file="Navbar.jsp"%>
    <div class="container-12">
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">
                    ID
                </th>
                <th scope="col">
                    NAME
                </th>
                <th scope="col">
                    SURNAME
                </th>
                <th scope="col">
                    SALARY
                </th>
                <th scope="col">
                    CLUB
                </th>
                <th scope="col">
                    TRANSFER PRICE
                </th>
                <th scope="col">
                    BORNED CITY
                </th>
                <th scope="col">
                    DETAILS
                </th>
            </tr>

            </thead>
            <tbody>
            <%
                ArrayList<Footballer> footballers = (ArrayList<Footballer>) request.getAttribute("futbolisty");
                for(int i=0;i<footballers.size();i++){
            %>
            <tr>
                <td>
                    <%=footballers.get(i).getId()%>
                </td>
                <td>
                    <%=footballers.get(i).getName()%>
                </td>
                <td>
                    <%=footballers.get(i).getSurname()%>
                </td>
                <td>
                    <%=footballers.get(i).getSalary()%>
                </td>
                <td>
                    <%=footballers.get(i).getClub()%>
                </td>
                <td>
                    <%=footballers.get(i).getTransferPrice()%>
                </td>
                <td>
                    <%=footballers.get(i).getBorn_city().getName()+" / "+footballers.get(i).getBorn_city().getCountry_code()%>
                </td>
                <td>
                    <a href="/details?id=<%=footballers.get(i).getId()%>" class="btn btn-danger">SHOW DETAILS</a>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
