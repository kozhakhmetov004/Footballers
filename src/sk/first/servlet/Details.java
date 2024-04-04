package sk.first.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/details")
public class Details extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AuthUsers authUser = (AuthUsers) session.getAttribute("AUTH_DATA");


        if(authUser!=null){

            request.setAttribute("currentUser",authUser);

        }
        Long id= Long.parseLong(request.getParameter("efootballer_id"));
        String name= request.getParameter("efootballer_name");
        String surname= request.getParameter("efootballer_surname");
        int salary= Integer.parseInt(request.getParameter("efootballer_salary"));
        String club= request.getParameter("efootballer_club");
        int tp= Integer.parseInt(request.getParameter("efootballer_transfer_price"));
        int bci = Integer.parseInt(request.getParameter("efootballer_born_city_id")) ;

        Born_cities born_cities = DBManager.getBornCity(bci);
        if(born_cities!=null){
            Footballer footballer = new Footballer(id,name,surname,salary,club,tp,born_cities);
            DBManager.EditFootballer(footballer);
        }


        response.sendRedirect("/home");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id= Long.parseLong(request.getParameter("id"));
        Footballer footballer = DBManager.getFootballer(id);
        request.setAttribute("futbolist", footballer);
        request.getRequestDispatcher("/details.jsp").forward(request,response);


    }
}
