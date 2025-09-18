package servlets;
import dao.CommentDAO;
import dao.CommentDAOImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Comment;
import model.User;

import java.io.IOException;

@WebServlet("/addComment")
public class AddCommentServlet extends HttpServlet {
    CommentDAO dao=new CommentDAOImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        User u=(User)req.getSession().getAttribute("user");
        if(u==null){
            res.sendRedirect("login");
            return;                                        //form to add a comment
        }
        int pid=Integer.parseInt(req.getParameter("postId"));
        String cc = req.getParameter("comment");

        Comment c = new Comment();
        c.setUserId(u.getUserId());
        c.setPostId(pid);
        c.setCommentContent(cc);

        dao.addComment(c);
        res.sendRedirect("home");
    }
}
