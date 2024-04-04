package sk.first.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/sessions")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        SessionUser sessionUser = (SessionUser) session.getAttribute("USER_DATA");


        if(sessionUser!=null) {
            request.setAttribute("name", sessionUser.getName());
            request.setAttribute("surname", sessionUser.getSurname());
            request.setAttribute("age", sessionUser.getAge()+"");
        }


        request.getRequestDispatcher("/session.jsp").forward(request,response);

    }
}
