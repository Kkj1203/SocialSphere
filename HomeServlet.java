package servlets;

import dao.PostDAO;
import dao.PostDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Post;
import model.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private final PostDAO postDAO = new PostDAOImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {                                              //send url request for viewing home page
            res.sendRedirect("login");
            return;
        }
                                                                      //if authenticated then lands on home page
        List<Post> posts = postDAO.getAllPosts();
        req.setAttribute("posts", posts);
        req.getRequestDispatcher("home.jsp").forward(req, res);
    }
}
