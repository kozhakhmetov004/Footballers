package sk.first.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addcookie")
public class Addcookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("cookiename");
        String surname = request.getParameter("cookiesurname");
        String age = request.getParameter("cookieage");
        String country = request.getParameter("cookiecountry");
        String gender = request.getParameter("cookiegender");
        String card = request.getParameter("cookiecard");

        Cookie cookiename = new Cookie("cookiename",name);
        Cookie cookiesurname = new Cookie("cookiesurname",surname);
        Cookie cookieage = new Cookie("cookieage",age);
        Cookie cookiecountry = new Cookie("cookiecountry",country);
        Cookie cookiegender = new Cookie("cookiegender",gender);
        Cookie cookiecard = new Cookie("cookiecard",card);

        cookieage.setMaxAge(1000000000*1000000000*1000000000*1000000000);
        cookiecard.setMaxAge(1000000000*1000000000*1000000000*1000000000);
        cookiename.setMaxAge(1000000000*1000000000*1000000000*1000000000);
        cookiegender.setMaxAge(1000000000*1000000000*1000000000*1000000000);
        cookiecountry.setMaxAge(1000000000*1000000000*1000000000*1000000000);
        cookiesurname.setMaxAge(1000000000*1000000000*1000000000*1000000000);

        response.addCookie(cookieage);
        response.addCookie(cookiecard);
        response.addCookie(cookiecountry);
        response.addCookie(cookiegender);
        response.addCookie(cookiename);
        response.addCookie(cookiesurname);

        response.sendRedirect("/cookieServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        
    }
}
