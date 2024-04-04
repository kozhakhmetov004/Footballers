package sk.first.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/addblog")
public class AddBlog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String redirect="login";
        HttpSession session = request.getSession();
        AuthUsers authUser = (AuthUsers) session.getAttribute("AUTH_DATA");


        if(authUser!=null){
            redirect = "/";

            String title = request.getParameter("title");
            String short_content = request.getParameter("short_content");
            String content = request.getParameter("content");

            Blogs blog = new Blogs(null,authUser,title,short_content,content,null);
            if(DBManager.addBlog(blog)){
                redirect="/addblog?success";
            }

        }
        response.sendRedirect(redirect);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        AuthUsers authUser = (AuthUsers) session.getAttribute("AUTH_DATA");


        if(authUser!=null){

            request.setAttribute("currentUser",authUser);
            request.getRequestDispatcher("/addblog.jsp").forward(request,response);

        }



    }
}
