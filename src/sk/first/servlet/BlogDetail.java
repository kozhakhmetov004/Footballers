package sk.first.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/blogdetail")
public class BlogDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        AuthUsers authUser = (AuthUsers) session.getAttribute("AUTH_DATA");

        if(authUser!=null){

            request.setAttribute("currentUser",authUser);

        }

        Long blog_id = 0L;

        try{
            blog_id=Long.parseLong(request.getParameter("id"));
        }catch (Exception e){
            e.printStackTrace();
        }

        Blogs blog = DBManager.getBlog(blog_id);
        request.setAttribute("blog",blog);
        request.getRequestDispatcher("/blogdetail.jsp").forward(request,response);

    }
}
