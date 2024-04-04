package sk.first.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/delete")
public class Delete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        AuthUsers authUser = (AuthUsers) session.getAttribute("AUTH_DATA");


        if(authUser!=null){

            request.setAttribute("currentUser",authUser);

        }

        Long id= Long.parseLong(request.getParameter("id"));
        Footballer footballer = DBManager.getFootballer(id);
        DBManager.DeleteFootballer(footballer);
        response.sendRedirect("/home");

    }
}
