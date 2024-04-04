package sk.first.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/setsession")
public class SetSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String age = request.getParameter("age");

        int finalage = 0;
        try{

            finalage = Integer.parseInt(age);

        }catch (Exception e){
            e.printStackTrace();
        }

        SessionUser sessionUser = new SessionUser(name,surname,finalage);
        HttpSession session = request.getSession();
        session.setAttribute("USER_DATA",sessionUser);
        response.sendRedirect("/sessions");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
