package sk.first.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/addfootballer")
public class AddFootballerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        AuthUsers authUser = (AuthUsers) session.getAttribute("AUTH_DATA");


        if(authUser!=null){

            request.setAttribute("currentUser",authUser);

        }

        String fname= request.getParameter("footballer_name");
        String fsurname= request.getParameter("footballer_surname");
        int fsalary= Integer.parseInt(request.getParameter("footballer_salary"));
        String fclub= request.getParameter("footballer_club");
        int ftp= Integer.parseInt(request.getParameter("footballer_transfer_price"));
        int born_city_id = Integer.parseInt(request.getParameter("footballer_born_city_id"));

        Born_cities bc = DBManager.getBornCity(born_city_id);
        if(bc!=null){

            Footballer footballer = new Footballer(null,fname,fsurname,fsalary,fclub,ftp,bc);
            DBManager.AddFootballer(footballer);

        }

        response.sendRedirect("/home");



    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
