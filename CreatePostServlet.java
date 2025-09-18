package servlets;
import dao.PostDAO;
import dao.PostDAOImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Post;
import model.User;

import java.io.IOException;

@WebServlet("/createPost")
public class CreatePostServlet extends HttpServlet {
    PostDAO dao=new PostDAOImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendRedirect("home.jsp");           //if create post is directly accessed from home, do not allow and go back to home
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        User u=(User)req.getSession().getAttribute("user");
        if(u==null){res.sendRedirect("login"); return;}

                                                          //new post submission form
        String t=req.getParameter("title");
        String c=req.getParameter("content");
        Post p=new Post();

        p.setUserId(u.getUserId());
        p.setTitle(t);
        p.setContent(c);

        dao.createPost(p);
        res.sendRedirect("home");             //go back home after submission
    }
}
