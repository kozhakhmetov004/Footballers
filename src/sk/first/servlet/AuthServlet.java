package sk.first.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/auth")
public class AuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String redirect = "/login?error";

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        AuthUsers user = DBManager.getUser(email);

        if(user!=null){

            if(user.getPassword().equals(password)){

                HttpSession session =request.getSession();
                session.setAttribute("AUTH_DATA",user);
                redirect = "/profile";

            }

        }
        response.sendRedirect(redirect);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
