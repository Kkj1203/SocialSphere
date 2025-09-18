package servlets;
import dao.UserDAO;
import dao.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {                           //sending url request and getting a register form to register
    UserDAO dao=new UserDAOImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        req.getRequestDispatcher("register.jsp").forward(req,res);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String u=req.getParameter("username");
        String p=req.getParameter("password");
        String e=req.getParameter("email");

        if(u.isEmpty()||p.isEmpty()||e.isEmpty()){
            req.setAttribute("error","All fields required");                     //sending all registration details
            req.getRequestDispatcher("register.jsp").forward(req,res);
            return;
        }
        User user=new User();
        user.setUsername(u); user.setPassword(p); user.setEmail(e);
        if(dao.registerUser(user)){                                      //validation of user and then go back to login page
            res.sendRedirect("login");
        } else {
            req.setAttribute("error","Error or username exists");
            req.getRequestDispatcher("register.jsp").forward(req,res);
        }
    }
}
